<%@page isELIgnored="false" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE>
<html>
    <head>
        <title>Registration Update Custom Result</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" type="text/css" media="screen and (min-width:360px) and (max-width:999px)" href="${pageContext.request.contextPath}/css/css2.css" />
		<link rel="stylesheet" type="text/css" media="screen and (min-width:1000px)" href="${pageContext.request.contextPath}/css/css.css" />
    </head>
    <body>
    	<div class="resultBody">
	    	<p><c:out value="Registration Update Successfull!" /></p>
       		<br>
       		<p>Before update:</p>
       		<div class="resultBodyContent">
       			<p>User:</p>
	       		<p>id: ${oldUser.id} username: ${oldUser.userName}</p>
	       		<p>password: ${oldUser.password}</p>
	       		<p>name: ${oldUser.firstName} ${oldUser.lastName}</p>
	       		<p>email: ${oldUser.email}</p>
	       		<p>role(s): ${oldUser.roles[0].name} ${oldUser.roles[1].name}</p>
       		</div>
       		<br>
       		<p>After update:</p>
       		<div class="resultBodyContent">
       			<p>User:</p>
	       		<p>id: ${newUser.id} username: ${newUser.userName}</p>
	       		<p>password: ${newUser.password}</p>
	       		<p>name: ${newUser.firstName} ${newUser.lastName}</p>
	       		<p>email: ${newUser.email}</p>
	       		<p>role(s): ${newUser.roles[0].name} ${newUser.roles[1].name}</p>
       		</div>
       	</div>
       	<div class="link2">
			<a href="${pageContext.request.contextPath}/login">Go back to login page</a>
		</div>
    </body>
</html>
