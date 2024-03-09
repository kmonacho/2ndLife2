package com.secondLife.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.secondLife.beans.Utilisateur;

/**
 * Servlet implementation class Vente
 */

public class Vente extends HttpServlet {

    private static final String VUE = "/connexion.jsp";
    private static final String VUE_SESSION_IN = "/WEB-INF/upload.jsp";
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isLogged = false;
		String user ="";
		Utilisateur utilisateur = (Utilisateur)request.getSession().getAttribute("utilisateur");
		Cookie[] cookies = request.getCookies();
		if (cookies != null ) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("2ndLife")) {
					isLogged = true;
					user = cookie.getValue();
					System.out.println("isLogged "+isLogged);
				}
			}
		}
		if (utilisateur != null || isLogged) {
			this.getServletContext().getRequestDispatcher(VUE_SESSION_IN).forward(request, response);
			System.out.println("utilisateur != null ou isLogged = true");
		}
		else this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		
		/*HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur)session.getAttribute("utilisateur");
		if (utilisateur != null)this.getServletContext().getRequestDispatcher(VUE_SESSION_IN).forward(request, response);
		else this.getServletContext().getRequestDispatcher(VUE).forward(request, response);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
