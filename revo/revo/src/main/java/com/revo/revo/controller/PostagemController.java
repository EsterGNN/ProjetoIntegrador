package com.revo.revo.controller;

import java.util.List;

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

import com.revo.revo.model.Postagem;
import com.revo.revo.repository.PostagemRepository;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class PostagemController {
	//REPOSITORY
	@Autowired
	private PostagemRepository repository;
	
	//FIND ALL
	@GetMapping
	public ResponseEntity<List<Postagem>> findAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	//FIND BY ID
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> findById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	//FIND BY TITULO
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> findAllByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository
				.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	//FIND BY CONTEUDO
	@GetMapping("/conteudo/{conteudo}")
	public ResponseEntity<List<Postagem>> findAllByConteudo(@PathVariable String conteudo){
		return ResponseEntity.ok(repository
				.findAllByConteudoContainingIgnoreCase(conteudo));
	}
	
	//POST
	@PostMapping
	public ResponseEntity<Postagem> postPostagem(@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(postagem));
	}
	
	//PUT
	@PutMapping
	public ResponseEntity<Postagem> putPostagem(@RequestBody Postagem postagem){
		return ResponseEntity.ok(repository.save(postagem));
	}
	
	//DELETE
	@DeleteMapping("/{id}")
	public void deletePostagem(@PathVariable long id) {
		repository.deleteById(id);
	}
}
