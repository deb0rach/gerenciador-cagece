package cagece.gerenciadorapi.controller;

import cagece.gerenciadorapi.model.Empregado;
import cagece.gerenciadorapi.service.EmpregadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/empregado")
public class EmpregadoController {

    @Autowired
    private EmpregadoService service;

    @GetMapping
    public List<Empregado> listar(){
        return service.listar();
    }

    @PostMapping
    public Empregado cadastrar(@RequestBody Empregado empregado){
        return service.cadastrar(empregado);
    }
}
