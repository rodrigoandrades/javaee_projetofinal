package com.javaee.rodrigoandrades.projeto_final.controllers.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaee.rodrigoandrades.projeto_final.services.EmpresaService;

@RestController
@RequestMapping("/api/v1/empresa")
public class EmpresaController {
	@Autowired
    private EmpresaService empresaService;

	/*
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Set<Acao> getAll(){
        return garageService.getAll();
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Acao getById(@PathVariable String id){
        return garageService.getGarageById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Acao create(@RequestBody Acao garage){
        return garageService.createNewGarage(garage);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Acao updateGarage(@PathVariable String id, @RequestBody Acao garage){
        return garageService.saveGarage(id, garage);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteGarage(@PathVariable String id){
    	garageService.deleteGarageById(id);
    }
    */
}