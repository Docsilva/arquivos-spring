package com.generation.blogpessoal.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.generation.blogpessoal.model.Usuario;
import com.generation.blogpessoal.model.UsuarioLogin;
import com.generation.blogpessoal.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuariorepository;
	
	
	//Cadastrar Ussuario
	public Optional <Usuario> cadastrarUsuario(Usuario usuario) {
		
		if(usuariorepository.findByUsuario(usuario.getUsuario()).isPresent()) {
			return Optional.empty();
			
		//usuario.setSenha(criptografarSenha(usuario.getSenha()));
		
		}
		
		return Optional.of(usuariorepository.save(usuario));
	}
	
	
	//Atualizar usuario
	public Optional <Usuario> atualizarUsuario(Usuario usuario) {
		
		if(usuariorepository.findByUsuario(usuario.getUsuario()).isPresent()) {
			
		usuario.setSenha(criptografarSenha(usuario.getSenha()));
		
		return Optional.ofNullable(usuariorepository.save(usuario)); //ofNullable - para ter certeza que o optional nao seja nulo
		
		}
		return Optional.empty();
	}
	
	public Optional <UsuarioLogin> autenticarUsuario(Optional<UsuarioLogin> usuarioLogin) {
		
		Optional <Usuario> usuario = usuariorepository.findByUsuario(usuarioLogin.get().getUsuario());
		
		if (usuario.isPresent()) {
			
			if (compararSenhas(usuarioLogin.get().getSenha(), usuario.get().getSenha())) {
				
				usuarioLogin.get().setId(usuario.get().getId());
				usuarioLogin.get().setNome(usuario.get().getNome());
				usuarioLogin.get().setFoto(usuario.get().getFoto());
				usuarioLogin.get().setToken(gerarToken(usuarioLogin.get().getUsuario(),usuarioLogin.get().getSenha()));
				usuarioLogin.get().setSenha(usuario.get().getSenha()); // nao fazer ligacao com a senha, aqui apenas para aprendizado
				
				return usuarioLogin;
			}
			
		}
		
		return Optional.empty();
		
	}

	private String gerarToken(String usuario, String senha) {

		String token = usuario + ":" + senha;
		byte[] tokenBase64 = Base64.encodeBase64(token.getBytes(Charset.forName("ÜS-ASCII")));
		return "Basic " + new String(tokenBase64);
	}


	private boolean compararSenhas(String senhaDigitada, String senhaBanco) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		return encoder.matches(senhaDigitada, senhaBanco);
	}


	private String criptografarSenha(String senha) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(senha);
	}

}
