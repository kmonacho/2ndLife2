package com.secondLife.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondLife.beans.Utilisateur;
import com.secondLife.sql.Login;

/**
 * Servlet implementation class CreationUtilisateur
 */

public class CreationUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/creationUtilisateur.jsp";
	private static final String VUE_OK = "WEB-INF/login.jsp";
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String eamil = request.getParameter("email");
		String adresse = request.getParameter("adresse");
		affiche (username);
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setUsername(username);
		utilisateur.setPassword(password2);
		utilisateur.setPrenom(prenom);
		utilisateur.setNom(nom);
		utilisateur.setEmail(eamil);
		utilisateur.setAdresse(adresse);
		
		Login login = new Login();
		boolean userRecord = login.creerUtilisateur(utilisateur);
		if (userRecord) this.getServletContext().getRequestDispatcher(VUE_OK).forward(request, response);
		else this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	private void affiche(String str) {
		// TODO Auto-generated method stub
		System.out.println(str);
	}

}
