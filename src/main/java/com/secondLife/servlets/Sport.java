package com.secondLife.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondLife.sql.Annonces;

/**
 * Servlet implementation class Sport
 */
//@WebServlet("/sport")
public class Sport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE ="/sport.jsp";
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
		
		Annonces annonces = new Annonces(nomDB, nomDossierDB, passwordDB);
		request.setAttribute("annonces", annonces.recupereAnnonceCategorie("sport"));
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
