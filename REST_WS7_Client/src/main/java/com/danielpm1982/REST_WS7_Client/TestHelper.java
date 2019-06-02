package com.danielpm1982.REST_WS7_Client;
import com.danielpm1982.REST_WS7_Client.helper.Helper;
import com.danielpm1982.REST_WS7_Client.helper.HelperImpl;

public class TestHelper {
	private final static String UPLOAD_URL = "http://localhost:8080/REST_WS7/api/fileManager/upload";
	private final static String FILE_TO_UPLOAD_PATH_STRING_1 = "/home/daniel/eclipse-workspace/REST_WS7_Client/src/main/java/com/danielpm1982/REST_WS7_Client/IOFiles/earth.png";
	private final static String FILE_TO_UPLOAD_PATH_STRING_2 = "/home/daniel/eclipse-workspace/REST_WS7_Client/src/main/java/com/danielpm1982/REST_WS7_Client/IOFiles/picture.jpg";
	private final static String FILE_TO_UPLOAD_PATH_STRING_3 = "/home/daniel/eclipse-workspace/REST_WS7_Client/src/main/java/com/danielpm1982/REST_WS7_Client/IOFiles/0-18yrs-child-combined-schedule.pdf";
	private final static String FILE_TO_UPLOAD_PATH_STRING_4 = "/home/daniel/eclipse-workspace/REST_WS7_Client/src/main/java/com/danielpm1982/REST_WS7_Client/IOFiles/text.txt";
	private final static String FILE_TO_UPLOAD_PATH_STRING_5 = "/home/daniel/eclipse-workspace/REST_WS7_Client/src/main/java/com/danielpm1982/REST_WS7_Client/IOFiles/Pater Noster - Our Father in Latin.mp3";
	private final static String DOWNLOAD_BASE_URL = "http://localhost:8080/REST_WS7/api/fileManager/download";
	private final static String FILE_TO_DOWNLOAD_NAME_1 = "downloadTestFile1.png";
	private final static String FILE_TO_DOWNLOAD_NAME_2 = "downloadTestFile2.jpg";
	private final static String FILE_TO_DOWNLOAD_NAME_3 = "downloadTestFile3.pdf";
	private final static String FILE_TO_DOWNLOAD_NAME_4 = "downloadTestFile4.txt";
	private final static String FILE_TO_DOWNLOAD_NAME_5 = "downloadTestFile5.mp3";
	private final static String DESTINE_LOCAL_FOLDER = "/home/daniel/eclipse-workspace/REST_WS7_Client/src/main/java/com/danielpm1982/REST_WS7_Client/IOFiles/";
	public static void main(String[] args) {
		Helper helper = new HelperImpl();
		helper.upload(UPLOAD_URL, 
				FILE_TO_UPLOAD_PATH_STRING_1, 
				FILE_TO_UPLOAD_PATH_STRING_2, 
				FILE_TO_UPLOAD_PATH_STRING_3, 
				FILE_TO_UPLOAD_PATH_STRING_4, 
				FILE_TO_UPLOAD_PATH_STRING_5
		);
		helper.download(DOWNLOAD_BASE_URL, 
				DESTINE_LOCAL_FOLDER, 
				FILE_TO_DOWNLOAD_NAME_1, 
				FILE_TO_DOWNLOAD_NAME_2, 
				FILE_TO_DOWNLOAD_NAME_3, 
				FILE_TO_DOWNLOAD_NAME_4, 
				FILE_TO_DOWNLOAD_NAME_5
		);
	}
}

/*
StandAlone console testing class. Start the Provider server before running this class as a java application.
This app can and should be tested using also its Web user interface. For this, start both Provider and 
Consumer servers, and open the application (client) at your browser (http://localhost:8181/REST_WS7_Client).
After uploading and downloading the files, manually update and check the IOFiles folders, at both servers,
in order to see if the files have really been uploaded and downloaded as required. Then delete the new
files (the ones starting with a dateTime string), at both servers (IOFiles), but not the original files.
*/
