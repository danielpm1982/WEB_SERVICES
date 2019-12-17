<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>SOAP_High_Security_Consumer</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" media="screen and (min-width:360px) and (max-width:999px)" href="${pageContext.request.contextPath}/css/css2.css" />
		<link rel="stylesheet" type="text/css" media="screen and (min-width:1000px)" href="${pageContext.request.contextPath}/css/css.css" />
    </head>
    <body>
       	<div class="soapOps">
			<p>SOAP operations:</p>
			<p><a href="${pageContext.request.contextPath}/api" title="available APIs">Available APIs</a></p>
			<p><a href="${pageContext.request.contextPath}/controller/showProductForm" title="showProductForm">Product Form</a></p>
			<p><a href="${pageContext.request.contextPath}/controller/showOrdersViewForm" title="showOrdersViewForm">Orders View Form</a></p>
			<p><a href="${pageContext.request.contextPath}/" title="go to main page">Back to Main Page</a></p>
		</div>
    </body>
</html>
