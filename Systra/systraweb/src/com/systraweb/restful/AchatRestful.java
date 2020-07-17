package com.systraweb.restful;

import java.sql.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.projetsystra.metier.entities.AchatsEntity;
import com.projetsystra.metier.entities.FournisseurEntity;
import com.projetsystra.metier.entities.ParcelleEntity;
import com.projetsystra.metier.entities.ProducteurEntity;
import com.projetsystra.metier.entities.RegionEntity;
import com.projetsystra.metier.entities.TraceEntity;
import com.projetsystra.metier.interfaces.ServiceILocal;

@Stateless
@Path("/achat")
public class AchatRestful {
	
	@EJB
	private ServiceILocal service;
	@GET
	@Path("allachats")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAchat() {
		ClassJsonOutput<AchatsEntity> classJsonOuput = new ClassJsonOutput<AchatsEntity>();
		List<AchatsEntity> listachat=service.GetAllachats();
		classJsonOuput.setResults(listachat);
		return Response.ok()
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.entity(classJsonOuput)
				.build();
	}
	
	
	
	@GET
	@Path("/addachat")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addachat(@QueryParam(value="achatId")String achatId,
			@QueryParam(value="achatQtTotal")int achatQtTotal,
			@QueryParam(value="achatPrix")Double achatPrix,
			@QueryParam(value="achatDate")Long achatDate,
			@QueryParam(value="achatEtat")String achatEtat,
			@QueryParam(value="fournisseur")String fournisseur,
			@QueryParam(value="region")String region,
			@QueryParam(value="producteur")String producteur,
			@QueryParam(value="parcelle")String parcelle)
			
	{
		Date achdate=new Date(achatDate);
		String rep="";
		AchatsEntity achs = new AchatsEntity(achatId, achatQtTotal, achatPrix, achdate, achatEtat,new FournisseurEntity(fournisseur), new RegionEntity(region), new ProducteurEntity(producteur), new ParcelleEntity(parcelle));
		service.Addachats(achs);
		rep="success";
		return Response.ok()
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.entity(rep)
				.build();
	}
	@GET
	@Path("/achatbylot")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAchatlot(@QueryParam(value = "lotId")String lotId) {
		ClassJsonOutput<AchatsEntity> classJsonOuput = new ClassJsonOutput<AchatsEntity>();
		List<AchatsEntity> listparc=service.GetAllachatsbylot(lotId);
		classJsonOuput.setResults(listparc);
		return Response.ok()
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.entity(classJsonOuput)
				.build();
	}
	
}
