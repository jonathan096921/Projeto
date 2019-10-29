package br.com.jonathan.projeto.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@SuppressWarnings("serial")
@Entity
public class Produto extends GenericDomain{

	
	
	@Column(length = 50,nullable = false)
	private String nome;
	
    @Column(nullable = false)
	private Short quantidade;

    @Column(nullable = false, precision = 6 , scale = 2)
    BigDecimal preco;
	
    @ManyToOne
    @JoinColumn(nullable = false)
	private Fabricante fabricante;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Short getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Short quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
	
	
}
