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
			<c:if test="${not empty person}">
				<p>PUT request result (updatePerson) from the endpoint<br>${personsURL}:</p>
				<div class="servicesList">
					<div class="tableRow"><div class="tableCell">PERSON_ID</div><div class="tableCell">PERSON_NAME</div></div>
					<div class="tableRow"><div class="tableCell">${person.id}</div><div class="tableCell">${person.name}</div></div>
				</div>
			</c:if>
			<c:if test="${empty person}">
				<p>PUT request result (updatePerson) from the endpoint<br>${personsURL}/{id}:</p>
				<p>Registry not found ! Update Failed ! NotFoundException thrown/caught !</p>
				<img id="img7" alt="emptyDB" src="${pageContext.request.contextPath}/img/emptyDB.png" title="Empty Database" >
			</c:if>
		</div>
		<div class="nav">
			<img id="img6" alt="backToWebServices" src="${pageContext.request.contextPath}/img/leftArrow.png" title="Back To WebServices" >
			<img id="img5" alt="backHome" src="${pageContext.request.contextPath}/img/backHome.png" title="Back Home" >
		</div>
    </body>
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
</html>
