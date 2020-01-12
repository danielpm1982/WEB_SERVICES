<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE>
<html>
	<head>
		<title>Access Denied!</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" media="screen and (min-width:360px) and (max-width:999px)" href="${pageContext.request.contextPath}/css/css2.css" />
		<link rel="stylesheet" type="text/css" media="screen and (min-width:1000px)" href="${pageContext.request.contextPath}/css/css.css" />
	</head>
	<body>
       	<div class="accessDenied">
	       	<p>403 ERROR! ACCESS FORBIDDEN !<br>YOU'RE NOT ALLOWED TO ACCESS THIS RESOURCE !</p>
	       	<img id="img3" src="${pageContext.request.contextPath}/img/accessDenied.png" alt="accessDenied">
	       	<p>Sorry, you are not authorized to access this page.<br>Check your credentials and try again. Or call the system admin.</p>
       	</div>
   		<form:form action="${pageContext.request.contextPath}/" method="post">
   			<input type="submit" value="Home">
   		</form:form>
	</body>
</html>
