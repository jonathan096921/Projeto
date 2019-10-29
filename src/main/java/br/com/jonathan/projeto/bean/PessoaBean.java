package br.com.jonathan.projeto.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.jonathan.projeto.dao.CidadeDao;
import br.com.jonathan.projeto.dao.EstadoDao;
import br.com.jonathan.projeto.dao.PessoaDao;
import br.com.jonathan.projeto.domain.Cidade;
import br.com.jonathan.projeto.domain.Estado;
import br.com.jonathan.projeto.domain.Pessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped

public class PessoaBean implements Serializable {
	private Pessoa pessoa;
	private List<Pessoa> pessoas;

	private Estado estado;
	private List<Estado> estados;

	private List<Cidade> cidades;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public void novo() {

		pessoa = new Pessoa();

		try {
			EstadoDao estadoDao = new EstadoDao();
			estados = estadoDao.listar("nome");

			
			 cidades = new ArrayList<Cidade>();
			
		} catch (RuntimeException erro) {

			Messages.addGlobalError("Ocorreu um erro ao tentar inserir uma nova pessoa");
			erro.printStackTrace();

		}
	}

	public void salvar() {

		try {
			PessoaDao pessoaDao = new PessoaDao();
			pessoaDao.merge(pessoa);

			pessoa = new Pessoa();

			CidadeDao cidadeDao = new CidadeDao();

			pessoas = pessoaDao.listar();
			cidades = cidadeDao.listar();

			pessoaDao.listar();

			Messages.addFlashGlobalInfo("Cidade Salva com sucesso!");

		}

		catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar a pessoa");
			erro.printStackTrace();

		}

	}

	public void excluir(ActionEvent evento) {

		pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionada");

		try {
			PessoaDao pessoaDao = new PessoaDao();
			pessoaDao.excluir(pessoa);

			pessoas = pessoaDao.listar();

			Messages.addFlashGlobalInfo("Cidade Excluida com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir a pessoa");
			erro.printStackTrace();

		}

	}

	@PostConstruct
	public void listar() {

		try {
			PessoaDao pessoaDao = new PessoaDao();
			pessoas = pessoaDao.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar a pessoa");
			erro.printStackTrace();

		}

	}

	public void editar(ActionEvent evento) {

		CidadeDao cidadeDao = new CidadeDao();
		cidades = cidadeDao.listar();

		pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionada");

	}
	
	public void popular() {
		
		
		try {
			
			if(estado != null){
				
				
				CidadeDao cidadeDao = new CidadeDao();
				cidades = cidadeDao.buscaPorEstado(estado.getCodigo());
				
				
			}else 
			{
				
				cidades = new ArrayList<Cidade>();
		
			}
			
			
			
		}
		catch(RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao filtrar as cidades");
			
			
		}
		
	}
}
