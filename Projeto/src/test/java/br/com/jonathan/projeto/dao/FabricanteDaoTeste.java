package br.com.jonathan.projeto.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.jonathan.projeto.domain.Fabricante;

public class FabricanteDaoTeste {

	@Test
	@Ignore
	public void salvar() {

		Fabricante fabricante = new Fabricante();
		fabricante.setNome("NIKE TENIS BRASIL");

		FabricanteDao fabricanteDao = new FabricanteDao();
		fabricanteDao.salvar(fabricante);

	}

	@Test
	@Ignore
	public void listar() {

		FabricanteDao fabricanteDao = new FabricanteDao();
		List<Fabricante> resultado = fabricanteDao.listar();

		for (Fabricante fabricante : resultado) {

			System.out.println(fabricante.getNome());

		}
	}
	
	@SuppressWarnings("unused")
	@Test
	@Ignore
	public void buscar() {
		
		Long codigo = 2L;
		
		FabricanteDao fabricanteDao = new FabricanteDao();
		Fabricante resultado = fabricanteDao.buscar(codigo);
	}
	
	@Test
	public void excluir() {
		
		
		Long codigo = 2L;
		
		FabricanteDao fabricanteDao = new FabricanteDao();
		Fabricante fabricante = fabricanteDao.buscar(codigo);
		fabricanteDao.excluir(fabricante);
		
	}

	
}



