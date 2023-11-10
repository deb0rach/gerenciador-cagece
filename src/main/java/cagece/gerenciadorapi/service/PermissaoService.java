package cagece.gerenciadorapi.service;

import cagece.gerenciadorapi.model.Empregado;
import cagece.gerenciadorapi.model.Permissao;
import cagece.gerenciadorapi.model.PermissaoGrupo;
import cagece.gerenciadorapi.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PermissaoService {

    @Autowired
    private PermissaoRepository repository;

    @Autowired
    SubstituicaoService substituicaoService;

    @Autowired EmpregadoService empregadoService;

    public List<Permissao> listar(){
        return repository.findAll();
    }

    public boolean verificar(Long empregadoId, Long permissaoId) throws Exception {
        Optional<Empregado> empregado = empregadoService.consultar(empregadoId);
        if(!Objects.nonNull(empregado) || empregado.isEmpty())
            throw new Exception("Empregado não encontrado");
        Optional<Permissao> permissao = repository.findById(permissaoId);
        if(!Objects.nonNull(permissao) || permissao.isEmpty())
            throw new Exception("Permissão não encontrada");

        if(verificarPermissao(empregadoId, permissaoId))
            return true;

        if(substituicaoService.verificarSubstituicaoAtiva(empregadoId)) {
            Empregado empregadoSubstituido = substituicaoService.consultarEmpregadoSubstituidoPorEmpregadoSubstituto(empregadoId);
            if(verificarPermissao(empregadoSubstituido.getId(), permissaoId))
                return true;
        }
        return false;
    }
    public boolean verificarPermissao(Long empregadoId, Long permissaoId) {
        List<Permissao> permissoes = consultarPorGrupoId(empregadoId);
        if(Objects.nonNull(permissoes) && !permissoes.isEmpty()) {
            boolean contemPermissao = permissoes.stream().anyMatch(obj -> obj.getId() == permissaoId);
            if (contemPermissao)//quarkus
                return true;
        }
        return false;
    }
    public List<Permissao> consultarPorGrupoId(Long grupoId){
        return repository.findByGruposId(grupoId);
    }
}
