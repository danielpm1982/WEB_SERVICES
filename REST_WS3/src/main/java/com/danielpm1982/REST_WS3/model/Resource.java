package com.danielpm1982.REST_WS3.model;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Resource {
	private long id;
	private String name;
	private boolean checked;
	public Resource() {
	}
	public Resource(long id, String name) {
		this.id=id;
		this.name=name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public boolean isChecked() {
		return checked;
	}
	@Override
	public String toString() {
		return "id: "+id+" name: "+name+" checked: "+checked;
	}
}
