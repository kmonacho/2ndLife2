<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Accueil 2ndLife</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="style.css" />" />
<style type="text/css">
.contener {
	display : grid;
	grid-template-columns : 200px 200px 200px 200px ;
	grid-template-rows : 200px 200px 200px 200px ;
	gap : 20px;
	
}
.box {
	font-size : 12px;
	width : 200px;
	height: 300px;
	border : 1px #DDDDDD solid;
	text-align: left;	
	background-color:#FFFFFF;
}
p {
	margin-left: 15px;
}
body {

	background-color:#EEEEEE
}
</style>
    </head>
<body>
<%@ include file="menu.jsp" %>
<h1>Accueil</h1>
<div class="contener">
	<c:forEach items="${articles}" var="element">
		<div class="box">
			<p> <b>${element.titre}</b></p>
			<center><img src="images/${element.img}" width="180"/></center>
			<p> ${element.prix } frs</p>
			<p> ${element.dateMEV}</p>
		</div>
	</c:forEach>
</div>	
<%@ include file="finPage.jsp" %>
</body>
</html>