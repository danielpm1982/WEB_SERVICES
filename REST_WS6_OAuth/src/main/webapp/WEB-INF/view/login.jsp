<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE>
<html>
	<head>
		<title>Login Custom Page</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" media="screen and (min-width:360px) and (max-width:999px)" href="${pageContext.request.contextPath}/css/css2.css" />
		<link rel="stylesheet" type="text/css" media="screen and (min-width:1000px)" href="${pageContext.request.contextPath}/css/css.css" />
	</head>
	<body>
		<form:form class="login" action="${pageContext.request.contextPath}/loginResult" method="post">
       		<div id=title>
	       		<h2>Login Page</h2>
	       		<img id="img2" src="${pageContext.request.contextPath}/img/leftArrow.png" alt="login" title="login">
				<hr>
			</div>
       		<c:if test="${param.logout ne null}">
       			<h3 class=logout>You have logged out sucessfully!</h3>
       		</c:if>
       		<c:if test="${param.error ne null}">
       			<h3 class=errors>Authentication failed! Invalid OAuth2 token!</h3>
       		</c:if>
       		<label for="OAuthToken">OAuth2 Token:</label>
       		<div class="imgInput">
       			<img src="${pageContext.request.contextPath}/img/oauth2.png" title="oauth2" />
	       		<input type="text" name="access_token" id="access_token" title="type your OAuthToken" required="required" />
       		</div>
       		<input type="submit" value="Login"><br>
       		<div class="link1">
       			<a href="${pageContext.request.contextPath}/" title="Home">Home</a>
 			</div>
 			<div class="link1">
       			<a href="${pageContext.request.contextPath}/register/registrationForm" title="User Registration">User Registration</a>
 			</div>
       	</form:form>
       	<h5>* For the OAuth token you gotta send a POST request for http://localhost:8080/REST_WS6/oauth/token with the
			<br>requested auth data and later copy the received token to the field above for sending the login request.</h5>
	</body>
</html>
