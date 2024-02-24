package com.secondLife.servlets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.batch.FileSystem;

import com.secondLife.sql.Articles;

/**
 * Servlet implementation class Accueil
 */

public class Accueil extends HttpServlet {
	
	private static final String VUE = "/accueil.jsp";
    private static final String CHEMIN = "bdd";
    private static final String CHEMIN_FICHIER = "D:/Java/Projets/2ndLife/src/main/webapp/2ndLife.ini";
    private static final String BDD = "@BDD:";
	
    
    /*public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
    	try {
    		BufferedReader br = new BufferedReader(new FileReader(CHEMIN_FICHIER));
    		String ligne;
    		while ((ligne = br.readLine()) != null) {
    			if (ligne.startsWith(BDD)) {
    				System.out.println(ligne.substring(BDD.length()));
    			}
    		}
    		br.close();
    	}catch (IOException e) {
    		e.printStackTrace();
    	}
    }*/
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String conString =  "jdbc:ucanaccess://D://Java//Projets//2ndLife//src//main//webapp//2mdLife.mdb";
		Articles articles = new Articles(conString);
		request.setAttribute("articles", articles.recupereArticles());
		String path2Projet = System.getProperty("user.dir");
		Path path = FileSystems.getDefault().getPath("");
		path2Projet = path.toAbsolutePath().toString();
		path2Projet = request.getContextPath().toString();
		path2Projet = request.getServletPath();
		affiche("repertoire du projet "+path2Projet);
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	
	}

	private void affiche(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}
	
	

}
