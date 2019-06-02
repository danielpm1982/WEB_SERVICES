package com.danielpm1982.REST_WS7_Client.helper;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.ws.rs.core.Response;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.ContentDisposition;
import org.springframework.stereotype.Service;

@Service
public class HelperImpl implements Helper {
	public HelperImpl() {
	}
	@Override
	public void upload(String uploadURL, String... fileToUploadPathStringArray){
		WebClient client = WebClient.create(uploadURL);
		client.type("multipart/form-data");
		List<Attachment> attachmentList = Arrays.asList(fileToUploadPathStringArray).stream().map(x->getAttachment(x)).filter(x->x!=null).collect(Collectors.toList());
		client.post(attachmentList);
	}
	private Attachment getAttachment(String fileToUploadPathString){
		ContentDisposition contentDisposition = new ContentDisposition("attachement;filename="+getFileNameFromPathString(fileToUploadPathString));
		try {
			return new Attachment("root", getInputStreamFromPathString(fileToUploadPathString), contentDisposition);
		} catch (IOException e) {
			System.out.println(e.getCause()+": "+e.getMessage());
			return null;
		}
	}
	private String getFileNameFromPathString(String pathString) {
		int length = pathString.split("/").length;
		return pathString.split("/")[length-1];
	}
	private InputStream getInputStreamFromPathString(String fileToUploadPathString) throws IOException {
		return Files.newInputStream(Paths.get(fileToUploadPathString));
	}
	@Override
	public void download(String downloadURL, String destineLocalFolder, String... fileNameArray) {
		Arrays.asList(fileNameArray).forEach(x->downloadAndSaveFile(downloadURL, destineLocalFolder, x));
	}
	private void downloadAndSaveFile(String downloadURL, String destineLocalFolder, String fileName) {
		try {
			WebClient client = WebClient.create(downloadURL+"/"+fileName);
			Response response = client.get();
			InputStream inputStream = (InputStream)response.getEntity();
			Path path = Paths.get(destineLocalFolder+LocalDateTime.now()+"_"+response.getHeaderString("File-Name"));
			Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}

/*
This helper interface implementing class implements the two public methods upload and download using the CXF API object WebClient.
The private methods here are merely for convenience and for abstracting some of the implementation from the upload and download 
methods themselves and specially for reusing these private methods' code at the various iterations of each file path being processed.

At this Consumer local helper upload method, the customizable uploadURL path of the remote Provider webService is passed, along with
an array of paths for each file being uploaded. A WebClient CXF object is created for the general uploadURL, which is the same
for all uploads, and the "multipart/form-data" is set as the type of data being uploaded through this WebClient to the remote Provider
server. Then, the fileToUploadPathStringArray is processed using streams java API and each file path is internally iterated and mapped
(transformed) to an Attachment object, using the getAttachment private method. The list of all Attachaments is thus sent to the Provider
server upload webService using a WebClient post method with the list of Attachments as argument. At the Provider, at the webService
implementing class, this list is then received and the Attachments processed to get the inputStream of every file and save there. See the
Provider webService implementing class for more. Still regarding the this helper class, when the getAttachment is called for each file
path being uploaded, the private method also creates a ContentDisposition object, with the file of each file being sent, and this 
ContentDisposition object is used at the creation of the Attachment, along with the Attachment id name and the inputStream of the 
uploading file. At the creation of the ContentDisposition object, the fileName alone is got from the fileToUploadPathStringArray using
the private method getFileNameFromPathString. At the creation of the Attachment, the inpuStream of the uploading file is got through the
getInputStreamFromPathString private method, which also uses the fileToUploadPathStringArray of each file and returns its inputStream.
That is, for refactoring purposes, and for a more clean code, the upload method uses the getAttachment private method, which, in turn, 
uses both the getFileNameFromPathString and getFileNameFromPathString private ones. The getAttachment then returns the Attachment for
each file of the fileToUploadPathStringArray, which is sent, finally, to the Provider POST endpoint as a list of Attachments.

The helper download method, at this class, is similar to the upload one. It basically receives the base downloadURL, the destineLocalFolder 
(where the downloading files are meant to be saved to) and an array of fileNames which must exist at the Provider IOFiles directory in order 
to be downloaded, one at a time. This array is then iterated using java streams, and, for refactoring purposes, and for reuse, the private 
method downloadAndSaveFile is called for processing the download of each fileName passed to the download method. At the downloadAndSaveFile 
method, the partial downloadURL of the download Provider endPoint must still have the argument fileName (pathParam) concatenated to it before 
being used to create the WebClient object. Differently from the upload webService, the download webService endpoint is different for each 
file-name being downloaded, as the fileName constitutes the pathParam that is part of the endPoint URI. So, one new call to the download 
webService is done for each file the Consumer wants to download (at the upload service, it is a bulk single operation). When the WebClient is
created and the get method is called for that endPoint (downloadURL+"/"+fileName), a Response is got from the Provider with the inputStream
of the downloading file wrapped inside it as the Entity. The Entity (of the downloading file) is then downcasted to an InpuStream, which
has its data saved at a local path, with the PathString (local file name) composed of the destineLocalFolder (IOFiles), plus the 
LocalDateTime, plus the fileName of the downloading file got from the Response header "File-Name". This way, the requested files are
downloaded from the Provider server and saved locally at the Consumer server using the Provider REST webService download method.    

See the comments at this server main class (REST_WS7_Client) for information on how to customize the 4 custom paths at the properties file.

And for more comments read the other classes of this Consumer server app, as well as the comments at the Provider server classes.
*/
