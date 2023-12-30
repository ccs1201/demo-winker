package br.com.ccs.demo.domain.entities.enums;

import lombok.Getter;

@Getter
public enum TipoEnderecoEnum {

    RUA("Rua"),
    AVENIDA("Avenida"),
    SERVIDAO("Servidão"),
    ESTRADA("Estrada");

    private final String value;

    TipoEnderecoEnum(String value) {
        this.value = value;
    }
}
