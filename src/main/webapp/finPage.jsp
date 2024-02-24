<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Pied de Page</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="style.css"/>" />
    </head>
    <style type="text/css">
    a {
	font-family: Geneva, Arial, Helvetica, sans-serif;
	font-size: 12px;
	font-weight:bold;
	text-decoration: none;
	color:#1ac21a;
	}
	body, p, legend, label, input {
    	font: normal 8pt verdana, helvetica, sans-serif;
	}
    </style>
    <body>
<table width="100%" border="0">
      <tr>
        <td width="27%"><a href="accueil" tabindex="1" title="Accueil 2ndLife"><img src="images/logo.png" alt="Logo du site Interent  du magasin de vente en ligne de seconde main de différents objets"></a></td>
        <td width="56%">&nbsp;</td>
        <td width="17%">&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td><a href="CG.jsp" tabindex="2" title="Conditions Générales">CG</a> | <a href="preferences.jsp" tabindex="3" title="Gérer mes Préféfences">Gérer mes Préférences</a> | <a href="protectDonnees.jsp" tabindex="4" title="Protection des données">Protection des données</a> | <a href="aide.jsp" tabindex="5" title="Aide">Aide</a></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td align="right"><a href="www.facebook.com" title="Connection à Facebook"><img src="images/facebook.gif" width="25" height="29" alt="Facebook" /></a><a href="www.tweeter.com" title="Connection à X"><img src="images/tweeter.gif"  alt="Tweeter" /></a><a href="www.instagram.com" title="Connection à Intstagram"><img src="images/instagram.gif" " alt="Instagram" /></a></td>
      </tr>
    </table>     
</body>
</html>