package com.secondLife.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.secondLife.sql.Annonces;
import com.secondLife.sql.Login;
import com.secondLife.beans.Utilisateur;

/**
 * Servlet implementation class Connexion
 */

public class Connexion extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/connexion.jsp";
	private static final String VUE_LOGIN = "/userDataChange";
       
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
			Utilisateur utilisateur = login.recupereUtilisateur(username);
			HttpSession session = request.getSession();
			session.setAttribute("utilisateur", utilisateur);
			
			Cookie cookie = new Cookie("2ndLife",utilisateur.getUsername());
			cookie.setComment("2ndLife cookie for session "+ session.getId());
			cookie.setMaxAge(60*2);
			response.addCookie(cookie);
			
			Annonces annonces = new Annonces("");
			affiche("username utilisateur : "+utilisateur.getUsername());
			request.setAttribute("annonces", annonces.recupereAnnonceUtilisateur(utilisateur.getUsername()));
			this.getServletContext().getRequestDispatcher(VUE_LOGIN).forward(request, response);
		}
		else this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	private void affiche(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
	}

}
