package com.javaee.rodrigoandrades.projeto_final.controllers.v1;

import java.util.Date;
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

import com.javaee.rodrigoandrades.projeto_final.domain.Acao;
import com.javaee.rodrigoandrades.projeto_final.domain.Cliente;
import com.javaee.rodrigoandrades.projeto_final.domain.Empresa;
import com.javaee.rodrigoandrades.projeto_final.domain.Venda;
import com.javaee.rodrigoandrades.projeto_final.exception.AcaoJaPossuiProprietarioException;
import com.javaee.rodrigoandrades.projeto_final.exception.EmpresaAcaoInvalidaException;
import com.javaee.rodrigoandrades.projeto_final.services.AcaoService;
import com.javaee.rodrigoandrades.projeto_final.services.ClienteService;
import com.javaee.rodrigoandrades.projeto_final.services.EmpresaService;
import com.javaee.rodrigoandrades.projeto_final.services.VendaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/empresa")
@Api(tags="empresa")
public class EmpresaController {
	@Autowired
    private EmpresaService empresaService;
	
	@Autowired
    private AcaoService acaoService;
	
	@Autowired
    private ClienteService clienteService;

	@Autowired
    private VendaService vendaService;
	
	

	@GetMapping
	@ApiOperation(value = "Listar todas as empresas")
    @ResponseStatus(HttpStatus.OK)
    public List<Empresa> findAll(){
		return empresaService.findAll();
    }

	@GetMapping({"/{id}"})
	@ApiOperation(value = "Encontrar empresa por id")
    @ResponseStatus(HttpStatus.OK)
    public Empresa getById(@PathVariable Long id){
        return empresaService.getById(id);
    }

    @PostMapping
    @ApiOperation(value = "Adicionar empresa")
    @ResponseStatus(HttpStatus.CREATED)
    public Empresa create(@RequestBody Empresa empresa){
        return empresaService.save(empresa);
    }
    
    @PutMapping({"/{id}"})
    @ApiOperation(value = "Alterar uma empresa")
    @ResponseStatus(HttpStatus.OK)
    public Empresa update(@PathVariable Long id, @RequestBody Empresa empresa){
    	empresa.setId(id);
    	
    	return empresaService.save(empresa);
    }

    @DeleteMapping({"/{id}"})
    @ApiOperation(value = "Remover uma empresa")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id){
    	empresaService.deleteById(id);
    }
    
    @PostMapping({"/{id}/emitirAcao"})
    @ApiOperation(value = "Emitir uma Ação")
    @ResponseStatus(HttpStatus.CREATED)
    public Empresa emitirAcao(@PathVariable Long id, @RequestParam Double valorInicial, @RequestParam Double valorAtual){
    	Empresa empresa = empresaService.getById(id);
    	
    	empresa.getAcoes().add(new Acao(empresa, valorInicial, valorAtual, new Date(), new Date()));
    	
        return empresaService.save(empresa);
    }
    
    @PostMapping({"/{idEmpresa}/acoes/{idAcao}/vender"})
    @ApiOperation(value = "Vender uma ação")
    @ResponseStatus(HttpStatus.OK)
    public void vender(@PathVariable Long idEmpresa, @PathVariable Long idAcao, @RequestParam Long idCliente, Double valorAtual) throws AcaoJaPossuiProprietarioException, EmpresaAcaoInvalidaException{
    	Acao acao = acaoService.getById(idAcao);
    	
    	if(acao.getCliente() != null){
    		throw new AcaoJaPossuiProprietarioException();
    	}
    	
    	if(acao.getEmpresa().getId() != idEmpresa) {
    		throw new EmpresaAcaoInvalidaException();
    	}
    	
    	Cliente comprador = clienteService.getById(idCliente);
    	
    	
    	Venda venda = new Venda();
    	venda.setAcao(acao);
    	venda.setComprador(comprador);
    	venda.setValor(valorAtual);
    	
    	vendaService.solicitaVenda(venda);
    }
}