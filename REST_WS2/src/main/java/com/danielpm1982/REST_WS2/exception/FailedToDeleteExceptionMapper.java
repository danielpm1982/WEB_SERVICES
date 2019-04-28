package com.danielpm1982.REST_WS2.exception;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@SuppressWarnings("unused")
@Provider
public class FailedToDeleteExceptionMapper implements ExceptionMapper<FailedToDeleteRuntimeException> {
	@Override
	public Response toResponse(FailedToDeleteRuntimeException e) {
//		return Response.status(404).build();
//		return Response.status(Status.NOT_FOUND).build();
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"status\":\""+Response.Status.NOT_FOUND.name()+"\",");
		sb.append("\"message\":\""+e.getMessage()+"\"");
		sb.append("}");
		return Response.serverError().status(Status.NOT_FOUND).entity(sb.toString()).type(MediaType.APPLICATION_JSON).build();
	}
}

/*
This ExceptionMapper class handles all thrown FailedToDeleteRuntimeException exceptions at the project
and treats that exception inside the toResponse method in order to return a better response to the
API Consumer Client, for example, in this case, with a JSON message along with the http response status.
It abstracts this treatment to be done inside the throwing class code, although it could also be done there,
without using the ExceptionMapper. See the service implementing class (PersonManagerWSImpl) for more examples.
*/
