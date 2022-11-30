package com.generation.lojagame.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.generation.lojagame.repository.CategoriaRepository;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_game")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull 
	private Long id;
	
	@NotBlank(message = "O Nome é obrigatório")
	@Size(min = 3, max = 100, message = "O nome deve conter no minimo 3 e no maximo 50 caracteres")
	private String nome;
	
	@Size(max = 255, message = "A descrição deve conter no maximo 255 caracteres")
	private String descricao;
	
	@NotBlank(message = "O Console é obrigatório")
	@Size(max = 25, message = "A descrição deve conter no maximo 25 caracteres")
	private String console;
	
	@NotBlank(message = "O Valor é obrigatório")
	private BigDecimal preco;
	
	@NotNull (message = "Campo quantidade deve ser preenchido")
	private Long quantidade;

	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getConsole() {
		return console;
	}


	public void setConsole(String console) {
		this.console = console;
	}


	public BigDecimal getPreco() {
		return preco;
	}


	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}


	public Long getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}
