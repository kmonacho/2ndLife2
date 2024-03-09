package com.secondLife.servlets;

import java.io.IOException;
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
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sport() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String conString =  "";
		Annonces annonces = new Annonces(conString);
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
