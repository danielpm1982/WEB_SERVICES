<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE>
<html>
	<head>
		<title>Access Denied!</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style type="text/css">
        	body{
				font-family: sans-serif;
				text-align: center;
				background-color: black;
				color: blanchedalmond;
			}
			img{
				width: 30%;
				margin-top: 5%;
				margin-bottom: 5%;
			}
			div{
				width: 60%;
				margin: auto;
				margin-top: 5%;
				margin-bottom: 4%;
				font-size: 0.7em;
				line-height: 2;
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
        </style>
	</head>
	<body>
       	<div>
	       	<hr>
	       	<h1>403 ERROR! ACCESS FORBIDDEN ! <br>YOU'RE NOT ALLOWED TO ACCESS THIS RESOURCE !</h1>
	       	<hr>
	       	<img src="${pageContext.request.contextPath}/img/accessDenied.png" alt="accessDenied">
	       	<hr>
	       	<h1>Sorry, you are not authorized to access this page. Check your credentials and try again. Or call the system admin.</h1>
	       	<hr>
       	</div>
   		<form:form action="${pageContext.request.contextPath}/" method="post">
   			<input type="submit" value="Home">
   		</form:form>
	</body>
</html>
