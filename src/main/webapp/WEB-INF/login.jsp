<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Profil utilisateur 2ndLife</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="style.css" />" />
<style type="text/css">
<style>
form label {
    width: 200px;
    margin: 3px 0px 0px 0px;
}

form legend }
	margin: 3px 3px 0px 0px
    border: 1px #000 solid;
}
form input {
    margin: 3px 3px 0px 0px;
    border: 1px #999 solid;
}
.style1 {color: #FFFFFF}
</style>

</style>
    </head>
    <!-- 
    
    -->
<body>



<%@ include file="../menu.jsp" %>
<h1>Bienvenu dans votre espace membre</h1>
<table width="100%" border="0">
  <tr>
    <td width="25%" height="28" align="left" valign="middle" bgcolor="#000000"><span class="style1">Donn&eacute;es du compte utilisateur</span></td>
    <td width="23%" bgcolor="#000000"><span class="style1"></span></td>
    <td width="52%" bgcolor="#000000"><span class="style1"></span></td>
  </tr>
  <tr><form action="userDataChange" method="post">
    <td align="left" valign="top" bgcolor="#CCCCCC"><span class="style1">Nom d'utilisateur
        <input name="data2Change" type="hidden" value="username" />
    </span></td>
    <td align="left" valign="top" bgcolor="#CCCCCC"><input name="username" type="text"  value="${sessionScope.utilisateur.username }" maxlength="50" /></td>
    <td align="left" valign="top" bgcolor="#CCCCCC"><input name="Changer3" type="submit" value="Changer" /></td>
  </form></tr>
  <tr><form action="userDataChange" method="post">
    <td align="left" valign="top" bgcolor="#CCCCCC"><span class="style1">
      <label>Prénom
      <input name="data2Change" type="hidden" id="d2cvorname" value="prenom" />
      </label>
    </span></td>
    <td align="left" valign="top" bgcolor="#CCCCCC"><input name="prenom"  type="text"  value="${sessionScope.utilisateur.prenom }" maxlength="50" /></td>
    <td align="left" valign="top" bgcolor="#CCCCCC"><input name="Changer4" type="submit" value="Changer" /></td>
  </form></tr>
  <tr><form action="userDataChange" method="post">
    <td align="left" valign="top" bgcolor="#CCCCCC"><span class="style1">Nom
        <input name="data2Change" type="hidden" id="d2cname" value="nom" />
    </span></td>
    <td align="left" valign="top" bgcolor="#CCCCCC"><input name="nom" type="text"  value="${sessionScope.utilisateur.nom }" maxlength="50" /></td>
    <td align="left" valign="top" bgcolor="#CCCCCC"><input name="Changer5" type="submit" value="Changer" /></td>
  </form></tr>
  <tr><form action="userDataChange" method="post">
    <td align="left" valign="top" bgcolor="#CCCCCC"><span class="style1">Email
        <input name="data2Change" type="hidden" id="d2cemail" value="email" />
    </span></td>
    <td align="left" valign="top" bgcolor="#CCCCCC"><input name="email"  type="text"  value="${sessionScope.utilisateur.email }" maxlength="50" /></td>
    <td align="left" valign="top" bgcolor="#CCCCCC"><input name="Changer6" type="submit" value="Changer" /></td>
  </form></tr>
   <tr><form action="userDataChange" method="post">
    <td align="left" valign="top" bgcolor="#CCCCCC"><span class="style1">Adresse
        <input name="data2Change" type="hidden" id="d2cadresse" value="adresse" />
    </span></td>
    <td align="left" valign="top" bgcolor="#CCCCCC"><textarea name="adresse" rows="2">${sessionScope.utilisateur.adresse }</textarea></td>
    <td align="left" valign="top" bgcolor="#CCCCCC"><input name="Changer6" type="submit" value="Changer" /></td>
  </form></tr>
</table>

<p>&nbsp;</p>

  <form action="userDataChange" method="post">
  <table width="100%" border="0">
    <tr>
      <td width="25%" height="29" align="left" valign="middle" bgcolor="#000000"><span class="style1">Changer de mot de passe</span></td>
      <td width="23%" bgcolor="#000000"><span class="style1"><input name="data2Change" type="hidden" id="d2cadresse" value="password" /></span></td>
      <td width="52%" bgcolor="#000000"><span class="style1"></span></td>
    </tr>
    <tr>
      <td align="left" valign="top" bgcolor="#CCCCCC"><span class="style1">Mot de passe</span></td>
      <td align="left" valign="top" bgcolor="#CCCCCC"><input name="password1" type="password" /></td>
      <td bgcolor="#CCCCCC">&nbsp;</td>
    </tr>
    <tr>
      <td align="left" valign="top" bgcolor="#CCCCCC"><span class="style1">Mot de passe
        <input name="data2Change" type="hidden" id="dd2cpassword" value="password"  />
      </span></td>
      <td align="left" valign="top" bgcolor="#CCCCCC"><input name="password2" type="password" /></td>
      <td align="left" valign="top" bgcolor="#CCCCCC"><input name="Changer" type="submit" value="Changer" /></td>
    </tr>
	<tr>
      <td colspan="3" align="left" valign="top">Le mot de passe doit :<br />
	  1) comporter 8 charactères <br />     
	  2) contenir au minimum 1 majuscule<br />
	  3) contenir au minimum 1 chiffre<br />
	  4) contenir au minimum 1 caractère sp&eacute;cial<br />
	 <c:forEach items="${errors}" var="element">
   	 <br><span class="requis">           ${element}</span>
    </c:forEach> 
	 </td>
    </tr>
  </table>
</form>
  </p> 
 <form id="form1" name="form1" method="get" action="upload">
  <table width="100%" border="0">
    <tr>
      <td width="25%" bgcolor="#000000"><span class="style1">Passer une annonce
      </span></td>
      <td width="23%" bgcolor="#000000">&nbsp;</td>
      <td width="52%" bgcolor="#000000"><input type="submit" name="Submit" value="Nouvelle annonce" /></td>
    </tr>
  </table>
  </form>


<p>&nbsp; </p>



<%@ include file="../finPage.jsp" %>
</body>
</html>