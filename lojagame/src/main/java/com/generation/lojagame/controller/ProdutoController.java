package com.generation.lojagame.controller;

import java.util.List;

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

import com.generation.lojagame.model.Produto;
import com.generation.lojagame.repository.ProdutoRepository;
import com.generation.lojagame.repository.CategoriaRepository;


@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {
	
	@Autowired
    private ProdutoRepository ProdutoRepository;

	
		
	@GetMapping
	public ResponseEntity<List<Produto> > getall() {
		return ResponseEntity.ok(ProdutoRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> getById(@PathVariable Long id) {

		return ProdutoRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/console/{titulo}")
	public ResponseEntity<List<Produto> > getByConsole(@PathVariable String console) {
		return ResponseEntity.ok(ProdutoRepository.findByConsoleContainingIgnoreCase(console));
	}
	
	//CRIAR POST
	@PostMapping
	public ResponseEntity<Produto> postProduto(@Valid @RequestBody Produto produto){
		/* if (CategoriaRepository.exists(produto.getCategoria()))
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(ProdutoRepository.save(produto));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); */
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ProdutoRepository.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<Produto> putProduto(@Valid @RequestBody Produto produto){
		if (ProdutoRepository.existsById(produto.getId())) {
			if (ProdutoRepository.existsById(produto.getCategoria().getId()))
				return ResponseEntity.status(HttpStatus.OK)
						.body(ProdutoRepository.save(produto));
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@DeleteMapping ("/{id}")
	public void deleteProduto(@PathVariable Long id) {
		ProdutoRepository.deleteById(id);
	}


}
