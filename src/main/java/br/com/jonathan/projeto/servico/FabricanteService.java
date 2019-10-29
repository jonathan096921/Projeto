package br.com.jonathan.projeto.servico;

import java.util.List;


import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.google.gson.Gson;

import br.com.jonathan.projeto.dao.FabricanteDao;
import br.com.jonathan.projeto.domain.Fabricante;


@Path("fabricante")
public class FabricanteService {
	@GET
	public String listar() {
		FabricanteDao fabricanteDao = new FabricanteDao();
	    List<Fabricante> fabricantes = fabricanteDao.listar();
		
		Gson gson  = new Gson();
		String json = gson.toJson(fabricantes);
		
		return json;
	}

}


