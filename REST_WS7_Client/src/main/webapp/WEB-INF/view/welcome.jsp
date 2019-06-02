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
			<p>REST upload and download testing links:</p>
			<div class="linkGroup">
				<div class="link">
					<a href="${pageContext.request.contextPath}/upload1">Upload type 1</a>
				</div>
				<div class="link">
					<a href="${pageContext.request.contextPath}/upload2">Upload type 2</a>
				</div>
				<div class="link">
					<a href="${pageContext.request.contextPath}/download1">Download type 1</a>
				</div>
				<div class="link">
					<a href="${pageContext.request.contextPath}/download2">Download type 2</a>
				</div>
			</div>
			<div class="link">
				<a href="${pageContext.request.contextPath}/">Home</a>
			</div>
		</div>
    </body>
</html>
