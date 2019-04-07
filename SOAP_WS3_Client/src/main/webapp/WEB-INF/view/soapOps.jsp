<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Maven_Web_Spring_SOAP_WebServices</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" media="screen and (min-width:360px) and (max-width:999px)" href="${pageContext.request.contextPath}/css/css2.css" />
		<link rel="stylesheet" type="text/css" media="screen and (min-width:1000px)" href="${pageContext.request.contextPath}/css/css.css" />
    </head>
    <body>
       	<div class="soapOps">
			<p>SOAP operations:</p>
			<p><a href="${pageContext.request.contextPath}/api" title="available APIs">Available APIs</a></p>
			<p><a href="${pageContext.request.contextPath}/controller/getCustomerOrders?customerId=1" title="Get customerId=1 Orders">Get customerId=1 Orders</a></p>
			<p><a href="${pageContext.request.contextPath}/controller/createSampleOrder1ForCustomer1" title="createSampleOrder1ForCustomer1">Create sample Order 1<br>for Customer 1</a></p>
			<p><a href="${pageContext.request.contextPath}/controller/createSampleOrder2ForCustomer1" title="createSampleOrder2ForCustomer1">Create sample Order 2<br>for Customer 1</a></p>
			<p><a href="${pageContext.request.contextPath}/controller/createSampleOrder3ForCustomer1" title="createSampleOrder3ForCustomer1">Create sample Order 3<br>for Customer 1</a></p>
		</div>
    </body>
</html>
