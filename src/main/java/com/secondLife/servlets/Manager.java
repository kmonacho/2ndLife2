package com.secondLife.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondLife.beans.Utilisateur;
import com.secondLife.sql.Login;

/**
 * Servlet implementation class Manager
 */

public class Manager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static final String VUE = "/accueil.jsp"; 
    private static final String VUE_OK = "/WEB-INF/manager.jsp";   
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
		Utilisateur utilisateur = (Utilisateur)request.getSession().getAttribute("utilisateur");
		if (utilisateur != null) {
			Login login = new Login(nomDB, nomDossierDB, passwordDB);
			request.setAttribute("utilisateurs", login.recupereUtilisateur());
			this.getServletContext().getRequestDispatcher(VUE_OK).forward(request, response);
			
		}
		else this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		Login login = new Login(nomDB, nomDossierDB, passwordDB);
		if (login.effacerUtilisateur(username)) request.setAttribute("log", "L'utilisateur "+username + " a �t� effac� de la table login.");
		else request.setAttribute("log", "L'utilisateur "+username + " n'a pas �t� effac� de la table login");
		request.setAttribute("utilisateurs", login.recupereUtilisateur());
		this.getServletContext().getRequestDispatcher(VUE_OK).forward(request, response);
	}

}
