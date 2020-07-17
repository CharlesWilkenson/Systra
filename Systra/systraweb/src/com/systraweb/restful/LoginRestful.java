package com.systraweb.restful;

import java.io.IOException;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;

@Stateless
@Path("/user")
public class LoginRestful {
	
	@GET
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@PermitAll
	public String login(@QueryParam(value="utilisateurEmail")String email,
			@QueryParam(value="utilisateurMotdepasse")String password,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response) throws IOException,JSONException {	
		
		String respons=null;
		try{
		
		request.login(email, password);
		request.authenticate(response);
		
		if(request.isUserInRole("ADMIN"))
		{
			respons="ADMIN";
		}
		else if (request.isUserInRole("FOURNISSEUR")) {
			respons="FOURNISSEUR";
		}
		else if (request.isUserInRole("SECRETAIRE")) {
			respons="SECRETAIRE";
		}

		}catch(ServletException e){
		respons="failed";
			System.out.println("Error : "+e.getMessage());
		}
		return respons;
	    }


	@GET
	@Path("/logout")
	@Produces(MediaType.APPLICATION_JSON)
	   public String logout(@Context HttpServletRequest request) {
		String respons=null;
		try {
			request.logout();
		 respons="logout";
			
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return respons;
	     
	    }
}
