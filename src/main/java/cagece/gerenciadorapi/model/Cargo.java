package cagece.gerenciadorapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Cargo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    private Grupo grupo;

    public Cargo(Long id, String nome, Grupo grupo) {
        this.id = id;
        this.nome = nome;
        this.grupo = grupo;
    }

    public Cargo() {

    }
}
