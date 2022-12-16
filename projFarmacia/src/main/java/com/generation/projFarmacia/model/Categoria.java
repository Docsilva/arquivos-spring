package com.generation.projFarmacia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SpringBootApplication (exclude = {DataSourceAutoConfiguration.class })
@Entity
@Table(name = "tb_categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message="Nome é obrigatório!")
	private String nome;
	
	@Size(min = 3, max = 100, message = "A descrição deve conter no minimo 3 e no maximo 100 caracteres")
	private String descricao;
	
	@Size(min = 3, max = 15, message = "A descrição deve conter no minimo 3 e no maximo 15 caracteres")
	private String tipo;
	
	@Size(min = 3, max = 3, message = "Preencher com sim ou não")
	@NotBlank (message="Informação obrigatoria")
	private String controlado;
	
	@OneToMany(mappedBy ="categoria", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("categoria")
	private List<Produto>produto;

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	public String getControlado() {
		return controlado;
	}

	public void setControlado(String controlado) {
		this.controlado = controlado;
	}

	
	
}
