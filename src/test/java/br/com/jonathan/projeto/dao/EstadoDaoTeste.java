package br.com.jonathan.projeto.dao;


import java.util.List;


import org.junit.Ignore;
import org.junit.Test;

import br.com.jonathan.projeto.domain.Estado;

public class EstadoDaoTeste {

	@Test
	@Ignore
	public void salvar() {

		Estado estado = new Estado();
		estado.setNome("PARANA");
		estado.setSigla("PR");

		EstadoDao estadoDao = new EstadoDao();
		estadoDao.salvar(estado);

	}

	@Test
	
	public void listar() {
		
		EstadoDao estadoDao = new EstadoDao();
		List<Estado> resultado = estadoDao.listar();
		
		
	   for(Estado estado : resultado){
		   
		  System.out.print(estado.getNome()+"-"+estado.getSigla());
		   
	   }
	   
	}
		
	   @SuppressWarnings("unused")
	@Test
	@Ignore
	   public void buscar() {
	   	   
	   	  Long codigo = 2L;
	   	  
	   	  EstadoDao estadoDao = new EstadoDao();
	   		Estado resultado = estadoDao.buscar(codigo);
	   	
	   }
	   
	   }


