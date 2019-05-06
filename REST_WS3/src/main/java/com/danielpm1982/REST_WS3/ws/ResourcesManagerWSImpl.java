package com.danielpm1982.REST_WS3.ws;
import java.security.SecureRandom;
import java.util.concurrent.CompletableFuture;
import javax.ws.rs.container.AsyncResponse;
import org.springframework.stereotype.Service;
import com.danielpm1982.REST_WS3.exception.FailedToProcessResourcesRuntimeException;
import com.danielpm1982.REST_WS3.model.ResourcesList;

@Service
public class ResourcesManagerWSImpl implements ResourcesManagerWS{
	public ResourcesManagerWSImpl() {
	}
	@Override
	public void processResources(AsyncResponse asyncResponse, ResourcesList resourcesList) {
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				if(resourcesList==null || resourcesList.getResourcesList()==null || resourcesList.getResourcesList().isEmpty()) {
//					asyncResponse.resume(new FailedToProcessResourcesRuntimeException("Could not process Client resources. Resources list is null or empty !"));
//				} else {
//					try {
//						int randomDelayTimeInMillis = new SecureRandom().ints(2000, 10001).findAny().getAsInt(); //optional random delay of 2-10 seconds for each processResources thread or webService request.
//						Thread.sleep(randomDelayTimeInMillis);
//					} catch (InterruptedException e) {
//						System.err.println(e.getMessage());
//					}
//					resourcesList.getResourcesList().forEach(x->x.setChecked(true));
//					asyncResponse.resume(resourcesList);
//				}
//			}
//		}).start();
		CompletableFuture.supplyAsync(()->{
			if(resourcesList==null || resourcesList.getResourcesList()==null || resourcesList.getResourcesList().isEmpty()) {
				asyncResponse.resume(new FailedToProcessResourcesRuntimeException("Could not process Client resources. Resources list is null or empty !"));
				return null;
			} else {
				try {
					int randomDelayTimeInMillis = new SecureRandom().ints(2000, 10001).findAny().getAsInt(); //optional random delay of 2-10 seconds for each processResources' thread or webService request.
					Thread.sleep(randomDelayTimeInMillis);
				} catch (InterruptedException e) {
					System.err.println(e.getMessage());
				}
				resourcesList.getResourcesList().forEach(x->x.setChecked(true));
				asyncResponse.resume(resourcesList);
				return resourcesList;
			}
		}).thenAccept(x->System.out.println("Provider server successfully processed and returned the next ResourceList to the Consumer client: "+x));
	}
}

/*
At this REST service implementing class, it can be used any strategy to generate threads inside the processing method, so that, 
for each method request, a thread will be generated to process and treat the resourcesList argument, as well as to use the
AsyncResponse object to resume a response or an exception to the Consumer client, returning the processed resourcesList, in this case. 
*/
