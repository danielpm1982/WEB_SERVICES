<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Maven_Web_Spring_SOAP_WebServices</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" media="screen and (min-width:360px) and (max-width:999px)" href="${pageContext.request.contextPath}/css/css2.css" />
		<link rel="stylesheet" type="text/css" media="screen and (min-width:1000px)" href="${pageContext.request.contextPath}/css/css.css" />
    </head>
    <body>
       	<div class="welcome">
			<img id="img1" alt="cxf" src="${pageContext.request.contextPath}/img/cxf.png" title="click to enter" >
			<p>${welcomeMessage}</p>
		</div>
		<footer>
			<p>${credits}</p>
			<p>For contact, email to:</p>
			<a href="${email}" title="email">${email}</a>
		</footer>
		<script type="text/javascript">
			var img = document.getElementById("img1");
			img.onclick = function(){
				window.location="${pageContext.request.contextPath}/controller/soapOps";
			}
		</script>
    </body>
</html>
