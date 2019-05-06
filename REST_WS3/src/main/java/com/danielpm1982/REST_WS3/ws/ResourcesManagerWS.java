package com.danielpm1982.REST_WS3.ws;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import com.danielpm1982.REST_WS3.model.ResourcesList;

@Consumes("application/xml, application/json")
@Produces("application/xml, application/json")
@Path("/resourcesManager")
public interface ResourcesManagerWS {
	@Path("/resources")
	@POST
	public abstract void processResources(@Suspended AsyncResponse asyncResponse, ResourcesList resourcesList);
}

/*
@Consumes and @Produces are set to add support for both xml and json format
data types. These annotations could also be set at each specific method if
configuring them differently from one another would be of any use. For
example, if one method would not consume or produce JSON format messages -
only XML, and another would consume and produce both. Here, the whole
interface is set equally.
*/

/*
This Rest service interface is similar to the others being created so far, 
except for the use of @Suspended annotation together with AsyncResponse
object... both from JAX-RS API. See the impl class to see how they are
used to asynchronously respond to each REST request.  
*/
