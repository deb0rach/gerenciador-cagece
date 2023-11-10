package cagece.gerenciadorapi.service;

import cagece.gerenciadorapi.model.Cargo;
import cagece.gerenciadorapi.model.Empregado;
import cagece.gerenciadorapi.model.Grupo;
import cagece.gerenciadorapi.model.Permissao;
import cagece.gerenciadorapi.repository.PermissaoRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PermissaoServiceTest {

    @Mock
    private PermissaoRepository repository;

    @InjectMocks
    private PermissaoService service;

    private Empregado gerarEmpregado(){
        Grupo grupo = new Grupo(1L, "Administrador");
        Cargo cargo = new Cargo(1L, "Diretor", grupo);
        return new Empregado(1L, "Joao", cargo);
    }
    @Test
    public void consultarPorGrupoIdTest() {
        //arrange
        List<Permissao> permissoes = new ArrayList<>();
        Mockito.when(repository.findAllByGruposId(Mockito.anyLong())).thenReturn(permissoes);
        //act
        List<Permissao> result = service.listarPorGrupoId(1L);
        //assert
        assertEquals(permissoes, result);
    }

    @Test
    public void verificarPermissaoTestPermissaoEmpty(){
        //arrange
        List<Permissao> permissoes = new ArrayList<>();
        Mockito.when(repository.findAllByGruposId(Mockito.anyLong())).thenReturn(permissoes);
        //act
        boolean result = service.verificarPermissao(Optional.ofNullable(gerarEmpregado()), 1L);
        //assert
        assertTrue(!result);
    }

    @Test
    public void verificarPermissaoTest(){
        //arrange
        Permissao permissao = new Permissao();
        permissao.setId(1L);
        permissao.setNome("Página Inicial");
        List<Permissao> permissoes = new ArrayList<>();
        permissoes.add(permissao);
        Mockito.when(repository.findAllByGruposId(Mockito.anyLong())).thenReturn(permissoes);
        //act
        boolean result = service.verificarPermissao(Optional.ofNullable(gerarEmpregado()), 1L);
        //assert
        assertTrue(result);
    }
}