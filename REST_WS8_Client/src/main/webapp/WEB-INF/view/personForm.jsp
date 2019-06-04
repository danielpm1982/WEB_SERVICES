<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
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
			<c:if test="${add}">
				<p>POST request (addPerson) for the endpoint<br>${personsURL}:</p>
				<div class="personForm">
					<form:form action="addPersonResult" method="post" modelAttribute="personModelAttribute">
						<div class="tableRow"><div class="tableCell"><form:label path="id">Person Id:</form:label></div><div class="tableCell"><form:input path="id" id="id" /></div></div>
						<div class="tableRow"><div class="tableCell"><form:label path="name">Person Name:</form:label></div><div class="tableCell"><form:input path="name" placeholder="PersonName" /></div></div>
						<div class="tableRow"><div class="tableCell"><form:label path="name">POST to the REST Provider Server DB:</form:label></div><div class="tableCell"><input type="submit" value="POST" /></div></div>
					</form:form>
				</div>
			</c:if>
			<c:if test="${update}">
				<p>PUT request (updatePerson) for the endpoint<br>${personsURL}/{id}:</p>
				<div class="personForm">
					<form:form action="updatePersonResult" method="post" modelAttribute="personModelAttribute">
						<div class="tableRow"><div class="tableCell"><form:label path="id">Person Id:</form:label></div><div class="tableCell"><form:input path="id" id="id" /></div></div>
						<div class="tableRow"><div class="tableCell"><form:label path="name">Person Name:</form:label></div><div class="tableCell"><form:input path="name" placeholder="PersonName" /></div></div>
						<div class="tableRow"><div class="tableCell"><form:label path="name">PUT to the REST Provider Server DB:</form:label></div><div class="tableCell"><input type="submit" value="PUT" /></div></div>
					</form:form>
				</div>
			</c:if>
		</div>
		<div class="nav">
			<img id="img6" alt="backToWebServices" src="${pageContext.request.contextPath}/img/leftArrow.png" title="Back To WebServices" >
			<img id="img5" alt="backHome" src="${pageContext.request.contextPath}/img/backHome.png" title="Back Home" >
		</div>
		<script type="text/javascript">
			var idInput = document.getElementById("id");
			idInput.value=0;
			idInput.type="number";
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
