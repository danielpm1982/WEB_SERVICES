package com.danielpm1982.SOAP_WS4.ws;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import org.apache.cxf.feature.Features;

@Features(features="org.apache.cxf.feature.LoggingFeature")
public class MTOMFileManagerWSImpl implements MTOMFileManagerWS {
	private final String UPLOADED_DIRECTORY_PATH_STRING = "/home/daniel/eclipse-workspace/SOAP_WS4/target/classes/static/files/uploaded";
	private final String UPLOADING_FILE_PATH_STRING = UPLOADED_DIRECTORY_PATH_STRING+"/uploadedFile.png";
	private final Path UPLOADED_DIRECTORY_PATH=Paths.get(UPLOADED_DIRECTORY_PATH_STRING);
	private final Path UPLOADING_FILE_PATH=Paths.get(UPLOADING_FILE_PATH_STRING);
	@Override
	public void upload(DataHandler dataHandler) {
		OutputStream outputStream=null;
		InputStream inputStream=null;
		try {
			createUploadDirectoryAndFile();
			outputStream = Files.newOutputStream(UPLOADING_FILE_PATH, StandardOpenOption.CREATE);
			inputStream = dataHandler.getInputStream();
			writeOutputStreamFromInputStream(inputStream, outputStream);
		} catch (IOException e) {
			e.printStackTrace(System.out);
		} finally {
			try {
				if(outputStream!=null) {
					outputStream.close();
				}
				if(inputStream!=null) {
					inputStream.close();
				}
			}catch (Exception e) {
				e.printStackTrace(System.out);
			}
		}
	}
	private void createUploadDirectoryAndFile() throws IOException {
		if(!UPLOADED_DIRECTORY_PATH.toFile().exists()) {
			Files.createDirectories(UPLOADED_DIRECTORY_PATH);
		}
		if(!UPLOADING_FILE_PATH.toFile().exists()) {
			Files.createFile(UPLOADING_FILE_PATH);
		}
	}
	private void writeOutputStreamFromInputStream(InputStream inputStream, OutputStream outputStream) throws IOException{
		byte[] byteArray = new byte[100000];
		int bytesRead = 0;
		while ((bytesRead = inputStream.read(byteArray))!=-1) {
			outputStream.write(byteArray, 0, bytesRead);
		}
	}
	@Override
	public DataHandler download() {
		return new DataHandler(new FileDataSource(UPLOADING_FILE_PATH_STRING));
	}
}

/*
This is the PortType implementation that will be used at the consumer server side for accessing the 
fileManager webService.
The Consumer server side will send an attached file (byte array) to the Provider server side, along with the 
xml message, and, at the upload method above, that file will be handled by the DataHandler, from which an 
inputStream can be got in order to send the incoming file data to a local outputStream file, at the Provider side.
If the Consumer server side then tries to make a download, it will receive that file, or any other (as set at 
the download method Path), as a byte array, which could likewise have its data got from and eventually stored 
as a local file, through an outputStream, at the Consumer side. At the Consumer server side, instead of an 
uploaded directory or uploadingFile, it should be created a downloaded directory and downloadingFile.
If both sides would change files both ways though, then both would have upload and download folders and files.
*/
