package com.revo.revo.repository;

import com.revo.revo.model.Tema;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {
	public List<Tema> findAllByTipoContainingIgnoreCase(String descricao);
	public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);
}
