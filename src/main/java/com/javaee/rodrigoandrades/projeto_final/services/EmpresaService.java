package com.javaee.rodrigoandrades.projeto_final.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaee.rodrigoandrades.projeto_final.domain.Empresa;
import com.javaee.rodrigoandrades.projeto_final.repositories.EmpresaRepository;

@Service
public class EmpresaService {
	@Autowired
	private EmpresaRepository repository;
	
    public List<Empresa> findAll(){
    	return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
    }

	public Empresa getById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public Empresa save(Empresa empresa) {
		return repository.save(empresa);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}