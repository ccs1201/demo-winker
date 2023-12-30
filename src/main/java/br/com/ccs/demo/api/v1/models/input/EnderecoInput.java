package br.com.ccs.demo.api.v1.models.input;

import br.com.ccs.demo.domain.entities.Endereco;
import br.com.ccs.demo.domain.entities.enums.TipoEnderecoEnum;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EnderecoInput(@NotNull(message = "{enderecoInput.tipoEndereco.notnull}")
                            TipoEnderecoEnum tipoEndereco,
                            @NotBlank(message = "{enderecoInput.logradouro.notblank}")
                            String logradouro,
                            @NotNull int cep,
                            @NotNull @Min(message = "{enderecoInput.numero.min}", value = 1)
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
