<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE>
<html>
	<head>
		<title>Login Custom Page Result</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" media="screen and (min-width:360px) and (max-width:999px)" href="${pageContext.request.contextPath}/css/css2.css" />
		<link rel="stylesheet" type="text/css" media="screen and (min-width:1000px)" href="${pageContext.request.contextPath}/css/css.css" />
	</head>
	<body>
		<security:authentication property="authenticated" var="authenticated" scope="session" />
		<security:authentication property="principal.username" var="username" scope="session" />
		<security:authentication property="principal.authorities" var="roles" scope="session" />
       	<div class="welcome">
			<c:if test="${not sessionScope.authenticated}">
				<p>User NOT logged in! User NOT authenticated!</p>
			</c:if>
			<c:if test="${sessionScope.authenticated}">
				<p>User authenticated and authorized !</p>
				<p>Welcome ${sessionScope.user.lastName}, ${sessionScope.user.firstName} !</p>
				<p>Username: ${sessionScope.username}</p>
				<p>BCrypted password:</p>
				<h6>${sessionScope.user.password}</h6>
				<p>OAuth2 Token:</p>
				<h6>${sessionScope.access_token}</h6>
				<p>Email: ${sessionScope.user.email}</p>
				<p>Role(s): ${sessionScope.roles}</p>
			</c:if>
		</div>
       	<div class="link2">
      		<p>GET endpoint for retrieving all Provider existing Contacts:</p>
      		<a href="${pageContext.request.contextPath}/api/contactManager/contacts?access_token=${sessionScope.access_token}" title="GET all contacts request">api/contactManager/contacts?access_token=${sessionScope.access_token}</a>
	       	<security:authorize access="hasRole('ADMIN')">
				<p>GET endpoint for truncating the DB and deleting all Provider existing Contacts:</p>
	       		<a href="${pageContext.request.contextPath}/api/contactManager/truncateAndClearDB?access_token=${sessionScope.access_token}" title="GET clear all contacts and truncate DB">api/contactManager/truncateAndClearDB?access_token=${sessionScope.access_token}</a>
			</security:authorize>
			<br><br>
      		<p>* Other endpoints (POST, PUT and DELETE) can be tested with Postman.</p>
   		</div>
   		<form:form class="buttom" action="${pageContext.request.contextPath}/logoutResult" method="get">
   			<input type="submit" value="Logout">
   		</form:form>
   		<form:form class="buttom" action="${pageContext.request.contextPath}/" method="post">
   			<input type="submit" value="Home">
   		</form:form>
	</body>
</html>
