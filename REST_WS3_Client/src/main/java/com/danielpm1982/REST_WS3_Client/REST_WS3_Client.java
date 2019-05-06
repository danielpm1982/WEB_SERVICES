package com.danielpm1982.REST_WS3_Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class REST_WS3_Client {
	public static void main(String[] args) {
		SpringApplication.run(REST_WS3_Client.class, args);
	}
}

/*
This project is intended to testing Asynchronous REST callings (Consumer) and responses (Provider),
that is, testing both the calling to the WebService as well as the processing of the request at
the Webservice using parallel threads for each request and for each request processing.

I've not yet adapted the code of this project for Web use, but it's ready to be tested at the console,
by running the standalone TestHelper.java class, which, in turn, makes multiple calls to the HelperImpl
class, sending a ResourcesList, at each request, with Resources to be processed at the Provider.
The processing here is basically to turn the checked boolean attribute to true instead of false, but could
be any other kind of remote processing (at the Provider through a REST call).

For more, see the helper, gui and model packages, as well as the comments at the HelperImpl class.

Also, for the Provider, see the REST_WS3 server project, which must be set to run before running this client
server, that will consume the services that one.

Both the consuming invoking requests from the Consumer as well as the processing and response from the 
Provider are done in parallel using threads... and for that, 3 strategies are exemplified, using the functional
interfaces Runnable, Callable and Supplier, as well as the thread managing Thread, ExecutorService, Future and
CompletableFuture java APIs.

No dependencies are needed other than the ones we've already used at past projects (for REST implementation, 
only the cxf-rt-rs-client dependency - see the POM.xml).

For asynchronous REST, the main objects of the API are @Suspended asyncResponse (at the Provider) and the
asyncInvokator (at the Consumer), which returns a Future object to be read into a separate thread (see the
HelperImpl class at the Consumer, and the ResourcesManagerWSImpl class at the provider).   
*/
