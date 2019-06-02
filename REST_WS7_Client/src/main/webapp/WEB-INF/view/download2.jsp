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
       		<p>Download type 2 - via link to the WebService (directly)</p>
       		<p>Please, click on the link with the name of the file to download:</p>
			<div class="linkGroup">
				<div class=link>
					<a href="${downloadBaseURL}/downloadTestFile1.png" title="download test file 1 png">downloadTestFile1.png</a>
				</div>
				<div class=link>
					<a href="${downloadBaseURL}/downloadTestFile2.jpg" title="download test file 2 jpg">downloadTestFile2.jpg</a>
				</div>
				<div class=link>
					<a href="${downloadBaseURL}/downloadTestFile3.pdf" title="download test file 3 pdf">downloadTestFile3.pdf</a>
				</div>
				<div class=link>
					<a href="${downloadBaseURL}/downloadTestFile4.txt" title="download test file 4 txt">downloadTestFile4.txt</a>
				</div>
				<div class=link>
					<a href="${downloadBaseURL}/downloadTestFile5.mp3" title="download test file 5 mp3">downloadTestFile5.mp3</a>
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
