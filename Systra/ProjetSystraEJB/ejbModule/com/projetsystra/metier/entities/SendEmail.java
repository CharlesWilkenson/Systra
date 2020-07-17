package com.projetsystra.metier.entities;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.security.GeneralSecurityException;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Properties;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.sun.mail.util.MailSSLSocketFactory;




public class SendEmail {
	static String emailFrom="agritechsystra01@gmail.com";
	 final static String username="fflgroup06";
	 final static String password="Agri@1234";
     final static String agritechEmail="agritechsystra01@gmail.com";
	 
	 public static  boolean sendEmail(String passwordUser,String emailTo){
		   String sujet="Mot de passe";  
		   String message="Voici votre mot de passe tachez de le garder secret   ";

			Properties props = new Properties();
		
			  props.put("mail.transport.protocol", "smtp"); 
			  props.put("mail.debug", "true");
			    props.put("mail.smtp.starttls.enable", "true");
			    props.put("mail.smtp.socketFactory.port","465");
			    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");    
			    props.put("mail.smtp.auth", "true");    
			    props.put("mail.smtp.host", "smtp.gmail.com");
			    props.put("mail.smtp.port", "465");
			    props.put("mail.smtp.timeout", "10000");    
			    props.put("mail.smtp.ssl.checkserveridentity", "false");
			    props.put("mail.smtp.ssl.trust", "*");
			    props.put("mail.smtp.connectiontimeout", "10000");    
			    props.put("mail.smtp.debug", "true");
			    props.put("mail.smtp.socketFactory.fallback", "false");


		 	Session session=Session.getInstance(props,new javax.mail.Authenticator(){
		 	protected PasswordAuthentication getPasswordAuthentication(){
		 		return new PasswordAuthentication(emailFrom,password);
		 	}
		 		
		 	});

		 	try {
		 		Message mailMessage=new MimeMessage(session);
		 		mailMessage.setFrom(new InternetAddress(emailFrom));
		 		mailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
		 	
		 mailMessage.setSubject(sujet);
		 mailMessage.setText(message+passwordUser);
		 Transport.send(mailMessage);
		 System.out.println("Email envoye avec succes");
		 	} catch (MessagingException e) {

		 		 System.out.println("Unable to send mail"+e.getMessage());
		 		throw new RuntimeException(e);
		 		
		 	}

			
			return true;
		 }
	 
	 public static void repondreClient(String message,String emailTo){
		 String sujet="Réponse d'AGRITECH";  
		   
			Properties props = new Properties();
		
			  props.put("mail.transport.protocol", "smtp"); 
			  props.put("mail.debug", "true");
			    props.put("mail.smtp.starttls.enable", "true");
			    props.put("mail.smtp.socketFactory.port","465");
			    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");    
			    props.put("mail.smtp.auth", "true");    
			    props.put("mail.smtp.host", "smtp.gmail.com");
			    props.put("mail.smtp.port", "465");
			    props.put("mail.smtp.timeout", "10000");    
			    props.put("mail.smtp.ssl.checkserveridentity", "false");
			    props.put("mail.smtp.ssl.trust", "*");
			    props.put("mail.smtp.connectiontimeout", "10000");    
			    props.put("mail.smtp.debug", "true");
			    props.put("mail.smtp.socketFactory.fallback", "false");


		 	Session session=Session.getInstance(props,new javax.mail.Authenticator(){
		 	protected PasswordAuthentication getPasswordAuthentication(){
		 		return new PasswordAuthentication(emailFrom,password);
		 	}
		 		
		 	});

		 	try {
		 		Message mailMessage=new MimeMessage(session);
		 		mailMessage.setFrom(new InternetAddress(emailFrom));
		 		mailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
		 	
		 mailMessage.setSubject(sujet);
		 mailMessage.setText(message);
		 Transport.send(mailMessage);
		 System.out.println("Email envoyé avec succes");
		 	} catch (MessagingException e) {
		 		 System.out.println("Unable to send mail"+e.getMessage());
		 		throw new RuntimeException(e);
		 	}
	 		 
	 }

}

