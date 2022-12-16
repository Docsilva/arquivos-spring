package com.generation.projFarmacia.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.projFarmacia.model.Categoria;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	public List <Categoria> findAllByNomeContainingIgnoreCase(@Param("tipo") String nome);

	public List <Categoria> findAllByIDContainingIgnoreCase(@Param("tipo") BigDecimal id);

}
