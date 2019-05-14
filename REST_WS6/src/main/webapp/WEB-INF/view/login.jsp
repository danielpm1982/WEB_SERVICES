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
       		<c:if test="${param.error ne null}">
       			<h3 class=errors>Authentication failed! Invalid username/password!</h3>
       		</c:if>
       		<c:if test="${param.logout ne null}">
       			<h3 class=logout>You have logged out sucessfully!</h3>
       		</c:if>
       		<label for="userName">Username:</label>
       		<div class="imgInput">
	       		<img src="${pageContext.request.contextPath}/img/username.png" title="username" />
	       		<input type="text" name="username" id="username" title="type your userName" />
       		</div>
       		<label for="userPassword">Password:</label>
       		<div class="imgInput">
	       		<img src="${pageContext.request.contextPath}/img/password.png" title="password" />
	       		<input type="password" name="password" id="password" title="type your userPassword" />
       		</div>
       		<input type="submit" value="Login"><br>
       		<div class="link1">
       			<a href="${pageContext.request.contextPath}/" title="Home">Home</a>
 			</div>
 			<div class="link1">
       			<a href="${pageContext.request.contextPath}/register/registrationForm" title="User Registration">User Registration</a>
 			</div>
       	</form:form>
       	<h5>* Default Users registered: 'user1' (ROLE_USER), 'user2' (ROLE_ADMIN). The password is unique: '123'.</h5>
	</body>
</html>
