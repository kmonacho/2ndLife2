package com.secondLife.form;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.secondLife.beans.Utilisateur;

public class CreationUtilisateurForm2 {
	final String CHAMP_USERNAME = "username";
	final String CHAMP_PASSWORD1 = "password1";
	final String CHAMP_PASSWORD2 = "password2";
	final String CHAMP_PRENOM = "prenom";
	final String CHAMP_NOM = "nom";
	final String CHAMP_EMAIL = "email";
	final String CHAMP_ADRESSE = "adresse";
	
	boolean userCreationOk = false;
	String resultat;
	Map <String, String > erreurs = new Map <String, String>;
	
	public boolean getUserCreationOk() {
		return userCreationOk;
	}
	
	public String getResulat() {
		return resultat;
	}
	
	public Map <String, String > getErreurs() {
		return erreurs;
	}
	
	public Utilisateur creerUtilisateur(HttpServletRequest request) {
		String username = getValeurChamp(request, CHAMP_USERNAME);
		String password1 = getValeurChamp(request, CHAMP_PASSWORD1);
		String password2 = getValeurChamp(request, CHAMP_PASSWORD2);
		String prenom = getValeurChamp(request, CHAMP_PRENOM);
		String nom = getValeurChamp(request, CHAMP_NOM);
		String email = getValeurChamp(request, CHAMP_EMAIL);
		String adresse = getValeurChamp(request, CHAMP_ADRESSE);
		
		
		userCreationOk = validationPassword(username, password1, password2);
		
		Utilisateur utilisateur = new Utilisateur();
		
		utilisateur.setUsername(username);
		utilisateur.setPassword(password2);
		utilisateur.setPrenom(prenom);
		utilisateur.setNom(nom);
		utilisateur.setEmail(email);
		utilisateur.setAdresse(adresse);
		
		return utilisateur;
		
	}
	
	private String getValeurChamp(HttpServletRequest request, String champ) {
		String valeur = request.getParameter(champ);
		if (valeur == null || valeur.trim().length() == 0) return null;
		else return valeur;
	}

	private boolean validationPassword(String username, String password1, String password2) {
			boolean res = false;
			boolean passEgaux= false, minHuit = false, majuscule = false, chiffre = false, carZetta = false, chiffresEtZettaB = false;
			if (!username.equals(null)) {
					if (!username.equals(null) && !password1.equals(null) && !password2.equals(null)) {
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
									setErreur(CHAMP_PASSWORD1, "Vueillez entrez deux mot de passes égaux !" );
								}
					
								if (!minHuit) {
									setErreur(CHAMP_PASSWORD1, "Le mot de passe doit comporter 8 caractères au moins !" );
								}
								if (!majuscule) {
									setErreur(CHAMP_PASSWORD1, "Le mot de passe doit comporter une majuscule !" );
								}
								if (!chiffre) {
									setErreur(CHAMP_PASSWORD1, "Le mot de passe doit comporter un chiffre !" );
								}
								if (!carZetta) {
									setErreur(CHAMP_PASSWORD1, "Le mot de passe doit comporter une caractère special !" );
								}
							}
						}else {
							if (!passEgaux) {
								res = false;
						}
					}
			}
			else {
				res = true;
			}
		}
		return res;
	}

	private void affiche(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
	}
	
	private void setErreur(String key, String message) {
		// TODO Auto-generated method stub
		erreurs.put(key, message);
		
	}
	
}
