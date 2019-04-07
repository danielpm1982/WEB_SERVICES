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
       	<div class="orderCreationResult">
			<p>Order adding successfully!</p>
			<p>Added Order = ${addedOrder.id}:</p>
			<c:forEach items="${addedOrder.product}" var="product" >
				<h6>ProductId = ${product.id} ProductDescription = ${product.description} ProductQuantity = ${product.quantity}</h6>
			</c:forEach>
			<a href="${pageContext.request.contextPath}/" title="go to main page">Back to Main Page</a>
		</div>
    </body>
</html>
