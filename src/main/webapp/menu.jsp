<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Accueil 2ndLife</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="style.css"/>" />
    <style type="text/css">
    a {
	font-family: Geneva, Arial, Helvetica, sans-serif;
	font-size: 12px;
	font-style: normal;
	font-weight: normal;
	text-decoration: none;
	}
	body, p, legend, label, input {
    	font: normal 8pt verdana, helvetica, sans-serif;
	}
	.logo {
		font-size : 20px;	
	}
    </style>
    </head>
<body>
<table width="100%" border="0">
  <tr>
    <td width="18%"><h1><a href="accueil" title="Mettre en Vente" class="logo">2ndLife</a></h1></td>
    <td width="62%"></td>
    <td width="10%"><a href="vente" title="Mettre en Vente">Mettre en vente</a></td>
    <td width="10%"><a href="connexion" title="Se connecter">Se Connecter</a></td>
  </tr>
</table>
							   
<table width="100%" border="0">
  <tr>
    <td width="18%">&nbsp;</td>
    <td width="77%"><a href="mode" tabindex="1" title="Mode">Mode</a> |
     <a href="vehicules" tabindex="2" title="Véhicules">Vehicules</a>  
     | <a href="menageEtMaison" tabindex="3" title="Ménages & Maison">Menage & Maison</a> 
     | <a href="sport" tabindex="4" title="Sport">Sport</a> 
     | <a href="ordinateurs" tabindex="6" title="Ordinateurs">Ordinateurs</a></td>
    <td width="2%">&nbsp;</td>
    <td width="3%">&nbsp;</td>
  </tr>
</table>
</body>
</html>