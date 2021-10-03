package com.revo.revo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.*;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	// ATRIBUTOS ------------------------------------------------------------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "O atributo nome é obrigatório")
	@Size(min = 5, max = 100, message = "O atributo nome deve conter no mínimo 05 e no máximo 100 caracteres")
	private String nome;
	
	@NotNull(message = "O atributo usuário é obrigatório")
	@NotBlank(message = "O atributo usuário não pode ser vazio")
	@Email(message = "O atributo usuário deve ser um email")
	private String usuario;
	
	@NotNull(message = "O atributo senha é obrigatório")
	@Size(min = 8, message = "O atributo senha deve ter no mínimo 8 caracteres")
	private String senha;
	
	private String foto;
	
	private String tipo;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Postagem> postagem;

	// GETTERS E SETTERS ----------------------------------------------------
	
	// ID
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	// NOME
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	// EMAIL
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	// SENHA
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	// FOTO
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	// TIPO
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	// POSTAGEM
	public List<Postagem> getPostagem() {
		return postagem;
	}
	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}
	
}
