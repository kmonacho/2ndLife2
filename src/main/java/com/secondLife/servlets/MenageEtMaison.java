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
 * Servlet implementation class MenageEtMaison
 */

public class MenageEtMaison extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String VUE = "/menageEtMaison.jsp";
    private String nomDB, nomDossierDB, passwordDB;
   	private ServletConfig config;   

    public void init() throws ServletException {
		
		this.config = this.getServletConfig();
		nomDB = config.getInitParameter("nomDB");
		nomDossierDB = config.getInitParameter("nomDossierDB");
		passwordDB = config.getInitParameter("passwordDB");
	}   


	/**
	 * @se HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String conString =  "";
		Annonces annonces = new Annonces(nomDB, nomDossierDB, passwordDB);
		request.setAttribute("annonces", annonces.recupereAnnonceCategorie("menageEtMaison"));
		
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
