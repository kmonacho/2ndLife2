package com.secondLife.sql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.secondLife.beans.Utilisateur;

public class Login {
	Connection con = null;
	Statement stmt = null;
	ResultSet results = null;
	
	public boolean execTestPass(String username, String password) {
		String sqlText="-1";
		try {
			boolean pasFini;
			Class.forName("com.mysql.cj.jdbc.Driver");
	        String protocole =  "jdbc:mysql:" ;
	        // Adresse IP de l’hôte de la base et port
	        String ip =  "localhost" ;  // dépend du contexte
	        String port =  "3306" ;  // port MySQL par défaut
	        String nomBase =  "2ndLife" ;  // dépend du contexte
	        String conString = protocole +  "//" + ip +  ":" + port +  "/" + nomBase ;
	        String nomConnexion =  "root" ;  // dépend du contexte
	        String motDePasse =  "1Passmysqlserver$" ;  // dépend du contexte
	         
	        con = DriverManager.getConnection(
	                 conString, nomConnexion, motDePasse) ;
	        stmt = con.createStatement();    
	        affiche ("stmt fait ");
	        //affiche(execDML("USE xlogin"));
	        sqlText = "SELECT * FROM login WHERE username = '"+username+"'";
	        affiche(sqlText);
			
	        results = stmt.executeQuery(sqlText);
	        pasFini = results.next();
			// recupere le schema du resultat (nom des colonnes, type, ...)
	        String passwordV = results.getString("password");
	        affiche("passwordV : "+passwordV);
	        //String email =  results.getString("email");
	        con.close();
	        if (password.equals(passwordV)) return true;
	        else return false;
			
		}catch(SQLException e) {
			printSQLError(e);
			e.printStackTrace();
			return false;
			
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Utilisateur recupereUtilisateur( String password) {
		String sqlText="-1";
		Utilisateur utilisateur = new Utilisateur();
		try {
			boolean pasFini;
			Class.forName("com.mysql.cj.jdbc.Driver");
	        String protocole =  "jdbc:mysql:" ;
	        // Adresse IP de l’hôte de la base et port
	        String ip =  "localhost" ;  // dépend du contexte
	        String port =  "3306" ;  // port MySQL par défaut
	        String nomBase =  "2ndLife" ;  // dépend du contexte
	        String conString = protocole +  "//" + ip +  ":" + port +  "/" + nomBase ;
	        String nomConnexion =  "root" ;  // dépend du contexte
	        String motDePasse =  "1Passmysqlserver$" ;  // dépend du contexte
	         
	        con = DriverManager.getConnection(
	                 conString, nomConnexion, motDePasse) ;
	        stmt = con.createStatement();    
	        affiche ("stmt fait ");
	        //affiche(execDML("USE xlogin"));
	        sqlText = "SELECT * FROM login WHERE password = '"+password+"'";
	        affiche(sqlText);
			
	        results = stmt.executeQuery(sqlText);
	       
			// recupere le schema du resultat (nom des colonnes, type, ...)
	        boolean tuple = results.next();
	        String prenom = results.getString("prenom");
	        String nom = results.getString("nom");
	        String email = results.getString("email");
	        
	        utilisateur.setPrenom(prenom);
	        utilisateur.setNom(nom);   
	        utilisateur.setEmail(email);
		}
		catch (SQLException e) {
			System.out.println("Probl�me dE SQL");
			System.out.println ("Etat : " + e.getSQLState());
			System.out.println ("Message : " + e.getErrorCode());
			System.out.println ("Erreur code fourni : "+ e.getErrorCode());
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (results != null) 
				try {
					results.close();
					stmt.close();
					con.close();	
				}catch (Exception ex) {
					ex.printStackTrace();
				}
		}
		return utilisateur;
	}
	

	public static void printSQLError(SQLException e ) {
		
		System.out.println ("Etat : " + e.getSQLState());
		System.out.println ("Message : " + e.getErrorCode());
		System.out.println ("Erreur code fourni : "+ e.getErrorCode());
		e = e.getNextException();
		System.out.println ("Ereur SQL suivante  ");
	}
	

	private void affiche(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
	}
}
