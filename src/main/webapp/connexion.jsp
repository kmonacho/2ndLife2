<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Connexion 2ndLife</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="style.css" />" />
        <style type="text/css">
        fieldset {
    		padding: 10px;
    		border: 1px #1ac21a solid;
		}
		legend {
   			font-weight: bold;
    		color: #0000ff
		}
        </style>
    </head>
<body>
<%@ include file="menu.jsp" %>
<h1>Connexion</h1>
<form method="post" action="connexion">
            <fieldset>
                <legend>Connexion</legend>
                <p>Vous pouvez vous connecter via ce formulaire.</p>

                <label for="nom">Nom d'utilisateur <span class="requis">*</span></label>
                <input type="text" id="username" name="username" value="" size="20" maxlength="60" />
        
                <br />

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="password" value="" size="20" maxlength="20" />
   
                <br />

                <input type="submit" value="Connexion" class="sansLabel" />
                <br />
            </fieldset>
        </form>
<p><a href="creationUtilisateur">Créer un compte</a>
<%@ include file="finPage.jsp" %>
</body>
</html>