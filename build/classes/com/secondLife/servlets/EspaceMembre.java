package com.secondLife.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondLife.beans.Utilisateur;

/**
 * Servlet implementation class EspaceMembre
 */
//@WebServlet("/espaceMembre")
public class EspaceMembre extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String VUE = "/WEB-INF/login.jsp";  
    private static final String VUE_ANNONCE = "/WEB-INF/creationAnnonce0.jsp";
    private static final String VUE_OUT_SESSION = "/accueil";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EspaceMembre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Utilisateur utilisateur = (Utilisateur)request.getSession().getAttribute("utilisateur");
		if (utilisateur == null) this.getServletContext().getRequestDispatcher(VUE_OUT_SESSION).forward(request, response);
		else this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//this.getServletContext().getRequestDispatcher(VUE_ANNONCE).forward(request, response);
		doGet(request, response);
	}

}
