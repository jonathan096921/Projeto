package br.com.jonathan.projeto.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.jonathan.projeto.domain.Cidade;
import br.com.jonathan.projeto.domain.Cliente;
import br.com.jonathan.projeto.domain.Pessoa;

public class CliendeDaoTeste {

	@Test
	@Ignore
	public void salvar() throws ParseException {

		PessoaDao pessoaDao = new PessoaDao();

		Pessoa pessoa = pessoaDao.buscar(25L);

		Cliente cliente = new Cliente();
		cliente.setLiberado(false);
		cliente.setPessoa(pessoa);
		cliente.setDataCadastro(new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2015"));

		ClienteDao clienteDao = new ClienteDao();
		clienteDao.salvar(cliente);

		System.out.println("Cliente salvo com sucesso.");

	}

	@Test
	@Ignore
	public void excluir() {

		ClienteDao clienteDao = new ClienteDao();

		Cliente cliente = clienteDao.buscar(27L);

		clienteDao.excluir(cliente);

		System.out.println("Cliente excluido com sucesso");

	}

	@Test
	@Ignore

	public void buscar() {

		Long codigo = 28L;

		ClienteDao clienteDao = new ClienteDao();
		Cliente resultado = clienteDao.buscar(codigo);

		System.out.print(resultado.getPessoa().getNome());

	}

	@Test
	public void listar() {

		CidadeDao cidadeDao = new CidadeDao();
		List<Cidade> resultado = cidadeDao.listar();
		for(Cidade cidade: resultado){
			
			System.out.println(cidade.getNome());
			
		}

	}

}
