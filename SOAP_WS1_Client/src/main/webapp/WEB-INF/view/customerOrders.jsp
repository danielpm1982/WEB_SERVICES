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
       	<div class="customerOrders">
			<p>CustomerId = ${customerId} Orders:</p>
			<c:if test="${not empty customerOrderList}">
				<div id="ordersListBody">
					<c:forEach items="${customerOrderList}" var="order" >
						<h5>OrderId = ${order.id} products:</h5>
						<c:forEach items="${order.product}" var="product" >
							<h6>ProductId = ${product.id} ProductDescription = ${product.description} ProductQuantity = ${product.quantity}</h6>
						</c:forEach>
					</c:forEach>
				</div>
			</c:if>
			<c:if test="${empty customerOrderList}">
				<h5>No Orders exist for this Customer.</h5>
			</c:if>
			<a href="${pageContext.request.contextPath}/" title="go to main page">Back to Main Page</a>
		</div>
    </body>
</html>
