package com.secondLife.servlets;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.secondLife.sql.Articles;
import com.secondLife.beans.Annonce;


/*
 * Notre serlvet permettant de récupérer les fichiers côté serveur.
 * Elle répondra à l'URL /upload dans l'application Web considérée.
 */

@MultipartConfig( fileSizeThreshold = 1024 * 1024, 
                  maxFileSize = 1024 * 1024 * 5,
                  maxRequestSize = 1024 * 1024 * 5 * 5 )
public class Upload extends HttpServlet {

    private static final long serialVersionUID = 1273074928096412095L;
    
    /*
     * Chemin dans lequel les images seront sauvegardées.
     */
    public static final String IMAGES_FOLDER = "/images";
    public static final String VUE = "/upload.jsp";
    public static final String VUE_OK = "/WEB-INF/creationAnnonce1.jsp";
        
    public String uploadPath="C:\\Users\\Admin\\Documents\\Projets\\2ndLife\\src\\main\\webapp\\images";
    
    /*
     * Si le dossier de sauvegarde de l'image n'existe pas, on demande sa création.
     */ 
    @Override
    /*public void init() throws ServletException {
        uploadPath = getServletContext().getRealPath( IMAGES_FOLDER );
        File uploadDir = new File( uploadPath );
        if ( ! uploadDir.exists() ) uploadDir.mkdir();
    }*/
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	
	}
    /*
     * Récupération et sauvegarde du contenu de chaque image.
     */ 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException {
    	String fileName="";
    	Annonce annonce = new Annonce();
    	Vector <String> fileNames = new Vector<String>();
        for ( Part part : request.getParts() ) {
            fileName = getFileName( part );
            fileNames.add(fileName);
            
            String fullPath = uploadPath + File.separator + fileName;
            part.write( fullPath );
        	
        }
        annonce.setImg(fileNames.elementAt(fileNames.size()-4));
        annonce.setImg2(fileNames.elementAt(fileNames.size()-3));
        annonce.setImg3(fileNames.elementAt(fileNames.size()-2));
    	
    	System.out.println("img "+fileName);
    
    	
        request.setAttribute("annonce", annonce);
        this.getServletContext().getRequestDispatcher(VUE_OK).forward(request, resp);
    }

    /*
     * Récupération du nom du fichier dans la requête.
     */
    private String getFileName( Part part ) {
        for ( String content : part.getHeader( "content-disposition" ).split( ";" ) ) {
            if ( content.trim().startsWith( "filename" ) )
                return content.substring( content.indexOf( "=" ) + 2, content.length() - 1 );
        }
        return "Default.file";
    }

}