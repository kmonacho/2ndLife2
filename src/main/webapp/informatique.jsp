<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Catégorie Informatique 2ndLife</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="style.css" />" />
<style type="text/css">
.style1 {color: #FFFFFF}
</style>
    </head>
<body>
<%@ include file="menu.jsp" %>
<h1>Informatique</h1>
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
<table width="100%" border="0">
  <tr>
    <td bgcolor="#000000"><a id="${element.id}"></a><span class="style1"><h3>${element.titre}</h3></span></td>
  </tr>
  <tr>
    <td align="center" bgcolor="#CCCCCC"><img src="images/${element.img}" width="180"/>
			<img src="images/${element.img2}" width="180"/>
			<img src="images/${element.img3}" width="180"/>;</td>
  </tr>
  <tr>
    <td bgcolor="#CCCCCC"><span class="style1">${element.description }</span></td>
  </tr>
  <tr>
    <td bgcolor="#CCCCCC"><span class="style1">${element.prix } frs</span></td>
  </tr>
  <tr>
    <td bgcolor="#CCCCCC"><span class="style1">${element.vendeur}</span></td>
  </tr>
  <tr>
    <td bgcolor="#CCCCCC"><span class="style1">Date de mise en vente : ${element.dateMEV}</span></td>
  </tr>
  <tr>
    <td bgcolor="#CCCCCC" align="right"><form id="form1" name="form1" method="post" action="userDataChange">
      <input type="submit" name="Submit" value="Acheter" />
      <input name="id" type="hidden" id="id" value="${element.id }" />
        <input name="data2Change" type="hidden" id="data2Change" value="vendre" />
    </form> </td>
  </tr>
</table>
<p>
		...
		</p>
		<p>
		...
		</p>
		<p>
		...
		</p>
		<p>
		...
		</p>
		<p>
		...
		</p>
		<p>
		...
		</p>
		<p>
		...
		</p>
		<p>
		...
		</p>
		<p>
		...
		</p>
		<p>
		...
		</p>
</c:forEach>
<%@ include file="finPage.jsp" %>
</body>
</html>