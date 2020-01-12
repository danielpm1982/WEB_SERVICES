<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE>
<html>
	<head>
		<title>Registration Update Custom Page</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" type="text/css" media="screen and (min-width:360px) and (max-width:999px)" href="${pageContext.request.contextPath}/css/css2.css" />
		<link rel="stylesheet" type="text/css" media="screen and (min-width:1000px)" href="${pageContext.request.contextPath}/css/css.css" />
	</head>
	<body>
		<c:if test="${userModelAttribute.userName == null}">
			<form:form id="register" action="${pageContext.request.contextPath}/register/registrationFormQueryResult" modelAttribute="userModelAttribute">
				<c:if test="${registrationQueryError != null}">
					<h3 class=errors>${registrationQueryError}</h3>
				</c:if>
	       		<form:errors path="userName" cssClass="errors" />
	       		<form:input path="userName" placeholder="username" title="type your username" required="true" /><br>
       			<input type="submit" value="Search">
       		</form:form>
		</c:if>
		<form:form id="register" action="${pageContext.request.contextPath}/register/registrationFormUpdateResult" modelAttribute="userModelAttribute">
       		<c:if test="${registrationUpdateError != null}">
				<h3 class=errors>${registrationUpdateError}</h3>
			</c:if>
       		<form:errors path="userName" cssClass="errors" />
       		<form:input path="userName" placeholder="username" title="type your username" /><br>
       		<form:errors path="password" cssClass="errors" />
       		<form:input type="password" path="password" placeholder="password" title="type your password" /><br>
       		<form:errors path="matchingPassword" cssClass="errors" />
       		<form:input type="password" path="matchingPassword" placeholder="confirm password" title="type your password again" /><br>
       		<form:errors path="firstName" cssClass="errors" />
       		<form:input path="firstName" placeholder="first name" title="type your first name" /><br>
       		<form:errors path="lastName" cssClass="errors" />
       		<form:input path="lastName" placeholder="last name" title="type your last name" /><br>
       		<form:errors path="email" cssClass="errors" />
       		<form:input path="email" placeholder="email" title="type your email" /><br>
       		<input type="submit" value="Update">
       		<div class="link1">
				<a href="${pageContext.request.contextPath}/register/registrationFormUpdate">Update Another Existing User</a>
			</div>
			<div class="link1">
				<a href="${pageContext.request.contextPath}/login">Go back to login page</a>
			</div>
       	</form:form>
	</body>       	
</html>
