<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Gestion des bases de données du site 2ndLife</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="style.css" />" />
<style type="text/css">

</style>
    </head>
<body>
<%@ include file="../menu.jsp" %>
<h1>Gestion des bases de données du site 2ndLife</h1>
<p> </p>
<p>
<form action="manager" method="post">
	<select name="username">
  		<c:forEach items="${utilisateurs }" var="element">
  			<option value="${ element.username }">${element.username}</option>
  		</c:forEach>
	</select>
	<input name="submit" type="submit" value="Effacer" />
</form> 
</p>
<p>${log}</p>
<%@ include file="../finPage.jsp" %>
</body>
</html>