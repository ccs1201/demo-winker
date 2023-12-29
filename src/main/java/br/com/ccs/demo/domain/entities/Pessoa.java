package br.com.ccs.demo.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "pessoa")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicInsert
@DynamicUpdate
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(unique = true)
    @NotBlank
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

    @PostLoad
    private void calcularIdade() {
        var hoje = LocalDate.now();
        idade = hoje.getYear() - dataNascimento.getYear();
    }
}
