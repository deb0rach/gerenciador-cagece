package cagece.gerenciadorapi.repository;
import cagece.gerenciadorapi.model.Permissao;
import cagece.gerenciadorapi.model.PermissaoGrupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PermissaoGrupoRepository extends JpaRepository<PermissaoGrupo, Long> {
}