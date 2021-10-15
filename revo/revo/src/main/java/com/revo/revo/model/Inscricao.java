package com.revo.revo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_inscricao")
public class Inscricao {
	//ATRIBUTOS ------------------------------------------------------------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JsonIgnoreProperties("inscricao")
	private Usuario usuario;
	
	@ManyToOne
	@JsonIgnoreProperties("inscricao")
	private Postagem postagem;

	// GETTERS E SETTERS ----------------------------------------------------
	
	// ID
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	// USUARIO
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	//POSTAGEM
	public Postagem getPostagem() {
		return postagem;
	}
	public void setPostagem(Postagem postagem) {
		this.postagem = postagem;
	}
	
}
