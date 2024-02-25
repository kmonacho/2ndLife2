package com.secondLife.servlets;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.secondLife.beans.Annonce;
import com.secondLife.sql.Annonces;

/**
 * Servlet implementation class CreationAnnonce
 */

public class CreationAnnonce extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String VUE = "/upload.jsp";
    private static final String VUE_OK = "/informatique";
  
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationAnnonce() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String fileName = (String)request.getAttribute("fileName");
		//request.setAttribute("fileName", fileName);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String titre = request.getParameter("titre");
		System.out.println("titre : "+ titre);
		String description = request.getParameter("description");
		String img = request.getParameter("img");
		String img2 = request.getParameter("img2");
		String img3 = request.getParameter("img3");
		String categorie = request.getParameter("categorie");
		String vendeur = request.getParameter("vendeur");
		String adresse = request.getParameter("adresse");
		String prix = request.getParameter("prix");
		System.out.println("prix : "+prix);
		Annonce annonce = new Annonce();
		annonce.setTitre(titre);
		annonce.setDescription(description);
		annonce.setCategorie(categorie);
		annonce.setImg(img);
		annonce.setImg2(img2);
		annonce.setImg3(img3);
		annonce.setVendeur(vendeur);
		annonce.setAdresse(adresse);
		double prixD =0;
		try {
			prixD = Double.parseDouble(prix);
		}catch (NumberFormatException e) {e.printStackTrace();}
		annonce.setPrix(prixD);
		annonce.setDateMEV(new Date().toString());
		
		
		
		Annonces a = new Annonces("");
		a.creeAnnonce(annonce);
		//request.setAttribute("annonce", annonce);
		request.setAttribute("annonces", a.recupereAnnonceCategorie("informatique"));

		this.getServletContext().getRequestDispatcher(VUE_OK).forward(request, response);

	}
	

	private void affiche(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
	}

}
