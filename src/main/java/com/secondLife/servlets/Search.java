package com.secondLife.servlets;

import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondLife.sql.Annonces;
import com.secondLife.beans.Annonce;

/**
 * Servlet implementation class Search
 */
//@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/search.jsp";
	private String nomDB, nomDossierDB, passwordDB;
	private ServletConfig config;   

	public void init() throws ServletException {
			
		this.config = this.getServletConfig();
		nomDB = config.getInitParameter("nomDB");
		nomDossierDB = config.getInitParameter("nomDossierDB");
		passwordDB = config.getInitParameter("passwordDB");
	}         
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Vector<String> searchWords = new Vector<String>();
		String search = request.getParameter("search");
		search = search.trim();
		System.out.println("search : " + search);
		StringTokenizer st = new StringTokenizer(search, " ");
		while (st.hasMoreTokens()) {
			searchWords.add(st.nextToken());
			System.out.println("searchWords : " + searchWords);
		}
		Annonces annonces = new Annonces(nomDB, nomDossierDB, passwordDB);
		ArrayList<Annonce> annoncesL = annonces.chercherAnnonce(searchWords);
		request.setAttribute("annonces",annoncesL );
		String str ="", noMatch="";
		if (annoncesL.size() == 0) noMatch="Aucun résultats ne correspond à votre recherche. <br/>Essayez avec d'autres mots clé !";
		Iterator<String> it = searchWords.iterator();
		while (it.hasNext()) str+= it.next()+ "\n";
		request.setAttribute("searchWords", str);
		request.setAttribute("noMatch", noMatch);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

}
