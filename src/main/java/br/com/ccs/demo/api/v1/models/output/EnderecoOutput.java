package br.com.ccs.demo.api.v1.models.output;

import br.com.ccs.demo.domain.entities.Endereco;
import br.com.ccs.demo.domain.entities.enums.TipoEnderecoEnum;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public record EnderecoOutput(
        UUID id,
        Enum<TipoEnderecoEnum> tipoEndereco,
        String logradouro,
        int cep,
        int numero,
        String complemento,
        OffsetDateTime dataCadastro,
        OffsetDateTime dataUltimaAtualizacao) {

    public static EnderecoOutput toOutput(Endereco endereco) {
        return new EnderecoOutput(endereco.getId(),
                endereco.getTipoEndereco(),
                endereco.getLogradouro(),
                endereco.getCep(),
                endereco.getNumero(),
                endereco.getComplemento(),
                endereco.getDataCadastro(),
                endereco.getDataUltimaAtualizacao());
    }

    public static List<EnderecoOutput> toOutputList(List<Endereco> enderecos) {
        return enderecos.stream()
                .map(EnderecoOutput::toOutput)
                .toList();
    }
}
