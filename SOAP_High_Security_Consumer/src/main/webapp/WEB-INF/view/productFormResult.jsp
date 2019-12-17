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
       	<div class="productRequestList">
			<c:if test="${not empty lastProductRequested}">
				<p>Last Product Requested by CustomerId = ${customerId}</p>
				<div id="lastProductRequestBody">
					<h6>ProductId = ${lastProductRequested.id} ProductDescription = ${lastProductRequested.description} ProductQuantity = ${lastProductRequested.quantity}</h6>
				</div>
			</c:if>
			<p>All Products Requested by CustomerId = ${customerId}</p>
			<c:if test="${not empty allProductsRequested}">
				<div id="allProductsBody">
					<a href="${pageContext.request.contextPath}/controller/showProductForm" title="Add another Product">Add Another</a>
					<a href="${pageContext.request.contextPath}/controller/showProductFormResultUpdated" title="Clear all requested Products">Clear All</a>
					<a href="${pageContext.request.contextPath}/controller/showOrderCreationResult" title="Confirm the order of all requested Products">Confirm Order</a>
					<c:forEach items="${allProductsRequested}" var="product" >
						<h6>ProductId = ${product.id} ProductDescription = ${product.description} ProductQuantity = ${product.quantity}</h6>
					</c:forEach>
				</div>
			</c:if>
			<c:if test="${empty allProductsRequested}">
				<h5>No Products requested for this Customer at this session.</h5>
				<a href="${pageContext.request.contextPath}/controller/showProductForm" title="go to Product request page">Go to Product request page</a>
				<br>
			</c:if>
			<a href="${pageContext.request.contextPath}/controller/soapOps" title="go to SOAP operations page">Go to SOAP operations page</a>
			<br>
			<a href="${pageContext.request.contextPath}/" title="go to main page">Back to Main Page</a>
		</div>
    </body>
</html>
