package com.javaee.rodrigoandrades.projeto_final.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javaee.rodrigoandrades.projeto_final.domain.Empresa;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Long>{
	
}