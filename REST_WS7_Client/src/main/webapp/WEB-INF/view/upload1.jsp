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
			<p>Upload type 1 - via local Controller/HelperClass (CXF WebClient)</p>
			<p>Please, click on the link with the name of the file to upload:</p>
			<div class="linkGroup">
				<div class=link>
					<a href="${pageContext.request.contextPath}/upload?fileName=earth.png">earth.png</a>
				</div>
				<div class=link>
					<a href="${pageContext.request.contextPath}/upload?fileName=picture.jpg">picture.jpg</a>
				</div>
				<div class=link>
					<a href="${pageContext.request.contextPath}/upload?fileName=0-18yrs-child-combined-schedule.pdf">0-18yrs-child-combined-schedule.pdf</a>
				</div>
				<div class=link>
					<a href="${pageContext.request.contextPath}/upload?fileName=text.txt">text.txt</a>
				</div>
				<div class=link>
					<a href="${pageContext.request.contextPath}/upload?fileName=Pater Noster - Our Father in Latin.mp3">Pater Noster - Our Father in Latin.mp3</a>
				</div>
			</div>
			<div class=link>
				<a href="${pageContext.request.contextPath}/welcome">Welcome</a>
			</div>
			<div class=link>
				<a href="${pageContext.request.contextPath}/">Home</a>
			</div>
		</div>
    </body>
</html>
