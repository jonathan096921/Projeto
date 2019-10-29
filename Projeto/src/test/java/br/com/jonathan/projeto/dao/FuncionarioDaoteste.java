package br.com.jonathan.projeto.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.jonathan.projeto.domain.Funcionario;
import br.com.jonathan.projeto.domain.Pessoa;

public class FuncionarioDaoteste {

	@Test
	@Ignore
	public void salvar() throws ParseException {

		PessoaDao pessoaDao = new PessoaDao();
		Pessoa pessoa = pessoaDao.buscar(25L);

		Funcionario funcionario = new Funcionario();
		funcionario.setCarteiraTrabalho("123456");
		funcionario.setDataAdmicao(new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2015"));
		funcionario.setPessoa(pessoa);

		FuncionarioDao funcionarioDao = new FuncionarioDao();
		funcionarioDao.salvar(funcionario);

	}

	@Test
	@Ignore
	public void excluir() {

		Long codigo = 30L;

		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Funcionario funcionario = funcionarioDao.buscar(codigo);
		funcionarioDao.excluir(funcionario);

		System.out.print("O Funcionario excluido foi" + ' ' + funcionario.getPessoa().getNome());

	}

	@Test
	@Ignore
	public void buscar() {

		Long codigo = 31L;

		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Funcionario resultado = funcionarioDao.buscar(codigo);
		
	    System.out.print("O funcionario é "+' '+resultado.getPessoa().getNome());
			
			
		

	}
	
	@Test
	public void listar() {
		
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		List<Funcionario> resultado = funcionarioDao.listar();
		
		for(Funcionario funcionario : resultado){
			
		System.out.print("Lista de Funcionarios" +funcionario.getPessoa().getNome());
			
		}
		
		
	}
}
