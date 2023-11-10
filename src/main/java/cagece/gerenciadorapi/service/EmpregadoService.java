package cagece.gerenciadorapi.service;

import cagece.gerenciadorapi.model.Empregado;
import cagece.gerenciadorapi.repository.EmpregadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpregadoService {

    @Autowired
    private EmpregadoRepository repository;

    public List<Empregado> listar(){
        return repository.findAll();
    }
    public Optional<Empregado> consultar(Long empregadoId){
        return repository.findById(empregadoId);
    }
    public Empregado cadastrar(Empregado empregado){
        return repository.save(empregado);
    }
}
