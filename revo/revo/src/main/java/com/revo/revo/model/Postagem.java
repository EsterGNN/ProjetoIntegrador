package com.revo.revo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_postagem")
public class Postagem {
	//ATRIBUTOS ------------------------------------------------------------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@Size(min = 5, max = 100)
	private String titulo;
	
	@NotBlank
	@Size(max = 500)
	private String conteudo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());
	
	private String foto;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	@OneToMany(mappedBy = "postagem", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("postagem")
	private List<Inscricao> inscricao;

	//GETTERS E SETTERS ----------------------------------------------------
	
	//ID
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	//TITULO
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	//CONTEUDO
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	//DATA
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	//FOTO
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}

	//USUARIO
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	//TEMA
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	//INSCRICAO
	public List<Inscricao> getInscricao() {
		return inscricao;
	}
	public void setInscricao(List<Inscricao> inscricao) {
		this.inscricao = inscricao;
	}
	
}
