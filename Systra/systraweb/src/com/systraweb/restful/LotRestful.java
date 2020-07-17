package com.systraweb.restful;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.projetsystra.metier.entities.LotsEntity;
import com.projetsystra.metier.interfaces.ServiceILocal;

@Stateless
@Path("/lot")
public class LotRestful {

	@EJB
	private ServiceILocal service;
	
	@GET
	@Path("alllot")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLot() {
		ClassJsonOutput<LotsEntity> classJsonOuput = new ClassJsonOutput<LotsEntity>();
		List<LotsEntity> listlot=service.GetAllLots();
		classJsonOuput.setResults(listlot);
		return Response.ok()
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.entity(classJsonOuput)
				.build();
	}
}
