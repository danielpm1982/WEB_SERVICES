<%@page isELIgnored="false" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE>
<html>
    <head>
        <title>Registration Custom Result</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" type="text/css" media="screen and (min-width:360px) and (max-width:999px)" href="${pageContext.request.contextPath}/css/css2.css" />
		<link rel="stylesheet" type="text/css" media="screen and (min-width:1000px)" href="${pageContext.request.contextPath}/css/css.css" />
    </head>
    <body>
    	<div class="resultBody">
	    	<p><c:out value="Registration Successfull!" /></p><br>
       		<div class="resultBodyContent">
       			<p>User Registered:</p>
	       		<p>id: ${user.id} username: ${user.userName}</p>
	       		<p>password: ${user.password}</p>
	       		<p>name: ${user.firstName} ${user.lastName}</p>
	       		<p>email: ${user.email}</p>
	       		<p>role(s): ${user.roles[0].name} ${user.roles[1].name}</p>
       		</div>
       	</div>
       	<div class="link2">
			<a href="${pageContext.request.contextPath}/login">Go back to login page</a>
		</div>
    </body>
</html>
