<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Catégorie sport 2ndLife</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="style.css" />" />
<style type="text/css">

</style>
    </head>
<body>
<%@ include file="menu.jsp" %>
<h1>Sport</h1>
<c:forEach items="${annonces}" var="element">
<center><div class="annonce"><p><b>${element.titre}</b></p><a id="${element.id}"></a>
  
     <center> <p><img src="images/${element.img}" height="300" />;
     <img src="images/${element.img2}" height="300" />
      <img src= "images/${element.img3}" height="300"/></p></center>
 
  <p><span class="souligne">Description</span><br/>${element.description}</p>
  <p><span class="souligne">Prix</span><br/>  ${element.prix } frs</p>
  <p><span class="souligne">Vendeur</span><br/>  ${element.vendeur}</p>
  <p><span class="souligne"> Date de mise en vente</span><br/> ${element.dateMEV}</p>
</div>
<div class="vendre"><form id="form1" name="form1" method="post" action="userDataChange">
      <input type="submit" name="Submit" value="Acheter" />
      <input name="id" type="hidden" id="id" value="${element.id }" />
        <input name="data2Change" type="hidden" id="data2Change" value="vendre" />
</div></center>
<p> </p>
</c:forEach>
<%@ include file="finPage.jsp" %>
</body>
</html>