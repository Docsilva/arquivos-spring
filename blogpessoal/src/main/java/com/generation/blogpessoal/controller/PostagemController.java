package com.generation.blogpessoal.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.repository.PostagemRepository;



@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {
	
	@Autowired
	private PostagemRepository postagemRepository;
	
	@GetMapping
	public ResponseEntity<List<Postagem> > getall() {
		return ResponseEntity.ok(postagemRepository.findAll());
		/*RETURN É O MESMO QUE USAR =  SELECT * FROM tb_postagens; */
		
	}
	
	
	// VIZUALIZAR TODAS AS POSTAGENS
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> getById(@PathVariable Long id) {

		return postagemRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
		// EQUIVALENTE A BUSCA = SELECT * FROM tb_postagens WHERE id = 1;
	
		
		
//FORME DE BUSCA MAIS VOLUMOSA

	/*	Optional <Postagem> buscaPostagem = postagemRepository.findById(id);
		
		if (buscaPostagem.isPresent())
			return ResponseEntity.ok(buscaPostagem.get());
		else
			return ResponseEntity.notFound().build(); */
	} 
	
	//BUSCAR PALAVRA NO TITULO
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem> > getByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(postagemRepository.findByTituloContainingIgnoreCase(titulo));
	}
	
	//CRIAR POST
	@PostMapping
	public ResponseEntity<Postagem> postPostagem(@Valid @RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem));
 
	}
	
	//ATUALIZAR POST
	@PutMapping
	public ResponseEntity<Postagem> putPostagem(@Valid @RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem));
 
	}
	
	@DeleteMapping ("/{id}")
	public void deletePostagem(@PathVariable Long id) {
		postagemRepository.deleteById(id);
	}
	
	
}
