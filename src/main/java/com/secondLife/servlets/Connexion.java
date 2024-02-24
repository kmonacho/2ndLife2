package com.secondLife.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondLife.sql.Login;
import com.secondLife.beans.Utilisateur;

/**
 * Servlet implementation class Connexion
 */

public class Connexion extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/connexion.jsp";
	private static final String VUE_LOGIN = "/WEB-INF/login.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		affiche(username + " "+password);
		
		Login login = new Login();
		if (login.execTestPass(username, password)) {
			System.out.println("Password match");
			Utilisateur utilisateur = login.recupereUtilisateur(password);
			request.setAttribute("utilisateur", utilisateur);
			this.getServletContext().getRequestDispatcher(VUE_LOGIN).forward(request, response);
		}
		else this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	private void affiche(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
	}

}
