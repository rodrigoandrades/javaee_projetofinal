package com.javaee.rodrigoandrades.projeto_final.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaee.rodrigoandrades.projeto_final.domain.Acao;
import com.javaee.rodrigoandrades.projeto_final.repositories.AcaoRepository;

@Service
public class AcaoService {
	@Autowired
	private AcaoRepository repository;
	
    public List<Acao> findAll(){
    	return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
    }

	public Acao getById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public Acao save(Acao acao) {
		return repository.save(acao);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}