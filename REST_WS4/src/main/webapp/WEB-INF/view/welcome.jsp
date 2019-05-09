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
        <style type="text/css">
        	body{
				font-family: sans-serif;
				text-align: center;
				background-color: black;
				color: blanchedalmond;
			}
			div.welcome{
				margin-top: 4%;
				font-size: 1.8em;
				margin-bottom: 3em;
			}
			form {
				font-size: 2em;
				width: 50%;
				margin: auto;
				margin-top: 1em;
			}
			input[type="submit"]{
				font-family: monospace;
				font-size: 1.1em;
				font-weight: bolder;
				padding: 0.4em;
				width: 7em;
			}
			div.link{
				font-size: 1.5em;
				margin-bottom: 3em;
			}
			a:link{
				color: green;
			}
			a:visited{
				color: teal;
			}
			a:hover{
				color: lime;
			}
			a:active{
				color: red;
			}
        </style>
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
				<p>User authenticated and authorized!</p>
				<p>Username: ${sessionScope.username}</p>
				<p>Role(s): ${sessionScope.roles}</p>
			</c:if>
		</div>
       	<div class="link">
       		<p>GET endpoint for retrieving all Provider existing Contacts<br>(if any exists...):</p>
       		<a href="http://localhost:8080/REST_WS4/api/contactManager/contacts" title="GET all contacts request">http://localhost:8080/REST_WS4/api/contactManager/contacts</a>
       	</div>
       	<security:authorize access="hasRole('ADMIN')">
			<div class="link">
				<p>GET endpoint for truncating the DB and deleting all Provider existing Contacts<br>(if any exists...):</p>
	       		<a href="http://localhost:8080/REST_WS4/api/contactManager/truncateAndClearDB" title="GET clear all contacts and truncate DB">http://localhost:8080/REST_WS4/api/contactManager/truncateAndClearDB</a>
       		</div>
		</security:authorize>
       	<h4>* Other endpoints (POST, PUT and DELETE) can be tested with Postman.</h4>
       	<form:form action="${pageContext.request.contextPath}/logout" method="post">
   			<input type="submit" value="Logout">
   		</form:form>
   		<form:form action="${pageContext.request.contextPath}/" method="post">
   			<input type="submit" value="Home">
   		</form:form>
	</body>
</html>
