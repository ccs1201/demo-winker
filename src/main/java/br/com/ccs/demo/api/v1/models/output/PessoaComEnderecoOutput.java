package br.com.ccs.demo.api.v1.models.output;

import br.com.ccs.demo.domain.entities.Endereco;
import br.com.ccs.demo.domain.entities.Pessoa;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public record PessoaComEnderecoOutput(
        PessoaOutput pessoa,
        List<EnderecoOutput> enderecos) {

    public static PessoaComEnderecoOutput toOutput(Pessoa pessoa) {
        return new PessoaComEnderecoOutput(PessoaOutput.toOuput(pessoa),
                EnderecoOutput.toOutputList(pessoa.getEnderecos()));
    }
}
