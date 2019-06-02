<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>REST_WebServices</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" media="screen and (min-width:360px) and (max-width:999px)" href="${pageContext.request.contextPath}/css/css2.css" />
		<link rel="stylesheet" type="text/css" media="screen and (min-width:1000px)" href="${pageContext.request.contextPath}/css/css.css" />
    </head>
    <body>
       	<div class="uploadDownload">
			<p>File successfully downloaded from the REST provider server !</p>
			<p>Downloaded from: ${downloadURL}</p>
			<p>Downloaded to: ${destineLocalFolder}</p>
			<div class=link>
				<a href="${pageContext.request.contextPath}/welcome">Welcome</a>
			</div>
			<div class=link>
				<a href="${pageContext.request.contextPath}/">Home</a>
			</div>
		</div>
    </body>
</html>
