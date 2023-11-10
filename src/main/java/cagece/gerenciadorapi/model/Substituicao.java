package cagece.gerenciadorapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Substituicao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "empregado_substituido_id")
    private Empregado empregadoSubstituido;

    @ManyToOne
    @JoinColumn(name = "empregado_substituto_id")
    private Empregado empregadoSubstituto;

    private Date dataInicio;

    private Date dataFim;
}
