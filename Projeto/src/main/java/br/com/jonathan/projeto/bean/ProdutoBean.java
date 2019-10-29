package br.com.jonathan.projeto.bean;

import java.io.Serializable;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.jonathan.projeto.dao.FabricanteDao;
import br.com.jonathan.projeto.dao.ProdutoDao;
import br.com.jonathan.projeto.domain.Fabricante;
import br.com.jonathan.projeto.domain.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable {

	private Produto produto;
	private List<Produto> produtos;
	private List<Fabricante> fabricantes;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	public void novo() {

		try {

			produto = new Produto();

			FabricanteDao fabricanteDao = new FabricanteDao();
			fabricantes = fabricanteDao.listar();
			
		} catch (RuntimeException erro) {

			Messages.addFlashGlobalError("Ocorreu um erro ao gerar um novo produto");

		}
	}

	public void salvar() {

		try {

			ProdutoDao produtoDao = new ProdutoDao();

			produtoDao.merge(produto);

			produto = new Produto();

			FabricanteDao fabricanteDao = new FabricanteDao();

			fabricantes = fabricanteDao.listar();

			produtos = produtoDao.listar();

			Messages.addFlashGlobalInfo("Produto Salvo com sucesso!");

		} catch (RuntimeException erro) {

			Messages.addFlashGlobalError("Ocorreu um erro ao gerar um novo produto");
		}
	}

	@PostConstruct
	public void listar() {

		try {

			ProdutoDao produtoDao = new ProdutoDao();
			produtos = produtoDao.listar();

			Messages.addFlashGlobalInfo("Produto Listado com sucesso!");

		} catch (RuntimeException erro) {

			Messages.addFlashGlobalError("Ocorreu um erro ao Listar os produtos");

		}
	}

	public void excluir(ActionEvent evento) {
		produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");
		try {

			ProdutoDao produtoDao = new ProdutoDao();
			produtoDao.excluir(produto);

			produtos = produtoDao.listar();
			Messages.addFlashGlobalInfo("Produto Excluido com sucesso!");

		} catch (RuntimeException erro) {

			Messages.addFlashGlobalError("Ocorreu um erro ao excluir os produtos");

		}

	}

	public void editar(ActionEvent evento) {

		produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");

		FabricanteDao fabricanteDao = new FabricanteDao();
		fabricantes = fabricanteDao.listar();

	}

}
