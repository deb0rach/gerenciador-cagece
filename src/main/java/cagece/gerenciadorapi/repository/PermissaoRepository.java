package cagece.gerenciadorapi.repository;
import cagece.gerenciadorapi.model.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
    List<Permissao> findByGruposId(Long grupoId);
}
