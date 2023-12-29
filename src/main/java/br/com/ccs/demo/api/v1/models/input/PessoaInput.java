package br.com.ccs.demo.api.v1.models.input;

import br.com.ccs.demo.domain.entities.Pessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record PessoaInput(@NotBlank(message = "{pessoa.nome.notblank}")
                          @Length(min = 3, max = 255, message = "{pessoa.nome.length}")
                          String nome,
                          @NotNull(message = "{pessoa.dataNascimento.notnull}")
                          @PastOrPresent(message = "{pessoa.dataNascimento.PastOrPresent}")
                          LocalDate dataNascimento
) {

    public Pessoa toPessoa() {
        return Pessoa.builder()
                .nome(nome)
                .dataNascimento(dataNascimento)
                .build();
    }
}

