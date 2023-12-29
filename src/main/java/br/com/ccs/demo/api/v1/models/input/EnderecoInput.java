package br.com.ccs.demo.api.v1.models.input;

import br.com.ccs.demo.domain.entities.Endereco;
import br.com.ccs.demo.domain.entities.enums.TipoEnderecoEnum;

public record EnderecoInput(Enum<TipoEnderecoEnum> tipoEndereco,
                            String logradouro,
                            int cep,
                            int numero,
                            String complemento) {

    public Endereco toEndereco() {
        return Endereco.builder()
                .cep(cep)
                .complemento(complemento)
                .tipoEndereco(tipoEndereco)
                .logradouro(logradouro)
                .numero(numero)
                .build();
    }

}
