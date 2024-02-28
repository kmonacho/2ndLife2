<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Ménage et Maison 2ndLife</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="style.css" />" />
<style type="text/css">


</style>
    </head>
<body>
<%@ include file="menu.jsp" %>
<h1>Catégorie Ménage et Maison</h1>
<br>
<c:forEach items="${annonces}" var="element">
<table>   
	<tr>
		<td>
			<p><a id="${element.id}"></a><b>${element.titre}</b></p>
		</td>
	</tr>	
	<tr>
		<td>
			<center>
				<img src="images/${element.img}" width="180"/>
				<img src="images/${element.img2}" width="180"/>
				<img src="images/${element.img3}" width="180"/>
			</center>
		</td>
	</tr>
	<tr>
		<td>
			<p> ${element.description }</p>
		</td>
	</tr>
	<tr>
		<td>
			<p> ${element.prix } frs</p>
		</td>
	</tr>
	<tr>
		<td>
			<p> ${element.vendeur} </p>
		</td>
	</tr>
	<tr>
		<td>		
			<p> ${element.dateMEV}</p>
		</td>
	</tr>
</table>
<p>
</p>
<p>
		...
		</p>
		<p>
		...
		</p>
		<p>
		...
		</p>
		<p>
		...
		</p>
		<p>
		...
		</p>
		<p>
		...
		</p>
		<p>
		...
		</p>
		<p>
		...
		</p>
		<p>
		...
		</p>
		<p>
		...
		</p>
</c:forEach>
<%@ include file="finPage.jsp" %>
</body>
</html>