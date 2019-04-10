package com.danielpm1982.SOAP_WS4_Client;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.danielpm1982.soap_ws4.ws.MTOMFileManagerWS;
import com.danielpm1982.soap_ws4.ws.MTOMFileManagerWSImplService;

public class SOAP_WS4_Client_Console {
	private static MTOMFileManagerWSImplService service;
	private static MTOMFileManagerWS fileManagerPortType;
	private static final String UPLOADED_DIRECTORY_PATH_STRING = "/home/daniel/eclipse-workspace/SOAP_WS4_Client/target/classes/static/img";
	private static final String UPLOADING_FILE_PATH_STRING = UPLOADED_DIRECTORY_PATH_STRING+"/fileToUpload.png";
	private static final Path UPLOADING_FILE_PATH = Paths.get(UPLOADING_FILE_PATH_STRING);
	private static final String DOWNLOADED_DIRECTORY_PATH_STRING = "/home/daniel/eclipse-workspace/SOAP_WS4_Client/target/classes/static/files/downloaded";
	private static final String DOWNLOADING_FILE_PATH_STRING = DOWNLOADED_DIRECTORY_PATH_STRING+"/downloadedFile.png";
	private static final Path DOWNLOADED_DIRECTORY_PATH = Paths.get(DOWNLOADED_DIRECTORY_PATH_STRING);
	private static final Path DOWNLOADING_FILE_PATH = Paths.get(DOWNLOADING_FILE_PATH_STRING);
	public static void main(String[] args) {
		try {
			service = new MTOMFileManagerWSImplService(new URL("http://localhost:8080/SOAP_WS4/api/MTOMFileManagerService?wsdl"));
			fileManagerPortType = service.getMTOMFileManagerWSImplPort();
			testUploading(fileManagerPortType);
			testDownloading(fileManagerPortType);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	private static void testUploading(MTOMFileManagerWS fileManagerWSPortType) throws IOException {
		InputStream inputStream = Files.newInputStream(UPLOADING_FILE_PATH);
		fileManagerWSPortType.upload(getByteArrayFromInputStream(inputStream));
	}
	private static void testDownloading(MTOMFileManagerWS fileManagerWSPortType) throws IOException {
		byte[] downloadedByteArray = fileManagerWSPortType.download();
		createDownloadDirectoryAndFile();
		OutputStream outputStream = Files.newOutputStream(DOWNLOADING_FILE_PATH);
		outputStream.write(downloadedByteArray);
	}
	private static void createDownloadDirectoryAndFile() throws IOException {
		if(!DOWNLOADED_DIRECTORY_PATH.toFile().exists()) {
			Files.createDirectories(DOWNLOADED_DIRECTORY_PATH);
		}
		if(!DOWNLOADING_FILE_PATH.toFile().exists()) {
			Files.createFile(DOWNLOADING_FILE_PATH);
		}
	}
	private static byte[] getByteArrayFromInputStream(InputStream inputStream) throws IOException{
		List<Byte> resultByteList = new ArrayList<>();
		byte[] bufferedByteArray = new byte[100000];
		while (inputStream.read(bufferedByteArray)!=-1) {
			for(byte b:bufferedByteArray) {
				resultByteList.add(Byte.valueOf(b));
			}
		}
		byte[] resultByteArray = new byte[resultByteList.size()];
		for(int i=0; i<resultByteList.size();i++) {
			resultByteArray[i]=resultByteList.get(i).byteValue();
		}
		return resultByteArray;
	}
}
