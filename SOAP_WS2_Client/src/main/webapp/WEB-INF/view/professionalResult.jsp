<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>SOAP_WS2</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" media="screen and (min-width:360px) and (max-width:999px)" href="${pageContext.request.contextPath}/css/css2.css" />
		<link rel="stylesheet" type="text/css" media="screen and (min-width:1000px)" href="${pageContext.request.contextPath}/css/css.css" />
    </head>
    <body>
       	<div class="professionalResult">
			<p>Professional result:</p>
			<br>
			<c:forEach items="${professionalList}" var="professional" >
				<div class="itemList">
					<h6>professionalId: ${professional.professionalId}</h6>
					<h6>professionalName: ${professional.professionalName}</h6>
					<h6>professionalAddress: ${professional.professionalAddress}</h6>
					<h6>professionalEmail: ${professional.professionalEmail}</h6>
					<h6>professionalPhoneNo: ${professional.professionalPhoneNo}</h6>
					<h6>professionalProfession: ${professional.professionalProfession}</h6>
					<h6>professionalSpecialty: ${professional.professionalSpecialty}</h6>
					<h6>professionalRegistry: ${professional.professionalRegistry}</h6>
				</div>
			</c:forEach>
			<br><br>
			<a href="${pageContext.request.contextPath}/" title="go to main page">Back to Main Page</a>
		</div>
    </body>
</html>
