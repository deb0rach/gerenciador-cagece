package cagece.gerenciadorapi.service;

import cagece.gerenciadorapi.model.Grupo;
import cagece.gerenciadorapi.model.Permissao;
import cagece.gerenciadorapi.model.PermissaoGrupo;
import cagece.gerenciadorapi.repository.PermissaoGrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissaoGrupoService {

    @Autowired
    private PermissaoGrupoRepository repository;

    public List<PermissaoGrupo> listar(){
        return repository.findAll();
    }
    public PermissaoGrupo cadastrar(PermissaoGrupo permissaoGrupo){
        return repository.save(permissaoGrupo);
    }

}
