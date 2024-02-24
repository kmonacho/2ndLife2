package com.secondLife.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.secondLife.beans.Article;

public class Articles {
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String conString;
	
	
	
	public Articles(String conString) {
		this.conString = conString;
	}
	
	public ArrayList<Article> recupereArticles() {
		ArrayList<Article> articles = new ArrayList<Article>();
		
		
        String protocole =  "jdbc:mysql:" ;
       // Adresse IP de l’hôte de la base et port
        String ip =  "localhost" ;  // dépend du contexte
        String port =  "3306" ;  // port MySQL par défaut
        String nomBase =  "2ndLife" ;  // dépend du contexte
        String conString = protocole +  "//" + ip +  ":" + port +  "/" + nomBase ;
        String nomConnexion =  "root" ;  // dépend du contexte
        String motDePasse =  "1Passmysqlserver$" ;  // dépend du contexte
        
       
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (Exception e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(
		                conString, nomConnexion, motDePasse); 
			//con = DriverManager.getConnection(conString); 
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT titre, prix, dateMEV, img FROM article");

			while(rs.next()) {
				String titre = rs.getString("titre");
				double prix = rs.getDouble("prix");
				String img = rs.getString("img");
				String dateMEV = rs.getString("dateMEV");
				
				Article article = new Article();
				article.setTitre(titre);
				article.setImg(img);
				article.setPrix(prix);
				article.setDateMEV(dateMEV);
				
				articles.add(article);
			}
		}
		catch (SQLException e) {
			System.out.println("Probl�me dE SQL");
			System.out.println ("Etat : " + e.getSQLState());
			System.out.println ("Message : " + e.getErrorCode());
			System.out.println ("Erreur code fourni : "+ e.getErrorCode());
			e.printStackTrace();
		}
		finally {
			if (rs != null) 
				try {
					rs.close();
					stmt.close();
					con.close();	
				}catch (Exception ex) {
					ex.printStackTrace();
				}
		}
		return articles;
	}
	
	private void connect(String conString) {
		try {
			con = DriverManager.getConnection(conString);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
