package br.com.jonathan.projeto.bean;

import java.io.Serializable;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.jonathan.projeto.dao.CidadeDao;
import br.com.jonathan.projeto.dao.EstadoDao;
import br.com.jonathan.projeto.domain.Cidade;
import br.com.jonathan.projeto.domain.Estado;

@SuppressWarnings("serial")

@ManagedBean
@ViewScoped

public class CidadeBean implements Serializable {

	private Cidade cidade;
	private List<Cidade> cidades;
	private List<Estado> estados;

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public void novo() {

		try {
			cidade = new Cidade();

			EstadoDao estadoDao = new EstadoDao();
			estados = estadoDao.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao gerar uma nova cidade");
			erro.printStackTrace();
		}
	}

	public void salvar() {

		try {

			CidadeDao cidadeDao = new CidadeDao();
			cidadeDao.merge(cidade);

			cidade = new Cidade();

			EstadoDao estadoDao = new EstadoDao();
			estados = estadoDao.listar();
			cidades = cidadeDao.listar();

			Messages.addFlashGlobalInfo("Cidade Salva com sucesso!");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar a cidade");
			erro.printStackTrace();

		}

	}

	@PostConstruct
	public void listar() {

		try {

			CidadeDao cidadeDao = new CidadeDao();
			cidades = cidadeDao.listar();

			Messages.addFlashGlobalInfo("Cidade Listada com sucesso!");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu ao listar as Cidades");
			erro.printStackTrace();

		}

	}

	public void excluir(ActionEvent evento) {

		cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionada");

		try {
			CidadeDao cidadeDao = new CidadeDao();
			cidadeDao.excluir(cidade);
			cidades = cidadeDao.listar();
			Messages.addFlashGlobalInfo("Cidade Excluida com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu ao Excluir as Cidades");
			erro.printStackTrace();

		}

	}

	public void editar(ActionEvent evento) {

		EstadoDao estadoDao = new EstadoDao();
		estados = estadoDao.listar();

		cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionada");
		Messages.addFlashGlobalInfo("Cidade Editada com sucesso!");
	}
}
