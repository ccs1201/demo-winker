package br.com.ccs.demo.api.v1.model.output;

import java.util.List;

public record PessoaComEnderecoOutput(
        PessoaOutput pessoa,
        List<EnderecoOutput> enderecos) {
}
