package com.javaee.rodrigoandrades.projeto_final.controllers.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javaee.rodrigoandrades.projeto_final.domain.Cliente;
import com.javaee.rodrigoandrades.projeto_final.services.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/cliente")
@Api(tags="cliente")
public class ClienteController {
	@Autowired
    private ClienteService clienteService;

	@GetMapping
	@ApiOperation(value = "Listar todos os clientes")
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> findAll(){
		return clienteService.findAll();
    }

	@GetMapping({"/{id}"})
	@ApiOperation(value = "Encontrar cliente por id")
    @ResponseStatus(HttpStatus.OK)
    public Cliente getById(@PathVariable Long id){
        return clienteService.getById(id);
    }

    @PostMapping
    @ApiOperation(value = "Adicionar cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }
    
    @PutMapping({"/{id}"})
    @ApiOperation(value = "Alterar uma cliente")
    @ResponseStatus(HttpStatus.OK)
    public Cliente update(@PathVariable Long id, @RequestBody Cliente cliente){
    	cliente.setId(id);
    	
    	return clienteService.save(cliente);
    }

    @DeleteMapping({"/{id}"})
    @ApiOperation(value = "Remover uma cliente")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id){
    	clienteService.deleteById(id);
    }
    
    @PostMapping({"/{id}/comprarAcao"})
    @ApiOperation(value = "Efetuar compra de ação")
    @ResponseStatus(HttpStatus.OK)
    public void comprar(@PathVariable Long id, @RequestParam Long idClienteVenda){
    	
    }
}