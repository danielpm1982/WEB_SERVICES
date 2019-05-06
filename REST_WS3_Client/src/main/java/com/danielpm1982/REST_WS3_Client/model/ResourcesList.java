package com.danielpm1982.REST_WS3_Client.model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResourcesList {
	private List<Resource> resourcesList;
	public ResourcesList() {
		resourcesList = new ArrayList<>();
	}
	public ResourcesList(Resource... resources) {
		resourcesList = new ArrayList<>(Arrays.asList(resources));
	}
	public void setResourcesList(List<Resource> resourcesList) {
		this.resourcesList = resourcesList;
	}
	public List<Resource> getResourcesList() {
		return resourcesList;
	}
	@Override
	public String toString() {
		return getResourcesList().stream().map(Resource::toString).reduce((x, y)-> x+"; "+y).orElse("emptyList!");
	}
}
