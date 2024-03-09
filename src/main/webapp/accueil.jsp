<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Accueil 2ndLife</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="style.css" />" />
<style type="text/css">

</style>
    </head>
<body>
<%@ include file="menu.jsp" %>
<h1>Accueil</h1>
<div class="contener">
	<c:forEach items="${annonces}" var="element">
		<div class="box">
			<p> <b>${element.titre}</b></p>
			<center><img src="images/${element.img}" width="180"/></center>
			<p> ${element.prix } frs</p>
			<p> ${element.dateMEV}</p>
			<p> <a href="${element.categorie }#${element.id }">Détails</a></p>
		</div>	
	</c:forEach>
</div>	
<%@ include file="finPage.jsp" %>
</body>
</html>