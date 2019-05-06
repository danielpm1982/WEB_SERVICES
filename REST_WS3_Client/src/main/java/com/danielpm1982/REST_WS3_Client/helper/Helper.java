package com.danielpm1982.REST_WS3_Client.helper;
import com.danielpm1982.REST_WS3_Client.model.Resource;
import com.danielpm1982.REST_WS3_Client.model.ResourcesList;

public interface Helper {
	public abstract void processResources(Resource... resources);
	public abstract void processResources(ResourcesList resourcesList);
	public abstract void finalizeHelperImpl();
}
