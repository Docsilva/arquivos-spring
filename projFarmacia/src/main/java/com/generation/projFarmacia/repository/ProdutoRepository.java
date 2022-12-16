package com.generation.projFarmacia.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.projFarmacia.model.Produto;



public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	public List <Produto> findByNomeContainingIgnoreCase(@Param("nome") String nome);
	 
	public List <Produto> findByNomeFabricante(String nome, String fabricante);
		
	public List<Produto> findByPrecoIn(List<BigDecimal> preco);


}
