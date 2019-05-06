package com.danielpm1982.REST_WS3_Client;
import java.security.SecureRandom;
import com.danielpm1982.REST_WS3_Client.helper.Helper;
import com.danielpm1982.REST_WS3_Client.helper.HelperImpl;
import com.danielpm1982.REST_WS3_Client.model.Resource;
import com.danielpm1982.REST_WS3_Client.model.ResourcesList;

public class TestHelper {
	private static final String RESOURCES_URL="http://localhost:8080/REST_WS3/api/resourcesManager/resources";
	private static final int RESOURCE_LIST_NUMBER_TO_PROCESS = 10;
	private static final int TIMEOUT_TO_SHUTDOWN_IN_MILLIS = 30000;
	public static void main(String[] args) {
		Helper helper = new HelperImpl(RESOURCES_URL);
		for(int i=1;i<=RESOURCE_LIST_NUMBER_TO_PROCESS;i++) {
			helper.processResources(getResourcesListSample());
		}
		new Thread(new Runnable() { //created a thread for, after 10s, call the helper finalize method to close all threads.
			@Override
			public void run() {
				try {
					Thread.sleep(TIMEOUT_TO_SHUTDOWN_IN_MILLIS);
					helper.finalizeHelperImpl();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		System.out.println("\n\n*******************************************************************");
		System.out.println("Main Thread ended... waiting other threads to finish as well...\nclose all thread's windows, at the end, for the program to finish !");
		System.out.println("*******************************************************************\n\n\n");
	}
	private static ResourcesList getResourcesListSample() { //send randomly chosen resources lists to process. 
		return new ResourcesList(getResourcesArraySample());
	}
	private static Resource[] getResourcesArraySample() {
		int[] randomThreeIntArray = new SecureRandom().ints(1000,10001).limit(3).toArray();
		Resource resource1 = new Resource(randomThreeIntArray[2], "resourceName"+randomThreeIntArray[2]);
		Resource resource2 = new Resource(randomThreeIntArray[1], "resourceName"+randomThreeIntArray[1]);
		Resource resource3 = new Resource(randomThreeIntArray[0], "resourceName"+randomThreeIntArray[0]);
		return new Resource[]{resource1, resource2, resource3};
	}
}

/*
For testing the Helper class, just start the REST_WS3 Provider server, then run this standalone main class
as a Java Application.
*/
