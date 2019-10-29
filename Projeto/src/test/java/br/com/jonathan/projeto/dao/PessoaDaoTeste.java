package br.com.jonathan.projeto.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.jonathan.projeto.domain.Cidade;
import br.com.jonathan.projeto.domain.Cliente;
import br.com.jonathan.projeto.domain.Pessoa;

public class PessoaDaoTeste {

	@Test
	@Ignore
	public void salvar() {

		CidadeDao cidadeDao = new CidadeDao();
		Cidade cidade = cidadeDao.buscar(20L);

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("JONATHAN");
		pessoa.setBairro("SANTA TEREZINHA");
		pessoa.setTelefone("4333561034");
		pessoa.setCelular("43999590619");
		pessoa.setCidade(cidade);
		pessoa.setComplemento("CLIENTE OTIMO");
		pessoa.setCpf("09692184943");
		pessoa.setEmail("jonathansoares323@gmail.com");
		pessoa.setNumero((short) 768);
		pessoa.setRg("10358848");
		pessoa.setRua("RUA SANTA MARIA 77");
		pessoa.setCep("86027640");

		PessoaDao pessoaDao = new PessoaDao();
		pessoaDao.salvar(pessoa);

	}

	@Test
	@Ignore
	public void excluir() {

		Long codigo = 28L;

		ClienteDao clienteDao = new ClienteDao();

		Cliente cliente = clienteDao.buscar(codigo);

		clienteDao.excluir(cliente);

		System.out.println("CLIENTE" + ' ' + cliente.getPessoa().getNome() + ' ' + "EXCLUIDO COM SUCESSO");

	}

	@Test
	public void listar() {

		PessoaDao pessoaDao = new PessoaDao();
		List<Pessoa> resultado = pessoaDao.listar();
		for (Pessoa pessoa : resultado) {

			System.out.print(pessoa.getNome());

		}

	}

}
