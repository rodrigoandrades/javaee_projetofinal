package com.javaee.rodrigoandrades.projeto_final.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaee.rodrigoandrades.projeto_final.domain.Cliente;
import com.javaee.rodrigoandrades.projeto_final.repositories.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repository;
	
    public List<Cliente> findAll(){
    	return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
    }

	public Cliente getById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public Cliente save(Cliente cliente) {
		return repository.save(cliente);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}