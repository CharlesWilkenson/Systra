package com.systraweb.restful;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.projetsystra.metier.entities.FournisseurEntity;
import com.projetsystra.metier.interfaces.ServiceILocal;

@Stateless
@Path("/fournisseur")
public class FournisseurRestful {
	@EJB
	private ServiceILocal service;
	
	@GET
	@Path("/addfournisseur")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addfourn(@QueryParam(value="fournisseurId")String fournisseurId,
			@QueryParam(value="fournisseurNom")String fournisseurNom,
			@QueryParam(value="fournisseurPrenom")String fournisseurPrenom,
			@QueryParam(value="fournisseurTelephone")String fournisseurTelephone,
			@QueryParam(value="fournisseurCin_nif")String fournisseurCin_nif,
			@QueryParam(value="fournisseurAdresse")String fournisseurAdresse,
			@QueryParam(value="fournisseurEmail")String fournisseurEmail,
			@QueryParam(value="fournisseurUsine")String fournisseurUsine,
			@QueryParam(value="fournisseurEtat")String fournisseurEtat)
	{
		
		FournisseurEntity fourn=new FournisseurEntity(fournisseurId, fournisseurNom, fournisseurPrenom, fournisseurCin_nif, fournisseurTelephone, fournisseurAdresse, fournisseurEmail, fournisseurUsine, fournisseurEtat);
		service.AddFournisseur(fourn);
		String fou="success";
		return Response.ok()
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.entity(fou)
				.build();
	}
	@PUT
	@Path("updatefournisseur")
	@Produces(MediaType.APPLICATION_JSON)
	public void ModifierFournisseur(FournisseurEntity fou) {
		service.UpdateFournisseur(fou);
	}
	
	@GET
	@Path("findfournisseur/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public FournisseurEntity findOne(@PathParam(value = "id")String id) {
		FournisseurEntity fourn =service.FindOneFournisseur(id);
		return fourn;
	}
	
	@GET
	@Path("/allfournisseur")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFournisseur()
	{
		ClassJsonOutput<FournisseurEntity> classJsonOuput = new ClassJsonOutput<FournisseurEntity>();
		List<FournisseurEntity> listfour=service.GetAllFournisseur();
		classJsonOuput.setResults(listfour);
		return Response.ok()
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.entity(classJsonOuput)
				.build();
		
	}
	
}
