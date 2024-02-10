<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
<!--
h1 {
	font-family: Geneva, Arial, Helvetica, sans-serif;
}

td {
	font-family: Geneva, Arial, Helvetica, sans-serif;
	font-size: 12px;
	font-style: normal;
	font-weight: normal;
	
}
-->
</style>
<title>Insert title here</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<h1>Connection</h1>
<p>Bienvenu sur le site Internet de vente de voitures d'occasions</p>
<table width="400" height="150" border="0">
<form id="form1" name="form1" method="post" action="Connexion">
  <tr>
    <td height="40" colspan="2"><strong>Entrez votre nom d'utilisateur et votre mot de passe</strong> </td>
  </tr>
  <tr>
    <td width="25%"><label>Nom d'utilisateur :</label></td>
    <td width="*"><input name="username" type="text" tabindex="1" size="30" /></td>
  </tr>
  <tr>
    <td><label>Mot de passe  :</label></td>
    <td><input name="pass" type="password" tabindex="2" size="30" /></td>
  </tr>
  <tr>
    <td><div align="right">
      <input type="reset" name="Submit2" value="Annuler" />
    </div></td>
    <td>
        
      <div align="left">
        <input type="submit" name="Submit" value="OK" />   
      </div></td>
  </tr>
  </form>
</table>
<p><a href="<%= request.getContextPath() %>/creationCompte.jsp">Créer un compte utilisateur</a></p>

</body>
</html>