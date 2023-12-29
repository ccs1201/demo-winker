package br.com.ccs.demo.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    private String nome;

    private LocalDate dataNascimento;

    @Transient
    private int idade;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "pessoa",
            fetch = FetchType.LAZY)
    private List<Endereco> enderecos;

    @CreationTimestamp
    @Column(nullable = false,
            columnDefinition = "datetime",
            updatable = false)
    private OffsetDateTime dataCadastro;

    @UpdateTimestamp
    @Column(nullable = false,
            columnDefinition = "datetime")
    private OffsetDateTime dataUltimaAtualizacao;
}
