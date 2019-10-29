package br.com.jonathan.projeto.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.jonathan.projeto.dao.FabricanteDao;
import br.com.jonathan.projeto.domain.Fabricante;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FabricanteBean implements Serializable {

	private Fabricante fabricante;
	private List<Fabricante> fabricantes;

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	public void novo() {

		fabricante = new Fabricante();

	}

	public void salvar() {

		try {
			FabricanteDao fabricanteDao = new FabricanteDao();
			fabricanteDao.merge(fabricante);
			
			fabricante = new Fabricante();
			
			fabricantes = fabricanteDao.listar();

			Messages.addFlashGlobalInfo("Fabricante Salvo com sucesso!");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o Fabricante");
			erro.printStackTrace();

		}

	}

	@PostConstruct
	public void listar() {

		try {

			FabricanteDao fabricanteDao = new FabricanteDao();
			fabricantes = fabricanteDao.listar();

			Messages.addFlashGlobalInfo("Fabricante Listados com sucesso!");
		}

		catch (RuntimeException erro) {

			Messages.addGlobalError("Ocorreu um erro ao tentar listar o Fabricante");

		}

	}

	public void excluir(ActionEvent evento) {

		fabricante = (Fabricante) evento.getComponent().getAttributes().get("fabricanteSelecionado");

		try {

			FabricanteDao fabricanteDao = new FabricanteDao();
			fabricanteDao.excluir(fabricante);
			fabricantes = fabricanteDao.listar();

			Messages.addFlashGlobalInfo("Fabricante Excluido com sucesso!");

		} catch (RuntimeException erro) {

			Messages.addGlobalError("Ocorreu um erro ao tentar excluir o Fabricante");
		}
	}

	public void editar(ActionEvent evento) {
		fabricante = (Fabricante) evento.getComponent().getAttributes().get("fabricanteSelecionado");

	}
}
