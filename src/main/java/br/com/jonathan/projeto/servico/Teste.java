package br.com.jonathan.projeto.servico;

import javax.ws.rs.GET;

import javax.ws.rs.Path;

@Path("drogaria")
public class Teste {
	
	@GET
	public String exibir() {
		
		
		return "Curso Java";
	}

}
