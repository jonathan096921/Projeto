package br.com.jonathan.projeto.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

// http://localhost:8080/Drogaria/rest/drogaria
@Path("drogaria")
public class ProjetoService {
	@GET
	public String exibir(){
		return "Curso de Java";
	}
}