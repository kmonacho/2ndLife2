package com.secondLife.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondLife.beans.Utilisateur;
import com.secondLife.sql.Login;
import com.secondLife.util.SMTPConnect;

/**
 * Servlet implementation class PassOublie
 */

public class PassOublie extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String VUE= "/passOublie.jsp";
    private String nomDB, nomDossierDB, passwordDB;
	private ServletConfig config;
	
    public void init() throws ServletException {
		
		this.config = this.getServletConfig();
		nomDB = config.getInitParameter("nomDB");
		nomDossierDB = config.getInitParameter("nomDossierDB");
		passwordDB = config.getInitParameter("passwordDB");
		System.out.println("nomDB : "+nomDB+ " / "+"nomDosssierDB : "+nomDossierDB+ " / "+"passwordDB : "+passwordDB);
	}
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		Login login = new Login(nomDB, nomDossierDB, passwordDB);
		Utilisateur utilisateur = login.recupereUtilisateurSelonEmail(email);
		
		String username = utilisateur.getUsername();
		System.out.println("username : "+username);
		SMTPConnect smtpConnect = new SMTPConnect();
		/*String sujet ="<html><head><title>Réinitialisation de votre mot de passe 2ndLife.com</title></head><body><p>Bonjour,</p>"+
		"<p>Pour r&eacute;initialiser votre mot de passe chez 2ndLife.com, veuillez clicker sur ce "+
		"<a href=\"http://localhost:8080/2ndLife/reinitialisation\">lien</a>.</p>"+
		"</body></html>";*/
		String sujet = "Pour réinitialiser votre mot de passe chez 2ndLife.com, veuillez cliquer sur le lien ci-dessous:\n"+
		"http://localhost:8080/2ndLife/reinitialisation?username="+username+"\"";
		smtpConnect.connect(email, "jmonacho@ik.me","2ndLife : reinitialisation de votre mot de passe", sujet);
		String message = "Un email pour réinitialiser votre mot de passe vous a été envoyé";
		request.setAttribute("message", message);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

}
