package cagece.gerenciadorapi.repository;

import cagece.gerenciadorapi.model.Empregado;
import cagece.gerenciadorapi.model.Substituicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubstituicaoRepository extends JpaRepository<Substituicao, Long> {
    @Query("SELECT s FROM Substituicao s " +
            "WHERE s.empregadoSubstituto.id = :empregadoId " +
            "ORDER BY s.dataFim DESC " +
            "LIMIT 1")
    Substituicao encontrarUltimaPorEmpregadoSubstitutoId(@Param("empregadoId") Long empregadoId);

    @Query("SELECT e FROM Empregado e " +
            "INNER JOIN Substituicao s ON s.empregadoSubstituido.id = e.id " +
            "WHERE s.empregadoSubstituto.id = :empregadoId " +
            "ORDER BY s.dataFim DESC " +
            "LIMIT 1")
    Empregado consultarEmpregadoSubstituidoPorEmpregadoSubstitutoId(@Param("empregadoId") Long empregadoId);
}
