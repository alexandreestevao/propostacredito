package br.com.calcard.controller;

import br.com.calcard.persistence.model.PropostaDeCredito;
import br.com.calcard.persistence.service.PropostaDeCreditoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/v1")
public class PropostaDeCreditoController {

    @Autowired
    PropostaDeCreditoService propostaDeCreditoService;

    @ApiOperation(value = "Retorna todas as análise de crédito.")
    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(propostaDeCreditoService.buscaTodos(), HttpStatus.OK);
    }

    @ApiOperation(value="Retorna analise de credito por cpf.")
    @GetMapping(value = "/{cpf}")
    public ResponseEntity<?> findById(@PathVariable String cpf) {
        return new ResponseEntity<>(propostaDeCreditoService.buscarPorCpf(cpf), HttpStatus.OK);
    }

    @ApiOperation(value="Registra analise de crédito no banco de dados.")
    @PostMapping
    public ResponseEntity<?> insert(@Valid @RequestBody PropostaDeCredito propostaDeCredito) {
        propostaDeCredito = this.propostaDeCreditoService.salvar(propostaDeCredito);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cpf}").buildAndExpand(propostaDeCredito.getCpf()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
