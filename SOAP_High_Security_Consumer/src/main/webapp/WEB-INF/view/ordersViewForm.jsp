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
			<p>Select CustomerId for fetching Orders</p>
			<form:form action="showOrdersViewFormResult" method="post" modelAttribute="productRequest">
				<div class="table">
					<div class="tableRow">
						<div class="tableCellLeft">
							<form:label path="customerId">Customer Id:</form:label>
						</div>
						<div class="tableCellRight">
							<form:select path="customerId" title="Select your id!" id="customerId" required="true">
								<form:option value="" label="<SELECT>" />
								<form:option value="1" />
								<form:option value="2" />
								<form:option value="3" />
								<form:option value="4" />
								<form:option value="5" />
							</form:select>
						</div>
					</div>
				</div>
				<input type="submit" value="List Orders">
			</form:form>
			<a href="${pageContext.request.contextPath}/controller/soapOps" title="go to SOAP operations page">Go to SOAP operations page</a>
			<br>
			<a href="${pageContext.request.contextPath}/" title="go to main page">Back to Main Page</a>
		</div>
    </body>
</html>
