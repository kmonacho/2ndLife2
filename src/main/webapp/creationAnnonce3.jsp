<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Accueil 2ndLife</title>
        <script>
            /* Cette fonction permet d'afficher une vignette pour chaque image sélectionnée */
            function readFilesAndDisplayPreview(files) {
                let imageList = document.querySelector('#list'); 
                imageList.innerHTML = "";
                
                for ( let file of files ) {
                    let reader = new FileReader();
                    
                    reader.addEventListener( "load", function( event ) {
                        let span = document.createElement('span');
                        span.innerHTML = '<img height="60" src="' + event.target.result + '" />';
                        imageList.appendChild( span );
                    });

                    reader.readAsDataURL( file );
                }
            }
        </script>
        <link type="text/css" rel="stylesheet" href="<c:url value="style.css" />" />
<style type="text/css">
.contener {
	display : grid;
	grid-template-columns : 200px 200px 200px 200px ;
	grid-template-rows : 200px 200px 200px 200px ;
	gap : 20px;
	
}
.box {
	font-size : 12px;
	width : 200px;
	height: 300px;
	border : 1px #DDDDDD solid;
	text-align: left;	
	background-color:#FFFFFF;
}
p {
	margin-left: 15px;
}
body {

	background-color:#EEEEEE
}
</style>
    </head>
<body>
<%@ include file="menu.jsp" %>
<h1>Nouvelle annonce</h1>
<body>
<br/>
<form id="form1" name="form1" method="post" action="creationAnnonce" enctype="multipart/form-data">
  <fieldset>
                <legend>Annonce</legend>
                <p>
				<label for="titre">Titre <span class="requis">*</span></label>
                <input type="text" id="titre" name="titre" value="" size="50" maxlength="60" />
                </p>
				<p>
                <label for="description">Description <span class="requis">*</span></label>
                <br />
                <textarea name="description" cols="60" rows="10"></textarea>
                </p>
              
			
			 
				<p>
				Information sur le vendeur :
				
				</p>
				<p>
				<label for="vendeur">Nom du vendeur (nom d'utilisateur) <span class="requis">*</span></label>
                <input type="text" id="vendeur" name="vendeur" value="" size="50" maxlength="60" />
				</p>
  <p>
                <label for="adresse">Adresse <span class="requis">*</span></label>
                <br />
				<textarea name="adresse" cols="60" rows="3"></textarea>
  </p>
				<p>
				  <input name="submit" type="submit" class="sansLabel" value="Cr&eacute;er l'anonce" />
				</p>
  </fieldset>
</form>
</body>
</html>

<%@ include file="finPage.jsp" %>
</body>
</html>