package com.danielpm1982.REST_WS7.ws;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.List;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.springframework.beans.factory.annotation.Value;

public class FileManagerWSImpl implements FileManagerWS{
	@Value("${baseDestinationFilePathString}")
	private String baseDestinationFilePathString;
	@Override
	public void upload(List<Attachment> attachmentList) {
		for(Attachment attachment:attachmentList) {
			if(attachment.getContentDisposition().getFilename()!=null&&!attachment.getContentDisposition().getFilename().isEmpty()) {
				try {
					copyInputStreamToFile(attachment.getDataHandler().getInputStream(), baseDestinationFilePathString+LocalDateTime.now().toString()+"_"+attachment.getContentDisposition().getFilename());
					Thread.sleep(100); //delay for avoiding rewriting with the same file name (and time)
				} catch (InterruptedException | IOException e) {
					System.out.println(e.getCause()+": "+e.getMessage());
				}
			}
		}
	}
	private void copyInputStreamToFile(InputStream inputStream, String filePathString) throws IOException{
		Files.copy(inputStream, Paths.get(filePathString), StandardCopyOption.REPLACE_EXISTING);
	}
	@Override
	public Response download(String fileName) {
		try {
			String pathString = baseDestinationFilePathString+fileName;
			File downloadingFile = Paths.get(pathString).toFile();
			String contentDispositionValue = "attachement;filename="+fileName;
			return Response.ok(downloadingFile).header("Content-Disposition", contentDispositionValue).header("File-Name", fileName).build();
		} catch (Exception e) {
			System.out.println(e.getCause()+": "+e.getMessage());
			return Response.serverError().status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}

/*
The two interface methods are implemented here, both for uploading as for downloading files from the Consumer server, using a POST and a GET
request, respectively (see comments at the interface class).
At the upload method, the list of Attachments sent from the Consumer is iterated and, for each Attachment, its dataHandler and inputStream is got 
and later copied (saved) to a fileSystem local path, generated from the baseDestinationFilePathString (the IOFiles folder path) plus the uploaded 
file name, composed, in turn, of a localDateTime (for uniqueness) and the original name of the file, obtained from the contentDisposition object of 
each attachment.
At the download method, a path is created for the file that's been downloaded, composed of the same IOFiles folder path (baseDestinationFilePathString)
plus the fileName, sent as the pathParam at the GET resquest from the client (other params could have been used instead). From this path, a File object
is created and returned as the wrapped entity, inside the Response of the method, adding at this Response also the "Content-Disposition" and "File-Name"
headers for the Consumer server to use. At the Consumer server, this File inpuStream is got from the Response Entity and saved locally as a real file
at the fileSystem of the Consumer server (or of its clients', for ex. the mobile phone fileSystem accessing the Consumer server). 
See the Consumer server classes comments for more.
*/
