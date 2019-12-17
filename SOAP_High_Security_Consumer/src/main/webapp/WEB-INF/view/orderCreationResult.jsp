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
       	<div class="orderCreationResult">
			<c:if test="${not empty lastOrderCreated}">
				<p>Order created successfully for customerId = ${customerId} !</p>
				<p>Created Order Id = ${lastOrderCreated.id}.</p>
				<p>All Products Requested:</p>
				<div id="allProductsBody">
					<c:forEach items="${lastOrderCreated.product}" var="product" >
						<h6>ProductId = ${product.id} ProductDescription = ${product.description} ProductQuantity = ${product.quantity}</h6>
					</c:forEach>
				</div>
			</c:if>
			<c:if test="${empty lastOrderCreated}">
				<p>No Order created for customerId = ${customerId} !</p>
			</c:if>
			<a href="${pageContext.request.contextPath}/controller/showProductForm" title="go to Product request page">Go to Product request page</a>
			<br>
			<a href="${pageContext.request.contextPath}/controller/soapOps" title="go to SOAP operations page">Go to SOAP operations page</a>
			<br>
			<a href="${pageContext.request.contextPath}/" title="go to main page">Back to Main Page</a>
		</div>
    </body>
</html>
