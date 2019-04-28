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
			<p>WebServices available for this Consumer Client Server from the Provider Server base endpoint<br>${personsURL}:</p>
			<div class="servicesList">
				<div class="tableRow" id="get1"><div class="tableCell">GET</div><div class="tableCell">${personsURL}</div></div>
				<div class="tableRow" id="get2"><div class="tableCell">GET</div><div class="tableCell">${personsURL}/<input type="number" id="input1" min="1" value="1" /></div></div>
				<div class="tableRow" id="post"><div class="tableCell">POST</div><div class="tableCell">${personsURL}</div></div>
				<div class="tableRow" id="put"><div class="tableCell">PUT</div><div class="tableCell">${personsURL}</div></div>
				<div class="tableRow" id="delete"><div class="tableCell">DELETE</div><div class="tableCell">${personsURL}/<input type="number" id="input2" min="1" value="1" /></div></div>
				<div class="tableRow" id="truncateAndClearDB"><div class="tableCell">Clear DB</div><div class="tableCell">${personsURL}/truncateAndClearDB</div></div>
			</div>
		</div>
		<div class="nav">
			<img id="img5" alt="backHome" src="${pageContext.request.contextPath}/img/backHome.png" title="Back Home" >
		</div>
		<script type="text/javascript">
			var get1 = document.getElementById("get1");
			get1.onclick = function(){
				window.location="${pageContext.request.contextPath}/getPersonAllResult";
			}
			var input1 = document.getElementById("input1");
			input1.onkeypress = function(e){
				if (e.keyCode == 13){
					window.location="${pageContext.request.contextPath}/getPersonUniqueResult?id="+input1.value;	
				}
			}
			var post = document.getElementById("post");
			post.onclick = function(){
				window.location="${pageContext.request.contextPath}/addPerson";
			}
			var put = document.getElementById("put");
			put.onclick = function(){
				window.location="${pageContext.request.contextPath}/updatePerson";
			}
			var input2 = document.getElementById("input2");
			input2.onkeypress = function(e){
				if (e.keyCode == 13){
					window.location="${pageContext.request.contextPath}/deletePersonResult?id="+input2.value;	
				}
			}
			var put = document.getElementById("truncateAndClearDB");
			put.onclick = function(){
				window.location="${pageContext.request.contextPath}/truncateAndClearDBResult";
			}
			var img5 = document.getElementById("img5");
			img5.onclick = function(){
				window.location="${pageContext.request.contextPath}/";
			}
		</script>
    </body>
</html>
