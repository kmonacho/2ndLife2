<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Profil utilisateur 2ndLife</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/../style.css" />" />
	<style type="text/css">
        fieldset {
    		padding: 10px;
    		border: 1px #1ac21a solid;
		}
     </style>
    </head>
<body>
<%@ include file="\..\menu.jsp" %>
<h1>Créer un nouvel utilisateur</h1>
<form method="post" action="creationUtilisateur">
   <fieldset>
   <legend>Informations d'utilisateur</legend>
  <p>
  <label>Nom d'utilisateur :<span class="requis">*</span> </label>
  <input name="username" type="text" size="50" /><span class="requis">    ${existingUser}</span>
   </p>
   <p>
   <label>Mot de passe :<span class="requis">*</span></label>
   <input name="password1" type="password" size="50" />
    </p>
    <p> 
	<label>Mot de passe :<span class="requis">*</span></label>
	<input name="password2" type="password" size="50" />
    </p>
    <c:forEach items="${errors}" var="element">
    <br><span class="requis">           ${element}</span>
    </c:forEach>
    <p>
    <label>Prénom :<span class="requis">*</span></label>
    <input name="prenom" type="text" size="50" />
   </p>
   <p>
    <label>Nom : <span class="requis">*</span></label>
     <input name="nom" type="text" size="50" />
   </p>
   <p>
    <label>Email : <span class="requis">*</span></label>
    <input name="email" type="email" size="50" />
    
   </p>
   <p>
     <label>Adresse : <span class="requis">*</span></label>
     <textarea name="adresse" cols="50" rows="3" id="adresse"></textarea>
    </p>
   <p>
     <input type="reset" name="Submit" value="Effacer" />
     <input name="creationUtilisateur" type="submit" id="CreationUtilisateur" value="Accepter" /></td>
	 </p>
   
	 </fieldset>
</form>
</body>

<%@ include file="\..\finPage.jsp" %>
</body>
</html>