package br.com.ccs.demo.domain.entity.core;

import lombok.Getter;

@Getter
public enum TipoEnderecoEnum {

    RUA("Rua"),
    AVENIDA("Avenida"),
    SERVIDAO("Servidão"),
    ESTRADA("Estrada");

    private String value;

    TipoEnderecoEnum(String value) {
        this.value = value;
    }
}
