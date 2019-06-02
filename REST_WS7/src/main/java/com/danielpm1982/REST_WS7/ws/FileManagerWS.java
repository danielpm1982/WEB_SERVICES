package com.danielpm1982.REST_WS7.ws;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;

@Path("/fileManager")
public interface FileManagerWS {
	@Path("/upload")
	@POST
	public abstract void upload(List<Attachment> attachmentList);
	@Path("/download/{fileName}")
	@GET
	public abstract Response download(@PathParam("fileName") String fileName);
}

/*
This is the REST webService interface of this Provider server.
It has only two methods, and respective mapping paths:
- the upload method receives a POST request from the Consumer server, either from a WebClient post() method or directly 
from a form/input type=file, in both cases with a list of Attachments, which are used to get the dataHandler and the
inputStream of each sent file, later saving them locally; 
- the download method receives a GET request from the Consumer server, either from a WebClient get() method or directly 
from a link, with the file the client wants to download as the pathParam, and returns a Response with the File inputStream
as the wrapped entity. At the Consumer side, this Response is used to get the entity, downcast it to inputStream and save the
file locally at that server.
See this interface implementing class for more.
*/
