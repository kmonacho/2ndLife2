package com.secondLife.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.secondLife.beans.Utilisateur;
import com.secondLife.sql.Annonces;
import com.secondLife.sql.Login;

/**
 * Servlet implementation class UserDataChange
 */
//@WebServlet("/UserDataChange")
public class UserDataChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/login.jsp"; 
	private static final String PASSWORD_CHANGED = "/WEB-INF/passConfirmation.jsp";
	 private static final String VUE_OUT_SESSION = "/accueil";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDataChange() {
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
		else {
			Annonces annonces = new Annonces("");
			affiche("username utilisateur : "+utilisateur.getUsername());
			request.setAttribute("annonces", annonces.recupereAnnonceUtilisateur(utilisateur.getUsername()));
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String paramAChanger = request.getParameter("data2Change");
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur)session.getAttribute("utilisateur");
		affiche ("username utilisateur : "+utilisateur.getUsername());
		Login login = new Login();
		if (paramAChanger == null) this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		else {
			switch(paramAChanger) {
		
			case "username" : 
				String username = request.getParameter("username");
				System.out.println(login.modifieUsernameUtilisateur(username, utilisateur.getUsername()));
				utilisateur.setUsername(username);
				this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
				break;
			case "prenom" :
				String prenom = request.getParameter("prenom");
				affiche(login.modifiePrenomUtilisateur(prenom, utilisateur.getUsername()));
				utilisateur.setPrenom(prenom);
				this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
				break;
			case "nom" :
				String nom = request.getParameter("nom");
				affiche(login.modifieNomUtilisateur(nom, utilisateur.getUsername()));
				utilisateur.setNom(nom);
				this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
				break;
			case "email" :
				String email = request.getParameter("email");
				affiche(login.modifieEmailUtilisateur(email, utilisateur.getUsername()));
				utilisateur.setEmail(email);
				this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
				break;
				
			case "adresse" :
				String adresse = request.getParameter("adresse");
				affiche(login.modifieAdresseUtilisateur(adresse, utilisateur.getUsername()));
				utilisateur.setAdresse(adresse);
				this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
				break;
			case "password":
				String password1 = request.getParameter("password1");
				String password2 = request.getParameter("password2");
				affiche("passwords : "+password1 + " / "+password2);
				//vérifier si les deux mots de passes sont égaux, qu'ils contiennent bien 1 majuscule, un chiffre et un caractère accentué ai moins
				ArrayList<String> errors = passwordAccept(password1, password2);
				affiche(login.modifiePasswordUtilisateur(password2, utilisateur.getUsername()));
				if (errors.isEmpty()) this.getServletContext().getRequestDispatcher(PASSWORD_CHANGED).forward(request, response);
				else {
					request.setAttribute("errors", errors);
					this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
				}
				break;
			case "vendre" :
				Annonces annonces = new Annonces("");
				annonces.effacerAnnonce(0)
				
				
				
		}	
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
						affiche("pass égaux");
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
					}else errors.add(PASSWORD_NOT_MATCH);
			
		}
		return errors;
	}

	private void affiche(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
	}

}
