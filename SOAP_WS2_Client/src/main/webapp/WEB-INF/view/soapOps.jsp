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
       	<div class="soapOps">
			<p>SOAP operations:</p>
			<p><a href="${pageContext.request.contextPath}/api" title="available APIs">Available APIs</a></p>
			<p><a href="${pageContext.request.contextPath}/controller/getPatientAll" title="Get All Patients">Get All Patients</a></p>
			<p><a href="${pageContext.request.contextPath}/controller/getPatient?patientId=1" title="Get PatientId=1">Get PatientId=1</a></p>
			<p><a href="${pageContext.request.contextPath}/controller/getPatient?patientId=2" title="Get PatientId=2">Get PatientId=2</a></p>
			<p><a href="${pageContext.request.contextPath}/controller/getProfessionalAll" title="Get All Professionals">Get All Professionals</a></p>
			<p><a href="${pageContext.request.contextPath}/controller/getProfessional?professionalId=1" title="Get ProfessionalId=1">Get ProfessionalId=1</a></p>
			<p><a href="${pageContext.request.contextPath}/controller/getProfessional?professionalId=2" title="Get ProfessionalId=2">Get ProfessionalId=2</a></p>
			<p><a href="${pageContext.request.contextPath}/controller/getProfessional?professionalId=3" title="Get ProfessionalId=3">Get ProfessionalId=3</a></p>
			<p><a href="${pageContext.request.contextPath}/controller/getAppointmentAll" title="Get All Appointments">Get All Appointments</a></p>
			<p><a href="${pageContext.request.contextPath}/controller/getAppointment?appointmentId=1" title="Get AppointmentId=1">AppointmentId=1</a></p>
			<p><a href="${pageContext.request.contextPath}/controller/getAppointment?appointmentId=2" title="Get AppointmentId=2">AppointmentId=2</a></p>
			<p><a href="${pageContext.request.contextPath}/controller/getAppointment?appointmentId=3" title="Get AppointmentId=3">AppointmentId=3</a></p>
			<p><a href="${pageContext.request.contextPath}/controller/createAppointmentSamples" title="Create AppointmentSamples">Create AppointmentSamples</a></p>
			<br><br>
			<a href="${pageContext.request.contextPath}/" title="go to main page">Back to Main Page</a>
		</div>
    </body>
</html>
