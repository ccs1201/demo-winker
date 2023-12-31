create table pessoa
(
    id                      uuid      not null,
    data_cadastro           timestamp not null,
    data_nascimento         date,
    data_ultima_atualizacao timestamp not null,
    nome                    varchar(255),
    primary key (id)
);
create table endereco
(
    cep                     integer   not null,
    numero                  integer   not null,
    data_cadastro           timestamp not null,
    data_ultima_atualizacao timestamp not null,
    id                      uuid      not null,
    pessoa_id               uuid,
    complemento             varchar(255),
    logradouro              varchar(255),
    tipo_endereco           varchar(100),
    primary key (id)
);

alter table if exists endereco
    add constraint FK_Endereco_Pessoa
        foreign key (pessoa_id)
            references pessoa on delete cascade;

alter table if exists pessoa
    add constraint UK_Pessoa_Nome
        unique (nome);
