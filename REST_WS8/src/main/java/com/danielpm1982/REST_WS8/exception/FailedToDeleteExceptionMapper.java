package com.danielpm1982.REST_WS8.exception;
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
