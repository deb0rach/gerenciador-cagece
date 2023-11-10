package cagece.gerenciadorapi.service;

import cagece.gerenciadorapi.model.Empregado;
import cagece.gerenciadorapi.model.Substituicao;
import cagece.gerenciadorapi.repository.SubstituicaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SubstituicaoService {

    @Autowired
    private SubstituicaoRepository repository;

    @Autowired
    private EmpregadoService empregadoService;

    public List<Substituicao> listar(){
        return repository.findAll();
    }
    public Substituicao cadastrar(Substituicao substituicao) throws Exception {
        Optional<Empregado> empregadoSubstituido = empregadoService.consultar(substituicao.getEmpregadoSubstituido().getId());
        if(!Objects.nonNull(empregadoSubstituido) || empregadoSubstituido.isEmpty())
            throw new Exception("Empregado substituido não encontrado");
        Optional<Empregado> empregadoSubstituto = empregadoService.consultar(substituicao.getEmpregadoSubstituto().getId());
        if(!Objects.nonNull(empregadoSubstituto) || empregadoSubstituto.isEmpty())
            throw new Exception("Empregado substituto não encontrado");
        return repository.save(substituicao);
    }

    public boolean verificarSubstituicaoAtiva(Long empregadoId){
        Substituicao substituicao = repository.encontrarUltimaPorEmpregadoSubstitutoId(empregadoId);
        Date dataAtual = new Date();
        if(Objects.nonNull(substituicao) && substituicao.getDataFim().after(dataAtual))
            return true;
        return false;
    }

    public Empregado consultarEmpregadoSubstituidoPorEmpregadoSubstituto(Long empregadoId) throws Exception {
        Empregado empregadoSubstituido = repository.consultarEmpregadoSubstituidoPorEmpregadoSubstitutoId(empregadoId);
        if(!Objects.nonNull(empregadoSubstituido))
            throw new Exception("Empregado substituído não encontrado");
        return empregadoSubstituido;
    }
}
