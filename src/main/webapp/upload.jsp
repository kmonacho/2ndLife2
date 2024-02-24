<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Accueil 2ndLife</title>
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
</head>
<body>
<%@ include file="menu.jsp" %>
<form id="form1" name="form1" method="post" action="upload" enctype="multipart/form-data">
  <fieldset>
                <legend> Image de l'annonce</legend>
               
                <p>
				 Première image : <input type="file" name="multiPartServlet" accept="image/*" multiple
                   onchange="readFilesAndDisplayPreview(this.files);" /><br>
                </p>
                <p>
				 Deuxième image : <input type="file" name="multiPartServlet" accept="image/*" multiple
                   onchange="readFilesAndDisplayPreview(this.files);" /><br>
                </p>
                <p>
				 Troisième image : <input type="file" name="multiPartServlet" accept="image/*" multiple
                   onchange="readFilesAndDisplayPreview(this.files);" /><br>
                </p>
               
				  <input name="Upload" type="submit" class="sansLabel" value="Cr&eacute;er l'anonce" />
				</p>
  </fieldset>
</form>
<%@ include file="finPage.jsp" %>
</body>
</html>