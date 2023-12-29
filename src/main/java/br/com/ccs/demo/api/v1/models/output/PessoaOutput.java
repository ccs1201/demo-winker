package br.com.ccs.demo.api.v1.model.output;

import br.com.ccs.demo.domain.entities.Pessoa;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

public record PessoaOutput(UUID id,
                           String nome,
                           LocalDate dataNascimento,
                           int idade,
                           OffsetDateTime dataCadastro,
                           OffsetDateTime dataUltimaAtualizacao) {

    public static PessoaOutput toOuput(Pessoa pessoa) {
        return new PessoaOutput(pessoa.getId(),
                pessoa.getNome(),
                pessoa.getDataNascimento(),
                pessoa.getIdade(),
                pessoa.getDataCadastro(),
                pessoa.getDataUltimaAtualizacao());
    }

    public static Page<PessoaOutput> toPage(Page<Pessoa> pagePessoas) {

        return pagePessoas.map(PessoaOutput::toOuput);
    }
}
