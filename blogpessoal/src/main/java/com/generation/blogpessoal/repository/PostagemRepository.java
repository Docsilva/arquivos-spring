package com.generation.blogpessoal.repository;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.model.Usuario;

@Repository
public interface PostagemRepository extends JpaRepository<Usuario, Long>{

	public Optional<Postagem> findByPostagem(String usuario);
	
}
