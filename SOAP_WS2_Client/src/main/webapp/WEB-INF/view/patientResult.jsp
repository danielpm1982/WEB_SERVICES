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
       	<div class="patientResult">
			<p>Patient result:</p>
			<br>
			<c:forEach items="${patientList}" var="patient" >
				<div class="itemList">
					<h6>patientId: ${patient.patientId}</h6>
					<h6>patientName: ${patient.patientName}</h6>
					<h6>patientAddress: ${patient.patientAddress}</h6>
					<h6>patientEmail: ${patient.patientEmail}</h6>
					<h6>patientPhoneNo: ${patient.patientPhoneNo}</h6>
				</div>
			</c:forEach>
			<br><br>
			<a href="${pageContext.request.contextPath}/" title="go to main page">Back to Main Page</a>
		</div>
    </body>
</html>
