package com.secondLife.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SMTPConnect {
	
	public void connect(String to, String from, String sujet, String body) {
		// TODO Auto-generated method stub
		  final String username = "jmonacho@ik.me";
	      final String password = "Soleil626$";
	        // Assuming you are sending email through relay.jangosmtp.net
	      

	      Properties props = new Properties();
	     
	      String host = "mail.infomaniak.com";
	      props.put("mail.smtp.auth", "true"); 
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "587");
	      props.put("mail.transport.protocol", "smtp");
	      props.put("mail.smtp.ssl.trust", "mail.infomaniak.com");
	      props.put("mail.smtp.debug", "true");
	      props.put("mail.smtp.ssl.protocols", "TLSv1.2");
	      
	      
	      // Get the Session object.
	      Session session = Session.getInstance(props,
	      new javax.mail.Authenticator() {
	         protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	         }
	      });

	      try {
	         // Create a default MimeMessage object.
	         Message message = new MimeMessage(session);

	         message.setFrom(new InternetAddress(from));

	         message.setRecipients(Message.RecipientType.TO,
	         InternetAddress.parse(to));

	         message.setSubject(sujet);

	         message.setText(body);
     
	         Transport.send(message);

	         System.out.println("Email envoyé à "+ to);

	      } catch (MessagingException e) {
	    	  	e.printStackTrace();
	            throw new RuntimeException(e);
	      }
	   }
	}