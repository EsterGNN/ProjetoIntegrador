package com.revo.revo.controller;

import com.revo.revo.repository.TemaRepository;

import java.util.List;

import com.revo.revo.model.Tema;
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

@RestController
@RequestMapping("/tema")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class TemaController {
	//REPOSITORY
	@Autowired
	private TemaRepository repository;
	
	//FIND ALL
	@GetMapping
	public ResponseEntity<List<Tema>> findAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	//FIND BY ID
	@GetMapping("/{id}")
	public ResponseEntity<Tema> findById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	//FIND BY TIPO
	@GetMapping("/tipo/{tipo}")
	public ResponseEntity<List<Tema>> findAllByTipo(@PathVariable String tipo){
		return ResponseEntity.ok(repository
				.findAllByTipoContainingIgnoreCase(tipo));
	}
	
	//FIND BY DESCRICAO
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Tema>> findAllByDescricao(@PathVariable String descricao){
		return ResponseEntity.ok(repository
				.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	//POST
	@PostMapping
	public ResponseEntity<Tema> postTema(@RequestBody Tema tema){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(tema));
	}
	
	//PUT
	@PutMapping
	public ResponseEntity<Tema> putTema(@RequestBody Tema tema){
		return ResponseEntity.ok(repository.save(tema));
	}
	
	//DELETE
	@DeleteMapping("/{id}")
	public void deleteTema(@PathVariable long id) {
		repository.deleteById(id);
	}
}
