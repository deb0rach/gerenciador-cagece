package cagece.gerenciadorapi.service;

import cagece.gerenciadorapi.model.Cargo;
import cagece.gerenciadorapi.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService {

    @Autowired
    private CargoRepository repository;

    public List<Cargo> listar(){
        return repository.findAll();
    }
    public Cargo cadastrar(Cargo cargo){
        return repository.save(cargo);
    }
}
