package com.systraweb.restful;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.projetsystra.metier.entities.Commune;
import com.projetsystra.metier.entities.ParcelleEntity;
import com.projetsystra.metier.entities.ProducteurEntity;
import com.projetsystra.metier.entities.RegionEntity;
import com.projetsystra.metier.entities.Section_communal;
import com.projetsystra.metier.interfaces.ServiceILocal;

@Stateless
@Path("/parcelle")
public class ParcelleRestful {

	@EJB
	 private ServiceILocal service;
	
	
	
	
	@GET
	@Path("/addparcellefor")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addparcellefor(@QueryParam(value="producteurId")String producteurId,
			@QueryParam(value="parcelleId")String parcelleId,
			@QueryParam(value="parcelleCommune")String parcelleCommune,
			@QueryParam(value="parcelleSectioncommunale")String parcelleSectioncommunale,
			@QueryParam(value="parcelleLocalite")String parcelleLocalite,
			@QueryParam(value="parcelleMarndr")String parcelleMarndr,
			@QueryParam(value="parcelleRegimeFoncier")String parcelleRegimeFoncier,
			@QueryParam(value="parcelleTypeCulture")String parcelleTypeCulture,
			@QueryParam(value="parcelleFertilisationChimique")String parcelleFertilisationChimique,
			@QueryParam(value="parcelleFertilisationOrganique")String parcelleFertilisationOrganique,
			@QueryParam(value="parcellePresenceElevage")String parcellePresenceElevage,
			@QueryParam(value="parcelleTypeElevage")String parcelleTypeElevage,
			@QueryParam(value="parcellePresenceLatrine")String parcellePresenceLatrine,
			@QueryParam(value="parcelleTypeTraitrementPhytosanitaire")String parcelleTypeTraitrementPhytosanitaire,
			@QueryParam(value="parcelleProblemeInondation")String parcelleProblemeInondation,
			@QueryParam(value="parcelleFrequenceInondation")String parcelleFrequenceInondation,
			@QueryParam(value="parcellePlanteHote")String parcellePlanteHote,
			@QueryParam(value="parcelleParcIrrigue")String parcelleParcIrrigue,
			@QueryParam(value="parcelleTypeEau")String parcelleTypeEau,
			@QueryParam(value="parcelleCommercialisation")String parcelleCommercialisation,
			@QueryParam(value="parcelleNbreManguierEnProduction")int parcelleNbreManguierEnProduction,
			@QueryParam(value="parcelleProductionAnnuelleMangue")int parcelleProductionAnnuelleMangue,
			@QueryParam(value="parcelleAgePlantation")int parcelleAgePlantation,
			@QueryParam(value="achatQtTotal")int achatQtTotal,
			@QueryParam(value="parcelleNbreManguier")int parcelleNbreManguier,
			@QueryParam(value="parcellePointLatitudeLatrine")Double parcellePointLatitudeLatrine,
			@QueryParam(value="parcellePointLongitudeLatrine")Double parcellePointLongitudeLatrine,
			@QueryParam(value="parcellePointLatitude1")Double parcellePointLatitude1,
			@QueryParam(value="parcellePointLongitude1")Double parcellePointLongitude1,
			@QueryParam(value="parcellePointLatitude2")Double parcellePointLatitude2,
			@QueryParam(value="parcellePointLongitude2")Double parcellePointLongitude2,
			@QueryParam(value="parcellePointLatitude3")Double parcellePointLatitude3,
			@QueryParam(value="parcellePointLongitude3")Double parcellePointLongitude3,
			@QueryParam(value="parcellePointLatitude4")Double parcellePointLatitude4,
			@QueryParam(value="parcellePointLongitude4")Double parcellePointLongitude4,
			@QueryParam(value="parcelleSuperficie")Double parcelleSuperficie,
			@QueryParam(value="parcelleEtat")String parcelleEtat)
			
	{
		String rep="";
		
		ParcelleEntity par=new ParcelleEntity(parcelleId, new ProducteurEntity(producteurId), parcelleCommune ,
		       parcelleSectioncommunale , parcelleLocalite, parcelleMarndr,
				 parcelleRegimeFoncier, parcelleTypeCulture, parcelleFertilisationChimique, parcelleFertilisationOrganique, parcellePresenceElevage,
				 parcelleTypeElevage, parcellePresenceLatrine, parcellePointLatitudeLatrine, parcellePointLongitudeLatrine, parcelleTypeTraitrementPhytosanitaire,
				 parcelleProblemeInondation, parcelleFrequenceInondation, parcellePlanteHote, parcelleAgePlantation, parcelleNbreManguier,
				 parcelleNbreManguierEnProduction, parcelleProductionAnnuelleMangue, parcelleParcIrrigue, parcelleTypeEau, 
				 parcelleCommercialisation, parcellePointLatitude1, parcellePointLongitude1, parcellePointLatitude2, parcellePointLongitude2, 
				 parcellePointLatitude3, parcellePointLongitude3, parcellePointLatitude4, parcellePointLongitude4, parcelleSuperficie, parcelleEtat);
		
		service.AddParcelle(par);
		rep="success";
		return Response.ok()
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.entity(rep)
				.build();
	}
	
	
	@GET
	@Path("/findparcelle/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ParcelleEntity findOne(@PathParam(value = "id")String id) {
		return service.FindOneParcelle(id);
	}
	
	@GET
	@Path("/updateparcelle")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateparcelle(@QueryParam(value="producteurId")String producteurId,
			@QueryParam(value="parcelleId")String parcelleId,
			@QueryParam(value="parcelleCommune")String parcelleCommune,
			@QueryParam(value="parcelleSectioncommunale")String parcelleSectioncommunale,
			@QueryParam(value="parcelleLocalite")String parcelleLocalite,
			@QueryParam(value="parcelleMarndr")String parcelleMarndr,
			@QueryParam(value="parcelleRegimeFoncier")String parcelleRegimeFoncier,
			@QueryParam(value="parcelleTypeCulture")String parcelleTypeCulture,
			@QueryParam(value="parcelleFertilisationChimique")String parcelleFertilisationChimique,
			@QueryParam(value="parcelleFertilisationOrganique")String parcelleFertilisationOrganique,
			@QueryParam(value="parcellePresenceElevage")String parcellePresenceElevage,
			@QueryParam(value="parcelleTypeElevage")String parcelleTypeElevage,
			@QueryParam(value="parcellePresenceLatrine")String parcellePresenceLatrine,
			@QueryParam(value="parcelleTypeTraitrementPhytosanitaire")String parcelleTypeTraitrementPhytosanitaire,
			@QueryParam(value="parcelleProblemeInondation")String parcelleProblemeInondation,
			@QueryParam(value="parcelleFrequenceInondation")String parcelleFrequenceInondation,
			@QueryParam(value="parcellePlanteHote")String parcellePlanteHote,
			@QueryParam(value="parcelleParcIrrigue")String parcelleParcIrrigue,
			@QueryParam(value="parcelleTypeEau")String parcelleTypeEau,
			@QueryParam(value="parcelleCommercialisation")String parcelleCommercialisation,
			@QueryParam(value="parcelleNbreManguierEnProduction")int parcelleNbreManguierEnProduction,
			@QueryParam(value="parcelleProductionAnnuelleMangue")int parcelleProductionAnnuelleMangue,
			@QueryParam(value="parcelleAgePlantation")int parcelleAgePlantation,
			@QueryParam(value="achatQtTotal")int achatQtTotal,
			@QueryParam(value="parcelleNbreManguier")int parcelleNbreManguier,
			@QueryParam(value="parcellePointLatitudeLatrine")Double parcellePointLatitudeLatrine,
			@QueryParam(value="parcellePointLongitudeLatrine")Double parcellePointLongitudeLatrine,
			@QueryParam(value="parcellePointLatitude1")Double parcellePointLatitude1,
			@QueryParam(value="parcellePointLongitude1")Double parcellePointLongitude1,
			@QueryParam(value="parcellePointLatitude2")Double parcellePointLatitude2,
			@QueryParam(value="parcellePointLongitude2")Double parcellePointLongitude2,
			@QueryParam(value="parcellePointLatitude3")Double parcellePointLatitude3,
			@QueryParam(value="parcellePointLongitude3")Double parcellePointLongitude3,
			@QueryParam(value="parcellePointLatitude4")Double parcellePointLatitude4,
			@QueryParam(value="parcellePointLongitude4")Double parcellePointLongitude4,
			@QueryParam(value="parcelleSuperficie")Double parcelleSuperficie,
			@QueryParam(value="parcelleEtat")String parcelleEtat)
			
	{
		String rep="";
		
		ParcelleEntity par=new ParcelleEntity(parcelleId, new ProducteurEntity(producteurId),parcelleCommune,
		       parcelleSectioncommunale , parcelleLocalite, parcelleMarndr,
				 parcelleRegimeFoncier, parcelleTypeCulture, parcelleFertilisationChimique, parcelleFertilisationOrganique, parcellePresenceElevage,
				 parcelleTypeElevage, parcellePresenceLatrine, parcellePointLatitudeLatrine, parcellePointLongitudeLatrine, parcelleTypeTraitrementPhytosanitaire,
				 parcelleProblemeInondation, parcelleFrequenceInondation, parcellePlanteHote, parcelleAgePlantation, parcelleNbreManguier,
				 parcelleNbreManguierEnProduction, parcelleProductionAnnuelleMangue, parcelleParcIrrigue, parcelleTypeEau, 
				 parcelleCommercialisation, parcellePointLatitude1, parcellePointLongitude1, parcellePointLatitude2, parcellePointLongitude2, 
				 parcellePointLatitude3, parcellePointLongitude3, parcellePointLatitude4, parcellePointLongitude4, parcelleSuperficie, parcelleEtat);
		
		service.UpdateParcelle(par);
		rep="success";
		return Response.ok()
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.entity(rep)
				.build();
	}
	
	@GET
	@Path("allparcelle")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getParcelle() {
		ClassJsonOutput<ParcelleEntity> classJsonOuput = new ClassJsonOutput<ParcelleEntity>();
		List<ParcelleEntity> listparc=service.GetAllParcelle();
		classJsonOuput.setResults(listparc);
		return Response.ok()
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.entity(classJsonOuput)
				.build();
	}
	
	@GET
	@Path("allregion")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRegion() {
		ClassJsonOutput<RegionEntity> classJsonOuput = new ClassJsonOutput<RegionEntity>();
		List<RegionEntity> listreg=service.GetAllRegion();
		classJsonOuput.setResults(listreg);
		return Response.ok()
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.entity(classJsonOuput)
				.build();
	}
	@GET
	@Path("/parcellebyprod")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getParcellebyprod(@QueryParam(value = "producteurId")String producteurId) {
		ClassJsonOutput<ParcelleEntity> classJsonOuput = new ClassJsonOutput<ParcelleEntity>();
		List<ParcelleEntity> listparc=service.GetAllParcellebyprod(producteurId);
		classJsonOuput.setResults(listparc);
		return Response.ok()
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.entity(classJsonOuput)
				.build();
	}
	
}
