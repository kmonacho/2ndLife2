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

import com.secondLife.sql.Annonces;


/**
 * Servlet implementation class Accueil
 */

public class Accueil extends HttpServlet {
	
	private static final String VUE = "/accueil.jsp";
   
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Articles articles = new Articles("");
		//request.setAttribute("articles", articles.recupereArticles());
		Annonces annonces = new Annonces("");
		request.setAttribute("annonces", annonces.recupereAnnonces());
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
