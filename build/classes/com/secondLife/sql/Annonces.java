package com.secondLife.sql;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import java.util.Iterator;
import java.util.StringTokenizer;

import com.secondLife.beans.Annonce;
import com.secondLife.beans.Article;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Annonces {
	
	
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String conString;
	
	public Annonces(String conString) {
		this.conString = conString;
	}
	
public ArrayList<Annonce> recupereAnnonces() {
		
		ArrayList<Annonce> annonces = new ArrayList<Annonce>();
		
		
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
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM article");

			while(rs.next()) {
				
				String categorie2 = rs.getString("categorie");
				int id = rs.getInt("id");
				affiche("id : "+id);
				String titre = rs.getString("titre");
				String description = rs.getString("description");
				String adresse = rs.getString("adresse");
				String vendeur = rs.getString("vendeur");
				double prix = rs.getDouble("prix");
				String img = rs.getString("img");
				String img2 = rs.getString("img2");
				String img3 = rs.getString("img3");
				String dateMEV = rs.getString("dateMEV");
				
				//affiche(titre + " | "+ description + " | " +adresse +  " | "+ vendeur);
				
				
				Annonce  annonce = new Annonce();
				annonce.setId(id);
				annonce.setTitre(titre);
				annonce.setDescription(description);
				annonce.setAdresse(adresse);
				annonce.setVendeur(vendeur);
				annonce.setImg(img);
				annonce.setImg2(img2);
				annonce.setImg3(img3);
				annonce.setCategorie(categorie2);
				DecimalFormat df = new DecimalFormat();
				df.setMinimumIntegerDigits(2);
				df.setMaximumIntegerDigits(2);
				annonce.setPrix(df.format(prix));
				annonce.setDateMEV(dateMEV);
				
				annonces.add(annonce);
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
		return annonces;
	}
	
	public ArrayList<Annonce> recupereAnnonceCategorie(String categorie) {
		
		ArrayList<Annonce> annonces = new ArrayList<Annonce>();
		
		
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
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM article"+
			 " WHERE categorie = '" + categorie+"'");

			while(rs.next()) {
				
				String categorie2 = rs.getString("categorie");
				int id = rs.getInt("id");
				affiche("id : "+id);
				String titre = rs.getString("titre");
				String description = rs.getString("description");
				String adresse = rs.getString("adresse");
				String vendeur = rs.getString("vendeur");
				double prix = rs.getDouble("prix");
				String img = rs.getString("img");
				String img2 = rs.getString("img2");
				String img3 = rs.getString("img3");
				String dateMEV = rs.getString("dateMEV");
				
				affiche(titre + " | "+ description + " | " +adresse +  " | "+ vendeur);
				
				
				Annonce  annonce = new Annonce();
				annonce.setId(id);
				annonce.setTitre(titre);
				annonce.setDescription(description);
				annonce.setAdresse(adresse);
				annonce.setVendeur(vendeur);
				annonce.setImg(img);
				annonce.setImg2(img2);
				annonce.setImg3(img3);
				annonce.setCategorie(categorie2);
				DecimalFormat df = new DecimalFormat();
				df.setMinimumIntegerDigits(2);
				annonce.setPrix(df.format(prix));
				annonce.setDateMEV(dateMEV);
				
				annonces.add(annonce);
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
		return annonces;
	}
	
	public void creeAnnonce(Annonce annonce) {

        String protocole =  "jdbc:mysql:" ;
        String ip =  "localhost" ;  // dépend du contexte
        String port =  "3306" ;  // port MySQL par défaut
        String nomBase =  "2ndLife" ;  // dépend du contexte
        String conString = protocole +  "//" + ip +  ":" + port +  "/" + nomBase ;
        String nomConnexion =  "root" ;  // dépend du contexte
        String motDePasse =  "1Passmysqlserver$" ;  // dépend du contexte
        int id=0;
       
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (Exception e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(
		                conString, nomConnexion, motDePasse); 
			stmt = con.createStatement();
			String sql = "SELECT id FROM article ORDER BY id";
			rs = stmt.executeQuery(sql);

			while(rs.next()) {		
				id = rs.getInt("id");
			}
			id++;	
			annonce.setId(id);;
			

			sql = "INSERT INTO article (id, titre,description, adresse, vendeur, categorie, prix, dateMEV, img, img2, img3)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
			affiche("Annonce : "+ annonce.getTitre());
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
            preparedStatement.setString(2, annonce.getTitre());
            preparedStatement.setString(3, annonce.getDescription());
            preparedStatement.setString(4, annonce.getAdresse());
            preparedStatement.setString(5, annonce.getVendeur());
            preparedStatement.setString(6, annonce.getCategorie());
            preparedStatement.setDouble(7, Double.parseDouble(annonce.getPrix()));
            preparedStatement.setString(8, annonce.getDateMEV());
            preparedStatement.setString(9, annonce.getImg());
            preparedStatement.setString(10, annonce.getImg2());
            preparedStatement.setString(11, annonce.getImg3());
            
            int row = preparedStatement.executeUpdate();   
            if (row > 0) {
                affiche("Une annonce a ete enregistree dans la table article.");
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
	}
	public ArrayList<Annonce> recupereAnnonceUtilisateur(String username) {
	
	ArrayList<Annonce> annonces = new ArrayList<Annonce>();
	
	
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
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT * FROM article"+
		 " WHERE vendeur = '" + username+"'");
		affiche("1");
		while(rs.next()) {
			
			String categorie2 = rs.getString("categorie");
			int id = rs.getInt("id");
			
			String titre = rs.getString("titre");
			String description = rs.getString("description");
			String adresse = rs.getString("adresse");
			String vendeur = rs.getString("vendeur");
			double prix = rs.getDouble("prix");
			String img = rs.getString("img");
			String img2 = rs.getString("img2");
			String img3 = rs.getString("img3");
			String dateMEV = rs.getString("dateMEV");
			
			affiche(titre + " | "+ description + " | " +adresse +  " | "+ vendeur);
			
			
			Annonce  annonce = new Annonce();
			annonce.setId(id);
			annonce.setTitre(titre);
			annonce.setDescription(description);
			annonce.setAdresse(adresse);
			annonce.setVendeur(vendeur);
			annonce.setImg(img);
			annonce.setImg2(img2);
			annonce.setImg3(img3);
			annonce.setCategorie(categorie2);
			annonce.setPrix(prix+"");
			annonce.setDateMEV(dateMEV);
			affiche("2");
			affiche("dateMEV annonce dont le titre est" +annonce.getTitre()+" / " +annonce.getDateMEV());
			annonces.add(annonce);
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
	return annonces;
}
	public boolean effacerAnnonce(int id) {
		String protocole =  "jdbc:mysql:" ;
		 // Adresse IP de l’hôte de la base et port
		  String ip =  "localhost" ;  // dépend du contexte
		  String port =  "3306" ;  // port MySQL par défaut
		  String nomBase =  "2ndLife" ;  // dépend du contexte
		  String conString = protocole +  "//" + ip +  ":" + port +  "/" + nomBase ;
		  String nomConnexion =  "root" ;  // dépend du contexte
		  String motDePasse =  "1Passmysqlserver$" ;  // dépend du contexte
		  affiche("1");  
		   
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}catch (Exception e) {
				e.printStackTrace();
			}
			try {
				con = DriverManager.getConnection(
			                conString, nomConnexion, motDePasse); 
				stmt = con.createStatement();
				int row = stmt.executeUpdate("DELETE FROM article WHERE id = "+ id);
				if (row > 0) System.out.println("Effacement d'"+row+" tuple(no"+id+") de la table article");
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
		return true;
	}
	
	public ArrayList<Annonce> chercherAnnonce(Vector<String> searchTokens) {
		String protocole =  "jdbc:mysql:" ;
		 // Adresse IP de l’hôte de la base et port
		  String ip =  "localhost" ;  // dépend du contexte
		  String port =  "3306" ;  // port MySQL par défaut
		  String nomBase =  "2ndLife" ;  // dépend du contexte
		  String conString = protocole +  "//" + ip +  ":" + port +  "/" + nomBase ;
		  String nomConnexion =  "root" ;  // dépend du contexte
		  String motDePasse =  "1Passmysqlserver$" ;  // dépend du contexte
		  ArrayList<Annonce> annonces = new ArrayList<Annonce>(); 
		   
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}catch (Exception e) {
				e.printStackTrace();
			}
			try {
				con = DriverManager.getConnection(
			                conString, nomConnexion, motDePasse); 
				stmt = con.createStatement();
				rs = stmt.executeQuery("SELECT * FROM article");
						
						while(rs.next()) {
							
						
							String categorie2 = rs.getString("categorie");
							int id = rs.getInt("id");
							affiche("id : "+id);
							String titre = rs.getString("titre");
							String description = rs.getString("description");
							String adresse = rs.getString("adresse");
							String vendeur = rs.getString("vendeur");
							double prix = rs.getDouble("prix");
							String img = rs.getString("img");
							String img2 = rs.getString("img2");
							String img3 = rs.getString("img3");
							String dateMEV = rs.getString("dateMEV");
							
							//affiche(titre + " | "+ description + " | " +adresse +  " | "+ vendeur);
							
							
							Annonce  annonce = new Annonce();
							annonce.setId(id);
							annonce.setTitre(titre);
							annonce.setDescription(description);
							annonce.setAdresse(adresse);
							annonce.setVendeur(vendeur);
							annonce.setImg(img);
							annonce.setImg2(img2);
							annonce.setImg3(img3);
							annonce.setCategorie(categorie2);
							DecimalFormat df = new DecimalFormat();
							df.setMinimumIntegerDigits(2);
							df.setMaximumIntegerDigits(2);
							annonce.setPrix(df.format(prix));
							annonce.setDateMEV(dateMEV);
							
							
							Iterator<String> it = searchTokens.iterator();
							while (it.hasNext()){
								affiche("no : "+it.toString());
								if (search(titre, description, vendeur, prix, dateMEV, it.next())) {
									annonces.add(annonce);
									System.out.println("id de l'annonce dont le titre, la description,le prix, ou la dateMEV correspond avec le mot cl� => id : "+id);
								}
							}							
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
		return annonces;
	}
	
	/*private boolean search(String titre, String description, String vendeur, double prix, String dateMEV, String next) {
		// TODO Auto-generated method stub
		CharSequence cs = next;
		if (titre.contains(cs)) return true;
		if (description.contains(cs))return true;
		if (vendeur.contains(cs))return true;
		if (dateMEV.contains(cs))return true;
		return false;
		
	}*/
	
	private boolean search(String titre, String description, String vendeur, double prix, String dateMEV, String next) {
		// TODO Auto-generated method stub
		next = next.toLowerCase();
		StringTokenizer st = new StringTokenizer(titre);
		while (st.hasMoreElements()) {
			String token = st.nextToken().toLowerCase();
			if (next.equals(token))return true;
		}
		st = new StringTokenizer(description);
		while(st.hasMoreElements()) {
			String token = st.nextToken().toLowerCase();
			if (next.equals(token))return true;
		}
		st = new StringTokenizer(vendeur);
		while(st.hasMoreElements()) {
			String token = st.nextToken().toLowerCase();
			if (next.equals(token))return true;
		}
		st = new StringTokenizer(prix+"");
		while(st.hasMoreElements()) {
			String token = st.nextToken().toLowerCase();
			if (next.equals(token))return true;
		}
		return false;
		
	}

	private void affiche(String string) {
		System.out.println(string);
		
	}
}
