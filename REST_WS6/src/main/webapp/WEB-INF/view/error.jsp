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
       	<div class="error">
			<img id="img1" alt="cxf" src="${pageContext.request.contextPath}/img/cxf.png" title="click to enter" >
			<h1>Error:</h1>
			<div class="error">
				<p>Timestamp: ${timestamp}</p>
				<p>Error: ${error}</p>
				<p>Error cause: ${pageContext.exception.cause}</p>
				<c:if test="${not empty pageContext.exception.cause.message}">
					<p>Error message: ${pageContext.exception.cause.message}</p>
				</c:if>
				<p>ErrorData request uri: ${pageContext.errorData.requestURI}</p>
				<p>ErrorData status code: ${pageContext.errorData.statusCode}</p>
			</div>
			<c:if test="${not empty pageContext.exception.stackTrace}">
				<p>StackTrace:</p>
				<div id="stacktrace">
					<c:forEach items="${pageContext.exception.stackTrace}" var="trace" >
						<h5>${trace}</h5>
					</c:forEach>
				</div>
			</c:if>
			<div class="link2">
				<a href="${pageContext.request.contextPath}/" title="go to main page">Back to Main Page</a>
			</div>
		</div>
    </body>
</html>
