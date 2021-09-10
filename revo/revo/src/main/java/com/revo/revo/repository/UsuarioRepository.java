package com.revo.revo.repository;

import java.util.List;
import java.util.Optional;

import com.revo.revo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	//FIND USUARIO
	public Optional<Usuario> findByUsuario(String usuario);
	
	//FIND ALL BY NAME
	public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);
	
	//FIND BY NAME
	public Usuario findByNome(String nome);
}
