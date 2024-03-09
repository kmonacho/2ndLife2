package com.secondLife.servlets;

import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondLife.sql.Annonces;

/**
 * Servlet implementation class Search
 */
//@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/search.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
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
		Annonces annonces = new Annonces("");
		request.setAttribute("annonces", annonces.chercherAnnonce(searchWords));
		String str ="";
		Iterator it = searchWords.iterator();
		while (it.hasNext()) str+= it.next()+ "\n";
		request.setAttribute("searchWords", str);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

}
