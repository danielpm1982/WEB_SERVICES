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
       	<div class="mainBody">
			<c:if test="${cleared}">
				<p>Provider Server Database Sucessfully Truncated and Cleared !</p>
				<img id="img2" alt="db" src="${pageContext.request.contextPath}/img/db.png" title="database" >
				<img id="img3" alt="rightArrow" src="${pageContext.request.contextPath}/img/rightArrow.png" title="rightArrow" >
				<img id="img4" alt="trash" src="${pageContext.request.contextPath}/img/trash.png" title="trash" >
			</c:if>
		</div>
		<div class="nav">
			<img id="img6" alt="backToWebServices" src="${pageContext.request.contextPath}/img/leftArrow.png" title="Back To WebServices" >
			<img id="img5" alt="backHome" src="${pageContext.request.contextPath}/img/backHome.png" title="Back Home" >
		</div>
		<script type="text/javascript">
			var img5 = document.getElementById("img5");
			img5.onclick = function(){
				window.location="${pageContext.request.contextPath}/";
			}
			var img6 = document.getElementById("img6");
			img6.onclick = function(){
				window.location="${pageContext.request.contextPath}/webServices";
			}
		</script>
    </body>
</html>
