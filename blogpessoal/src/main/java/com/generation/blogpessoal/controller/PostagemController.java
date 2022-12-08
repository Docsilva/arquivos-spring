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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.model.Usuario;
import com.generation.blogpessoal.repository.TemaRepository;
import com.generation.blogpessoal.repository.PostagemRepository;



@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {
	
	@Autowired
	private PostagemRepository postagemRepository;
	//private PostagemRepository postagemRepository;
	
	@Autowired
	private TemaRepository temaRepository;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getall() {
		return ResponseEntity.ok(postagemRepository.findAll());
		/*RETURN É O MESMO QUE USAR =  SELECT * FROM tb_postagens; */
		
	}
	
	
	// VIZUALIZAR TODAS AS POSTAGENS
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable Long id) {

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
	public ResponseEntity<Optional<Postagem>> getByPostagem(@PathVariable String postagem) {
		return ResponseEntity.ok(postagemRepository.findByPostagem(postagem));
	}
	
	//CRIAR POST
	@PostMapping
	public ResponseEntity<Postagem> postPostagem(@Valid @RequestBody Postagem postagem){
		if (temaRepository.existsById(postagem.getTema().getId()))
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(postagemRepository.save(postagem));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

 
	}
	
	//ATUALIZAR POST
	@PutMapping
	public ResponseEntity<Postagem> putPostagem(@Valid @RequestBody Postagem postagem){
		if (postagemRepository.existsById(postagem.getId())) {
			if (postagemRepository.existsById(postagem.getTema().getId()))
				return ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem));			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
	/*	return postagemRepository.findById(postagem.getId())
		.map(resposta -> ResponseEntity.ok()
								.body(postagemRepository.save(postagem)))
		.orElse(ResponseEntity.notFound().build()); */
	}
	
	///DELETA POSTAGEM
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Postagem> postagem = postagemRepository.findByPostagem(null);
		
		if(postagem.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		postagemRepository.deleteById(id);				
	}
	
	
	
}
