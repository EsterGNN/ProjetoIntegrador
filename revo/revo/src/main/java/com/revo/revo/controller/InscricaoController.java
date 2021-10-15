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

import com.revo.revo.model.Inscricao;
import com.revo.revo.repository.InscricaoRepository;

@RestController
@RequestMapping("/inscricao")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class InscricaoController {
	//REPOSITORY
	@Autowired
	private InscricaoRepository repository;
	
	//FIND ALL
	@GetMapping
	public ResponseEntity<List<Inscricao>> findAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	//FIND BY ID
	@GetMapping("/{id}")
	public ResponseEntity<Inscricao> findById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	//POST
	@PostMapping
	public ResponseEntity<Inscricao> postInscricao(@RequestBody Inscricao inscricao){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(inscricao));
	}
		
	//PUT
	@PutMapping
	public ResponseEntity<Inscricao> putInscricao(@RequestBody Inscricao inscricao){
		return ResponseEntity.ok(repository.save(inscricao));
	}
		
	//DELETE
	@DeleteMapping("/{id}")
	public void deleteInscricao(@PathVariable long id) {
		repository.deleteById(id);
	}
	
}
