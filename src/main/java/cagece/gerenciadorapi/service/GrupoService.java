package cagece.gerenciadorapi.service;

import cagece.gerenciadorapi.model.Grupo;
import cagece.gerenciadorapi.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository repository;

    public List<Grupo> listar(){
        return repository.findAll();
    }
    public Grupo cadastrar(Grupo grupo){
        return repository.save(grupo);
    }
}
