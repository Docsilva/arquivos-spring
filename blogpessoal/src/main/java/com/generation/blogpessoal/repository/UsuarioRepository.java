package com.generation.blogpessoal.repository;

import java.util.Optional;

import com.generation.blogpessoal.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
public static Optional <Usuario> findByUsuario(String usuario) {
	// TODO Auto-generated method stub
	return null;
}

public static Object findByTituloContainingIgnoreCase(String usuario) {
	// TODO Auto-generated method stub
	return null;
}

}
