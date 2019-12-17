package com.danielpm1982.SOAP_Consumer.model;

public class ProductRequest {
	private String customerId;
	private String productId;
	private String quantity;
	public ProductRequest() {
	}
	public ProductRequest(String customerId, String productId, String quantity) {
		this.customerId = customerId;
		this.productId = productId;
		this.quantity = quantity;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "customerId: "+customerId+" productId: "+productId+" quantity: "+quantity;
	}
}

/*
This class is used for creating the ModelAttribute SpringForm bean, named as "productRequest", and used
at the view for transferring all client input data to the Controller, where this data is used
at the creation or updating of the various other objects. It's kind of a DTO for the forms, in the case 
of this app, the one and only form: productForm.
*/
