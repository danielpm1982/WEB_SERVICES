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
       	<div class="appointmentResult">
			<p>Appointment result:</p>
			<br>
			<c:forEach items="${appointmentList}" var="appointment" >
				<div class="itemList">
					<h6>appointmentId: ${appointment.appointmentId}</h6>
					<c:set var="appointmentIdLong" value="${appointment.appointmentId.longValue()}" />
					<c:set var="patientIdLong" value="${appointment.patientId.longValue()}" />
					<c:set var="professionalIdLong" value="${appointment.professionalId.longValue()}" />
					<h6>patient: id: ${patientMap[patientIdLong].patientId} name: ${patientMap[patientIdLong].patientName} address: ${patientMap[patientIdLong].patientAddress} email: ${patientMap[patientIdLong].patientEmail} phoneNo: ${patientMap[patientIdLong].patientPhoneNo}</h6>
					<h6>professional: id: ${professionalMap[professionalIdLong].professionalId} name: ${professionalMap[professionalIdLong].professionalName} address: ${professionalMap[professionalIdLong].professionalAddress} email: ${professionalMap[professionalIdLong].professionalEmail} phoneNo: ${professionalMap[professionalIdLong].professionalPhoneNo} profession: ${professionalMap[professionalIdLong].professionalProfession} specialty: ${professionalMap[professionalIdLong].professionalSpecialty} registry: ${professionalMap[professionalIdLong].professionalRegistry}</h6>
					<h6>localDateTime: ${appointmentLocalizedDateTimeStringMap[appointmentIdLong]}</h6>
					<h6>appointmentAddress: ${appointment.appointmentAddress}</h6>
					<c:if test="not empty ${appointment.appointmentDetails}">
						<h6>appointmentDetails: ${appointment.appointmentDetails}</h6>
					</c:if>
				</div>
			</c:forEach>
			<br><br>
			<a href="${pageContext.request.contextPath}/" title="go to main page">Back to Main Page</a>
		</div>
    </body>
</html>
