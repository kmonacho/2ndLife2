<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<body>
<form id="form1" name="form1" method="post" action="upload" enctype="multipart/form-data">
  <fieldset>
                <legend> Image de l'annonce</legend>
               
                <p>
				 <input type="file" name="multiPartServlet" accept="image/*" multiple
                   onchange="readFilesAndDisplayPreview(this.files);" /><br>
                </p>
				  <input name="Upload" type="submit" class="sansLabel" value="Cr&eacute;er l'anonce" />
				</p>
  </fieldset>
</form>
</body>
</html>