package com.generation.lojagame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.generation.lojagame.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
//	public List <Produto> findByTituloContainingIgnoreCase(@Param("Titulo") String titulo);

	public List <Produto> findByConsoleContainingIgnoreCase(@Param("console")String console);
	//public List <Produto> findByPrecoProdutos(@Param("preco")BigDecimal preco);

}
