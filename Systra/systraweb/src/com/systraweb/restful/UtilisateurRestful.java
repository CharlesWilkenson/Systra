package com.systraweb.restful;

import java.sql.Date;
import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.projetsystra.metier.entities.Role;
import com.projetsystra.metier.entities.TraceEntity;
import com.projetsystra.metier.entities.UserRole;
import com.projetsystra.metier.entities.UtilisateurEntity;
import com.projetsystra.metier.interfaces.ServiceILocal;

@Stateless
@Path("/utilisateur")
public class UtilisateurRestful {

	@EJB
	private ServiceILocal service;

	private String password(){
		Random rd=new Random();	
			String password=String.format("%s%s%s",rd.nextInt(999),rd.nextInt(999),rd.nextInt(999));
			return password;
		}
	@GET
	@Path("addutilisateur")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addfourn(@QueryParam(value="utilisateurEmail")String UtilisateurEmail,
			@QueryParam(value="utilisateurNom")String UtilisateurNom,
			@QueryParam(value="utilisateurPrenom")String UtilisateurPrenom,
			@QueryParam(value="utilisateurSexe")String UtilisateurSexe,
			@QueryParam(value="utilisateurAdresse")String UtilisateurAdresse,
			@QueryParam(value="utilisateurTelephone")String UtilisateurTelephone,
			@QueryParam(value="utilisateurFonction")String UtilisateurFonction,
			@QueryParam(value="utilisateurMotdepasse")String utilisateurMotdepasse,
			@QueryParam(value="utilisateurEtatcompte")String utilisateurEtatcompte)
	{
		UtilisateurEntity u=new UtilisateurEntity(UtilisateurEmail, UtilisateurNom, UtilisateurPrenom, UtilisateurSexe,
				UtilisateurAdresse, UtilisateurTelephone, UtilisateurFonction, password(), "Actif");
	
		 UserRole ur=new UserRole(u, new Role(UtilisateurFonction));
		 service.AddUtilisateur(u,ur);
		String util="success";
		return Response.ok()
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.entity(util)
				.build();
	}
	@GET
	@Path("updateutilisateur")
	@Produces(MediaType.APPLICATION_JSON)
	public void ModifierUtilisateur(UtilisateurEntity u) {
		service.UpdateUtilisateur(u);
	}
	
	@GET
	@Path("findutilisateur/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public UtilisateurEntity findOne(@PathParam(value = "id")String id) {
		return service.FindOneUtilisateur(id);
	}
	
	
	@GET
	@Path("allutilisateur")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUtilisateursList() {
		ClassJsonOutput<UtilisateurEntity> classJsonOutput = new ClassJsonOutput<UtilisateurEntity>();
	    List<UtilisateurEntity> UtilList = service.GetAllUtilisateur();
	    classJsonOutput.setResults(UtilList);
	    return Response
	            .status(200)
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true")
	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	            .header("Access-Control-Max-Age", "1209600")
	            .entity(classJsonOutput)
	            .build();
	}
	
	@GET
	@Path("alltrace")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTrace() {
		ClassJsonOutput<TraceEntity> classJsonOuput = new ClassJsonOutput<TraceEntity>();
		List<TraceEntity> listachat=service.listalltrace();
		classJsonOuput.setResults(listachat);
		return Response.ok()
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.entity(classJsonOuput)
				.build();
	}
	@GET
	@Path("addtrace")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addtrace(@QueryParam(value="traceEmail")String traceEmail,
			@QueryParam(value="traceDate")Long traceDate,
			@QueryParam(value="traceOperation")String traceOperation)
	{
		Date datetrace=new Date(traceDate);
		TraceEntity tr=new TraceEntity(traceEmail, datetrace, traceOperation);
		 service.addTrace(tr);
		String rep="success";
		return Response.ok()
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.entity(rep)
				.build();
	}
	
}
