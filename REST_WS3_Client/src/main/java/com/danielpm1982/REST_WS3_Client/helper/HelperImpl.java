package com.danielpm1982.REST_WS3_Client.helper;
import java.security.SecureRandom;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.swing.JFrame;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.danielpm1982.REST_WS3_Client.gui.MyJFrame;
import com.danielpm1982.REST_WS3_Client.model.Resource;
import com.danielpm1982.REST_WS3_Client.model.ResourcesList;

@Service
public class HelperImpl implements Helper {
	private final String RESOURCES_URL;
	private final ExecutorService executorService;
	public HelperImpl(@Value("${resourcesURL}") String resourcesURL) {
		this.RESOURCES_URL=resourcesURL;
		executorService = Executors.newCachedThreadPool();
	}
	@Override
	public void processResources(Resource... resources) { //constructs a ResourcesList from a ResourcesArray and delegates the call to the overloaded Constructor below.
		ResourcesList resourcesList = new ResourcesList(resources);
		processResources(resourcesList);
	}
	@Override
	public synchronized void processResources(ResourcesList resourcesList) { //sends an unprocessed ResourcesList (checked attribute equals false) to a RESOURCES_URL REST WebService for processing (turning checked=true). Each Future response is paralleled into a separate thread, for having the response read when it's done and sent back from the Provider. The parallelizing can be done with Runnable, Callable or Supplier functional anonymous interfaces (with or without lambda), and called by threads managed by Thread, ExecutorService or CompleatableFuture services. The three options are exemplified below. If the AsyncInvoker method returned a CompletableFuture instead of a Future result, readResourcesListFutureWhenDone method wouldn't be needed, as we wouldn't have to keep checking if the response was available until it's done. We'd just use "thenAccept" at the CompletedFuture returned from the invoker to consume the processed ResourcesList (when the first stage result was already done to be consumed - the checking would be done by the CompletableFuture API itself). Even if we use the CompletableFuture, as below, we can't transform the Future asyncInvoker result into a CompletableFuture one. Thus, we still need the read method for checking when the Future is done, before using it in any of the 3 Consuming strategies below. The API may be updated in the future to use CompletableFuture instead, at the invoker result... which would certainly avoid a lot of unnecessary lines on the getting and consuming process code.  
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(RESOURCES_URL);
		AsyncInvoker asyncInvoker = target.request().async();
		Future<ResourcesList> resourcesListFuture = asyncInvoker.post(Entity.entity(resourcesList, MediaType.APPLICATION_XML), ResourcesList.class);
//GETTING AND CONSUMING resourcesListFuture - STRATEGY 1:
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				ResourcesList resourcesListFutureResult = readResourcesListFutureWhenDone(resourcesListFuture);
//				System.out.println(Thread.currentThread().getName()+" ended. Processed ResourcesList: "+resourcesListFutureResult+".");
//				showResourcesListAtGui(Thread.currentThread().getName(), resourcesListFutureResult);
//			}
//		}).start();
//GETTING AND CONSUMING resourcesListFuture - STRATEGY 2:
//		executorService.submit(()-> { //creating a thread through ExecutorService and running a Callable functional implemented interface (declared through lambda).  
//				try {
//					ResourcesList resourcesListFutureResult = readResourcesListFutureWhenDone(resourcesListFuture);
//					System.out.println(Thread.currentThread().getName()+" ended. Processed ResourcesList: "+resourcesListFutureResult+".");
//					showResourcesListAtGui(Thread.currentThread().getName(), resourcesListFutureResult);
//				} catch (Exception e) {
//					System.err.println(e.getMessage());
//				}
//		}, Void.TYPE);
//GETTING AND CONSUMING resourcesListFuture - STRATEGY 3:
		CompletableFuture.supplyAsync(()-> {
			return readResourcesListFutureWhenDone(resourcesListFuture);
		}, executorService).thenAccept(x-> {
			System.out.println(Thread.currentThread().getName()+" ended. Processed ResourcesList: "+x+".");
			showResourcesListAtGui(Thread.currentThread().getName(), x);
		});
	}
	private synchronized ResourcesList readResourcesListFutureWhenDone(Future<ResourcesList> resourcesListFuture) { //called in parallel from each thread, this method reads the ResourceList Future result from the Provider to get the processed WS ResourceList.
		while(!resourcesListFuture.isDone()) {
			try {
				int randomDelayTimeInMillis = new SecureRandom().ints(500, 4001).findAny().getAsInt(); //optional random delay of 0.5-4 seconds before trying to get the Future ResourcesList response.
				System.out.println("ResourcesListFuture not done yet !! Client thread"+Thread.currentThread().getName()+" sleeping for "+randomDelayTimeInMillis/1000f+"s...");
				wait(randomDelayTimeInMillis);
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
		}
		try {
			return resourcesListFuture.get(); //returns the processed ResourcesList when the Future response is done.
		} catch (InterruptedException | ExecutionException e) {
			if(e.getCause() instanceof InternalServerErrorException) {
				System.err.println("Empty or null ResourcesList sent ? An internal Server Error has occured at the Provider !");
			}
			return null;
		} finally {
			notifyAll();
		}
	}
	private void showResourcesListAtGui(String threadName, ResourcesList resourcesList) { //simply shows at a JPanel the ResourcesList processed (checked=true). One JPanel per thread (request).
		MyJFrame myJFrame = new MyJFrame(threadName, resourcesList);
        myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myJFrame.pack();
        myJFrame.setResizable(false);
		myJFrame.setLocation(new SecureRandom().ints(500, 1000).findAny().getAsInt(), new SecureRandom().ints(100, 600).findAny().getAsInt());
        myJFrame.setVisible(true);
	}
	@Override
	public void finalizeHelperImpl() { //finalizes this HelperImpl class object by shutting down all threads after a 5s timeout. 
		executorService.shutdown();
		System.out.println("Fininshing all threads in 5 seconds...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(!executorService.isTerminated()) {
			executorService.shutdownNow();
		}
		System.out.println("All threads have ended ! Program has ended !");
		System.exit(0);
	}
}

/*
This @Service class is an Spring Enterprise Bean which implements all remote REST Services call at a local client
context, and is expected to be injected at other classes, for ex. at the local WSController class, in order to
have its methods call each service through the main cxf-rt-rs-client dependency objects which are: ClientBuilder,
Client, WebTarget and AsyncInvoker. It's important to abstract all this code from the Controller, which,
thus, cares to call only this @Service interface methods, and no rest specific api methods or objects. For this
project this class has been adapted only to a console view, not for a web view. It's called from the TestHelper 
Standalone Main class.
*/
