package com.revo.revo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revo.revo.model.Inscricao;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {

}
