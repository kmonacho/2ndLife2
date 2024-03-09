<%@ page pageEncoding="UTF-8"  import="javax.servlet.http.HttpSession" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Accueil 2ndLife</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="style.css"/>" />
    <style type="text/css">
   
    </style>
    </head>
<body>
<% 
HttpSession s = request.getSession();
if (s.getAttribute("utilisateur")!= null) out.println("<div align=\"right\"><a href=\"vente\" title=\"Mettre en Vente\">Mettre en vente</a> | <a href=\"deconnexion\">Se deconncecter</a><br/><a href=\"userDataChange\">Profil Utilisateur</a></div> ");
else out.println("<div align=\"right\"><a href=\"vente\" title=\"Mettre en Vente\">Mettre en vente</a> | <a href=\"connexion\">Se conncecter</a></div>");
%>
<table width="100%" border="0">
  <tr>
    <td width="18%"><h1><a href="accueil" title="Mettre en Vente" class="logo"><img src="images/logo.png" alt="Logi du site de vente de second main 2ndLife" width="200" height="72"></a></h1></td>
    <td> </td>
  </tr>
</table>
							   
<table width="100%" border="0">
  <tr>
    <td width="18%">&nbsp;</td>
    <td width="60%"><a href="mode" tabindex="1" title="Article de mode">Mode</a> |
     <a href="vehicule" tabindex="2" title="Véhicules">Vehicules</a>  
     | <a href="menageEtMaison" tabindex="3" title="Ménages & Maison">Menage & Maison</a> 
     | <a href="sport" tabindex="4" title="Sport">Sport</a> 
     | <a href="informatique" tabindex="5" title="informatique">informatique</a></td>
    <td width="2%">&nbsp;</td>
    <td width="20%"><form action="search" method="post"><input name="search" type="text" size="40" /><input name="Submit" type="submit" value="Chercher" />
</form></td>
  </tr>
</table>
</body>
</a<>