package com.generation.blogpessoal.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.generation.blogpessoal.model.Usuario;
import com.generation.blogpessoal.repository.UsuarioRepository;
import com.generation.blogpessoal.service.UsuarioService;

import java.util.*;


@SpringBootTest (webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance (TestInstance.Lifecycle.PER_CLASS)
public class UsuarioControllerTest {
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start() {
		
		usuarioRepository.deleteAll();
		
		usuarioService.cadastrarUsuario(new Usuario(0L, "Root", "root@root.com", "rootroot", " "));

	}
	
	@Test
	@DisplayName("Cadastrar um usuario")
	public void deveCriarUmUsuario() {
		
		HttpEntity<Usuario> corpoRequisicao = new HttpEntity<Usuario>(new Usuario(0L, "Paulo Antunes", 
				"paulo@gmail.com", "12345678", " "));
		
		ResponseEntity <Usuario> corpoResposta = testRestTemplate
				.exchange("/usuarios/cadastrar", HttpMethod.POST, corpoRequisicao, Usuario.class);
		
		assertEquals(HttpStatus.CREATED, corpoResposta.getStatusCode());
		assertEquals(corpoRequisicao.getBody().getNome(), corpoResposta.getBody().getNome());
		assertEquals(corpoRequisicao.getBody().getUsuario(), corpoResposta.getBody().getUsuario());

	}
	
	@Test
	@DisplayName("Listar todos os usuarios")
	public void deveMostrarTodosUsuarios() {
		
		usuarioService.cadastrarUsuario(new Usuario(0L, "Sabrina", "sabrina@root.com", "rootroot", " "));
		usuarioService.cadastrarUsuario(new Usuario(0L, "Ricardo", "ricardo@root.com", "rootroot", " "));

		
		ResponseEntity<String> resposta = testRestTemplate
				.withBasicAuth("root@root.com", "rootroot")
				.exchange("/usuarios/all", HttpMethod.GET, null, String.class);
		
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
		
	}
	
	
	@Test
	@DisplayName("Atualizar um usuario")
	public void deveAtualizarUmUsuario() {
		
		Optional<Usuario> usuarioCadastrado = usuarioService.cadastrarUsuario(new Usuario(0L, "Juliana Ramos", "juliana_ramos@email.com", "juliana123", " "));
				
		Usuario usuarioUpdate = new Usuario(usuarioCadastrado.get().getId(), "Juliana Ramos", "juliana_ramos@email.com", "juliana123", " ");
		
		HttpEntity<Usuario> corpoRequisicao = new HttpEntity<Usuario> (usuarioUpdate);
		
		ResponseEntity<Usuario> corpoResposta = testRestTemplate
				.withBasicAuth("root@root.com", "rootroot")
				.exchange("/usuarios/atualizar", HttpMethod.PUT, corpoRequisicao, Usuario.class);
		
		assertEquals (HttpStatus.OK, corpoResposta.getStatusCode());
		assertEquals(corpoRequisicao.getBody().getNome(), corpoResposta.getBody().getNome());
		assertEquals(corpoRequisicao.getBody().getUsuario(), corpoResposta.getBody().getUsuario());

	}
	
	@Test
	@DisplayName("Buscar de Usuário ID")
	public void buscarUsuarioId() {
		Optional<Usuario> novoUsuario = usuarioService.cadastrarUsuario(new Usuario(0L, 
				"Antonio", "antonio@email.com.br", "sabrina123", "foto tal ta"));
		ResponseEntity<Usuario> resposta = testRestTemplate.withBasicAuth("root@root.com", "rootroot")
				.exchange("/usuarios/" + novoUsuario.get().getId(), HttpMethod.GET, null, Usuario.class);
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}
	
	@Test
	@DisplayName("Travar duplicacao")
	public void travarDuplicacao() {
		
		usuarioService.cadastrarUsuario(new Usuario(0L, 
				"Bernardo", "bernardo@email.com.br", "ber12345", "link foto"));
		
		HttpEntity<Usuario> corpoRequisicao = new HttpEntity<Usuario> (new Usuario(0L, 
				"Bernardo", "bernardo@email.com.br", "ber12345", "link foto"));
		
		ResponseEntity<Usuario> corpoResposta = testRestTemplate.exchange("/usuarios/cadastrar", HttpMethod.POST, corpoRequisicao, Usuario.class);
		
		assertEquals(HttpStatus.BAD_REQUEST, corpoResposta.getStatusCode());
	}
	
	
	
	

}
