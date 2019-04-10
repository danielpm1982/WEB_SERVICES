package com.danielpm1982.SOAP_WS4.ws;
import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface MTOMFileManagerWS {
	@WebMethod
	public abstract void upload(@WebParam(name="uploadingFile") DataHandler dataHandler);
	@WebMethod
	public abstract @WebResult(name="downloadingFile") DataHandler download ();
}

/*
Using a bottom up code-first development process, JAX-WS annotations are set at this interface
which will be implemented by the PortType class, for managing upload and download operations
of any type of file using WS-MTOM Standard. No dto objects are needed to that operations,
only the files themselves, so no dto classes or JAXB annotations are necessary. 
*/
