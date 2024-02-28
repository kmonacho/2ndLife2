package com.secondLife.servlets;

import java.io.IOException;
import java.util.ArrayList;

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
	private static final String VUE = "/creationUtilisateur.jsp";
	private static final String VUE_OK = "/WEB-INF/login.jsp";
       

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
		
		//vérifier si les deux mots de passes sont égaux, qu'ils contiennent bien 1 majuscule, un chiffre et un caractère accentué ai moins
		ArrayList<String> errors = passwordAccept(password1, password2);
		
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
		
		System.out.println("errors : " +errors.toString());
		if (errors.isEmpty() && userRecord) this.getServletContext().getRequestDispatcher(VUE_OK).forward(request, response);
		else {
			request.setAttribute("errors", errors);
			if (!userRecord) request.setAttribute("existingUser", "Le nom d'utilisateur existe déjà !");
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		}
	}

	private ArrayList<String> passwordAccept(String password1, String password2) {
		// TODO Auto-generated method stub
		ArrayList<String> errors = new ArrayList<String>();
		final String PASSWORD_NOT_MATCH = "Vous n'avez pas entré 2 mot de passes égaux";
		final String LESS_THAN_8_CHAR = "Vous devez entrer un mot de passe d'au moins 8 charactères";
		final String LESS_THAN_1_MAJUSCULE = "Votre mot de passe doit comporter au moins 1 majuscule";
		final String LESS_THAN_1_DIGIT = "Votre mot de passe doit comporter au moins 1 chiffre";
		final String LESS_THAN_1_SPECIAL_CHAR = "Votre mot de passe doit comporter au moins 1 charactère spécial (\'+\',\'à\',\'&\',..)";
		boolean res = false;
		boolean passEgaux= false, minHuit = false, majuscule = false, chiffre = false, carZetta = false, chiffresEtZettaB = false;
		
		if (!password1.equals(null) && !password2.equals(null)) {
					if (password1.equals(password2)) {
						passEgaux = true;
						if (password1.length() >= 8) {
							minHuit = true;
						}
						String pass1 = password1.toUpperCase();
						char[] chiffresEtZetta = {'0','1','2','3','4','5','6','7','8','9','+','\"','*','ç','%','&','/','(',')','=','?',
								'~','è','!','é','à','$','-','_'};
						for (int i=0; i< pass1.length(); i++) {
							chiffresEtZettaB = false;
							char c1 = pass1.charAt(i);
							char c2 = password1.charAt(i);
							for (int j=0;j<chiffresEtZetta.length;j++) {
								if (c2 == chiffresEtZetta[j]) {
									chiffresEtZettaB = true;
								}
							}
							if (!chiffresEtZettaB && c1 == c2) {
								majuscule = true;
								break;
							}
						}
						for (int i=0; i< password1.length(); i++) {
							char c = password1.charAt(i);
							char[] chiffres = {'0','1','2','3','4','5','6','7','8','9'};
							for (int j=0;j<chiffres.length; j++) {
								if (c == chiffres[j]) {
									chiffre = true;
									break;	
								}
								if (chiffre) break;
							}
						}
						for (int i=0; i<password1.length(); i++) {
							char c = password1.charAt(i);
							char[] chiffres = {'+','*','ç','%','&','=','?','!','$','£'};
							for (int j=0;j<chiffres.length; j++) {
								if (c == chiffres[j]) {
									carZetta = true;
									break;
								}
								if (carZetta) break;
							}
						}
						if (minHuit && majuscule && chiffre && carZetta) {
							affiche ("les 4 critères de mot de pass sont respectés");
							res = true;
						}
						else {
							if (!passEgaux) {
								errors.add(PASSWORD_NOT_MATCH);
							}
							if (!minHuit) {
								errors.add(LESS_THAN_8_CHAR);
							}
							if (!majuscule) {
								errors.add(LESS_THAN_1_MAJUSCULE);
							}
							if (!chiffre) {
								errors.add(LESS_THAN_1_DIGIT);
							}
							if (!carZetta) {
								errors.add(LESS_THAN_1_SPECIAL_CHAR);
							}
						}
					}
			
		}
		return errors;
	}

	private void affiche(String str) {
		// TODO Auto-generated method stub
		System.out.println(str);
	}

}
