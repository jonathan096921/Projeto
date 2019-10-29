package br.com.jonathan.projeto.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.jonathan.projeto.domain.Cidade;
import br.com.jonathan.projeto.domain.Estado;

public class CidadeDaoTeste {

	@Test
	
	public void salvar() {

		EstadoDao estadoDao = new EstadoDao();

		Estado estado = estadoDao.buscar(3L);

		Cidade cidade = new Cidade();

		cidade.setNome("LONDRINA");
		cidade.setEstado(estado);

		CidadeDao cidadeDAO = new CidadeDao();
		cidadeDAO.salvar(cidade);

	}

	@Test
	@Ignore
	public void excluir() {

		Long codigo = 4L;

		CidadeDao cidadeDao = new CidadeDao();
		Cidade cidade = cidadeDao.buscar(codigo);
		cidadeDao.excluir(cidade);

	}

	@Test
	@Ignore

	public void buscar() {

		Long codigo = 7L;

		CidadeDao cidadeDao = new CidadeDao();
		Cidade resultado = cidadeDao.buscar(codigo);

		System.out.print(resultado.getNome());

	}

	@Test
	@Ignore
	public void listar() {

		CidadeDao cidadeDao = new CidadeDao();
		List<Cidade> resultado = cidadeDao.listar();

		for (Cidade cidade : resultado) {

			System.out.print(cidade.getNome());

		}

	}

}
