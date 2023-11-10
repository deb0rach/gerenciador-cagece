package cagece.gerenciadorapi.controller;

import cagece.gerenciadorapi.model.Substituicao;
import cagece.gerenciadorapi.repository.SubstituicaoRepository;
import cagece.gerenciadorapi.service.SubstituicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/substituicao")
public class SubstituicaoController {

    @Autowired
    private SubstituicaoService service;

    @GetMapping
    public List<Substituicao> listar(){
        return service.listar();
    }

    @PostMapping
    public Substituicao cadastrar(@RequestBody Substituicao substituicao){
        try {
            return service.cadastrar(substituicao);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
}
