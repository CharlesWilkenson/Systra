package com.systraweb.restful;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.projetsystra.metier.entities.ExportationEntity;
import com.projetsystra.metier.interfaces.ServiceILocal;

@Stateless
@Path("/exportation")
public class ExportationRestful {
	@EJB
	private ServiceILocal service;

	@GET
	@Path("allexpo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getExpo() {
		ClassJsonOutput<ExportationEntity> classJsonOuput = new ClassJsonOutput<ExportationEntity>();
		List<ExportationEntity> listexpo=service.GetAllExportation();
		classJsonOuput.setResults(listexpo);
		return Response.ok()
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.entity(classJsonOuput)
				.build();
	}
}
