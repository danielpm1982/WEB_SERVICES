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
			<div>
				<h3>Timestamp: ${timestamp}</h3>
				<h3>Error: ${error}</h3>
				<h3>Error cause: ${pageContext.exception.cause}</h3>
				<c:if test="${not empty pageContext.exception.cause.message}">
					<h3>Error message: ${pageContext.exception.cause.message}</h3>
				</c:if>
				<h3>ErrorData request uri: ${pageContext.errorData.requestURI}</h3>
				<h3>ErrorData status code: ${pageContext.errorData.statusCode}</h3>
			</div>
			<br>
			<c:if test="${not empty pageContext.exception.stackTrace}">
				<h1>StackTrace:</h1>
				<div id="stacktrace">
					<c:forEach items="${pageContext.exception.stackTrace}" var="trace" >
						<h3>${trace}</h3>
					</c:forEach>
				</div>
			</c:if>
			<a href="${pageContext.request.contextPath}/" title="go to main page">Back to Main Page</a>
		</div>
    </body>
</html>
