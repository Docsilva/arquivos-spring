package com.generation.lojagame.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.lojagame.model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>  {
	
	public static Optional <Usuario> findByUsuario(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}
}
