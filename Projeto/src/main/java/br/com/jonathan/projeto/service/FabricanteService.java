package br.com.jonathan.projeto.service;

import java.util.List;


import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.jonathan.projeto.dao.FabricanteDao;
import br.com.jonathan.projeto.domain.Fabricante;



@Path("fabricantes")
public class FabricanteService  {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar() {

		FabricanteDao fabricanteDAO = new FabricanteDao();
		List<Fabricante> fabricantes = fabricanteDAO.listar("nome");
		
		Gson gson = new Gson();

		return Response.status(200).entity(gson.toJson(fabricantes)).build();

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{codigo}")
	public Response buscar(@PathParam("codigo") Long codigo) {
		FabricanteDao fabricanteDAO = new FabricanteDao();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);

		Gson gson = new Gson();

		return Response.status(200).entity(gson.toJson(fabricante)).build();

	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvar(String json) {

		Gson gson = new Gson();
		
	    Fabricante fabricante = gson.fromJson(json, Fabricante.class);

		FabricanteDao fabricanteDAO = new FabricanteDao();
		fabricanteDAO.merge(fabricante);

		return Response.status(200).entity(gson.toJson(fabricante)).build();
		


	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)

	public Response editar(String json) {

		Gson gson = new Gson();

		Fabricante fabricante = gson.fromJson(json, Fabricante.class);
		FabricanteDao fabricanteDAO = new FabricanteDao();
		fabricanteDAO.editar(fabricante);

		return Response.status(200).entity(gson.toJson(fabricante)).build();

	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)

	public Response excluir(String json) {

		Gson gson = new Gson();

		Fabricante fabricante = gson.fromJson(json, Fabricante.class);

		FabricanteDao fabricanteDAO = new FabricanteDao();

		fabricante = fabricanteDAO.buscar(fabricante.getCodigo());
		fabricanteDAO.excluir(fabricante);

		return Response.status(200).entity(gson.toJson(fabricante)).build();

	}
}
