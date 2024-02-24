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
<h1>Votre annonce a bien été enregistrée</h1>
</div>	
<%@ include file="finPage.jsp" %>
</body>
</html>