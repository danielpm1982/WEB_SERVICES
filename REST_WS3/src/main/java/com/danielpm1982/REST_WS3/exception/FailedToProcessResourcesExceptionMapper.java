package com.danielpm1982.REST_WS3.exception;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@SuppressWarnings("unused")
@Provider
public class FailedToProcessResourcesExceptionMapper implements ExceptionMapper<FailedToProcessResourcesRuntimeException> {
	@Override
	public Response toResponse(FailedToProcessResourcesRuntimeException e) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"status\":\""+Response.Status.INTERNAL_SERVER_ERROR.name()+"\",");
		sb.append("\"message\":\""+e.getMessage()+"\"");
		sb.append("}");
		return Response.serverError().status(Status.INTERNAL_SERVER_ERROR).entity(sb.toString()).type(MediaType.APPLICATION_JSON).build();
	}
}

/*
This ExceptionMapper class handles all thrown FailedToProcessResourcesRuntimeException exceptions at the project
and treats that exception inside the toResponse method in order to return a better response to the API Consumer 
Client, for example, in this case, with a JSON message along with the http response status.
It abstracts this treatment to be done inside the throwing class code, although it could also be done there,
without using the ExceptionMapper.
*/
