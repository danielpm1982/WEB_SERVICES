package com.danielpm1982.REST_WS7_Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class REST_WS7_Client {
	public static void main(String[] args) {
		SpringApplication.run(REST_WS7_Client.class, args);
	}
}

/*
This is a Client server for the REST_WS7 Provider server. 
Some comments about the application and the Provider implementation are available at the Provider classes.
Through this Client Consumer server, any client (browser, smart tv, mobile phone, etc) can access this Provider
Server REST interface, uploading and downloading files.
The main objects at the Provider side are Attachment and Response, and the main ones at the Consumer side are 
WebClient, ContentDisposition, Attachment and Response (see other classes's comments for more).
No additional dependency is needed. All objects above are included at the CXF JAX-RS dependency at the
Provider as well as at the CXF Client at the Consumer.
At the properties file, 4 custom paths have been defined:
- the upload endpoint mapping path for the Provider REST upload webService: 'upload_url';
- the download endpoint partial mapping path for the Provider REST download webService: 'download_base_url' 
(which is concatenated with the downloading fileName - pathParam - before the request is sent);
- the 'source_local_folder', where the uploading files are found (do not delete them!): Consumer server IOFiles folder;
- the 'destine_local_folder', where the downloading files from the Provider will be saved: Consumer server IOFiles folder.
Before testing this app, change the first 2 paths above (upload and download Provider service paths) according to the 
localIP where the Provider server will be running at (in my case it is 10.0.0.145). Also, change the other 2 paths above
(source and destine folders) according to your local fileSystem directory structure to existing folders at your own machine.
The source and destine directories can differ, and don't have to be the same. All application is refactored and parameterized
in order to use only these 4 customizable paths... and no other changes should be needed.
For more comments see the other classes.
For accessing both the upload and download Provider services, two approaches can be used and are fully demonstrated here.
One is to send the POST and GET requests directly from a web interface (form/input type=file for the upload of the Attachments
list and links for the download of each provider server file)... see JSPs (upload2 and download2 JSP pages).  
Another is to use CXF WebClient interface, in both cases, which is done at the Helper interface and concrete class (see helper 
folder), for encapsulation and reuse.
For testing all application (upload as well as download to and from the Provider), a console standAlone TestHelper class has
been created, and only the Provider server must be started for this testing client class to be able to run successfully.
If one wishes to test this application using the Web user interface, though, both servers should be started (Provider and Consumer).
The original IOFiles content at the Consumer as well as at the Provider sides should not be deleted. Only the uploaded files at
the Provider side and the downloaded files at the Consumer side (both at IOFiles folder of each server) could be erased each time
the app runs for test (all files at the IOFiles folders, beginning with a dateTime string, can be deleted).
Considering the Web user interface, and when the CXF API is to be used (upload1 and download1 JSP pages), the flux of the client 
request is sent firstly to an upload or download local Controller and, from there, the same helper class is used to access the 
remote REST services, similar to when the console TestHelper standAlone class runs. As previously said, this request flux could also 
be directly sent, as when forwarded from the upload1 or download1 JSP pages. 
See other comments at each class.
*/
