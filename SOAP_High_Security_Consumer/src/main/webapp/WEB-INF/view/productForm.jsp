<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
       	<div class="customerOrders">
			<p>Product request</p>
			<form:form action="showProductFormResult" method="post" modelAttribute="productRequest">
				<div class="table">
					<div class="tableRow">
						<div class="tableCellLeft">
							<form:label path="customerId">Customer:</form:label>
						</div>
						<div class="tableCellRight">
							<form:select path="customerId" title="Select the customer !" required="true">
								<form:option value="" label="<SELECT>" />
								<form:options items="${availableCustomersList}" itemValue="customerId" itemLabel="customerName" />
							</form:select>
						</div>
					</div>
					<div class="tableRow">
						<div class="tableCellLeft">
							<form:label path="productId">Product:</form:label>
						</div>
						<div class="tableCellRight">
							<form:select path="productId" title="Select the product !" required="true">
								<form:option value="" label="<SELECT>" />
								<form:options items="${availableProductsList}" itemValue="id" itemLabel="description" />
							</form:select>
						</div>
					</div>
					<div class="tableRow">
						<div class="tableCellLeft">
							<form:label path="quantity">Quantity:</form:label>
						</div>
						<div class="tableCellRight">
							<form:input path="quantity" title="Type the quantity of products required" value="1" required="true" />
						</div>
					</div>
				</div>
				<input type="submit" value="Add Product">
			</form:form>
			<a href="${pageContext.request.contextPath}/controller/soapOps" title="go to SOAP operations page">Go to SOAP operations page</a>
			<br>
			<a href="${pageContext.request.contextPath}/" title="go to main page">Back to Main Page</a>
		</div>
    </body>
</html>
