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
       		<p>Upload type 2 - via form/input file to the WebService (directly)</p>
       		<p>Please, select at least 1 and at most 5 files to upload at a time:</p>
			<form action="${uploadURL}" method="post" enctype="multipart/form-data">
				<input type="file" name="uploadingFile1" id="uploadingFile1" required="required" />
				<br>
				<input type="file" name="uploadingFile2" />
				<br>
				<input type="file" name="uploadingFile3" />
				<br>
				<input type="file" name="uploadingFile4" />
				<br>
				<input type="file" name="uploadingFile5" />
				<br>
				<input type="submit" id="uploadButton" value="Upload File(s)" />
			</form>
			<div class=link>
				<a href="${pageContext.request.contextPath}/upload2">Clear fields</a>
			</div>
			<div class=link>
				<a href="${pageContext.request.contextPath}/welcome">Welcome</a>
			</div>
			<div class=link>
				<a href="${pageContext.request.contextPath}/">Home</a>
			</div>
		</div>
		<script>
			document.getElementById("uploadButton").onclick=function(){
				var uploadingFile1 = document.getElementById("uploadingFile1");
				if(uploadingFile1.value){ //if not empty or if file has been selected
					alert("File(s) successfully uploaded !");
				} else{ //if no file has been selected at the first required input file field
					alert("No file selected ! Select at least 1 file to upload !");
				}
			}
		</script>
    </body>
</html>
