package com.javaee.rodrigoandrades.projeto_final.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javaee.rodrigoandrades.projeto_final.domain.Acao;

@Repository
public interface AcaoRepository extends CrudRepository<Acao, Long>{
	
}