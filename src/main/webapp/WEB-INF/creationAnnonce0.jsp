<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Accueil 2ndLife</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="style.css" />" />
<style type="text/css">
        fieldset {
    		padding: 10px;
    		border: 1px #1ac21a solid;
		}
        </style>
    </head>
<body>
<%@ include file="../menu.jsp" %>
<h1>Marche à suivre pour créer une annonce</h1>
<p></p>
<form action="upload" method="get" name="upload">
<fieldset>
                <legend>Annonce</legend>
                <p> Vueillez d'abord choisir les 3 images que vous souhaitez joindre à votre annonce, puis remplir les différentes informations sur l'annonce (titre, description, prix, ...).
</p>

  <input name="Cr&eacute;ersubmit" type="submit" id="Cr&eacute;ersubmit" value="Cr&eacute;er son annonce" />
</fieldset>
</form>
<p></p>
<%@ include file="../finPage.jsp" %>

</body>
</html>