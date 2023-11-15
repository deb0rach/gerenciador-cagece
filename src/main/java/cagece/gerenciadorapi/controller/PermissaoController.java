package cagece.gerenciadorapi.controller;

import cagece.gerenciadorapi.model.Permissao;
import cagece.gerenciadorapi.service.PermissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/permissao")
@CrossOrigin(origins = "http://localhost:3000")
public class PermissaoController {

    @Autowired
    private PermissaoService service;

    @GetMapping
    public List<Permissao> listar(){
        return service.listar();
    }

    @GetMapping("/verificar")
    public boolean verificar(@RequestParam Long empregadoId, @RequestParam Long permissaoId){
        try {
            return service.verificar(empregadoId, permissaoId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
}