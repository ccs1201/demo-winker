delete from pessoa;

INSERT INTO pessoa (id, data_cadastro, data_nascimento, data_ultima_atualizacao, nome)
VALUES ('4469350f-8ed0-40fb-a545-cc0be88f9d01', '2023-12-30 13:21:09.009974', '2000-12-29',
        '2023-12-30 13:21:09.010030', 'Leonardo'),
       ('a336511f-d415-4fef-bda3-053f4eaefc6b', '2023-12-30 13:21:09.009974', '2001-12-29',
        '2023-12-30 13:21:09.010030', 'João'),
       ('7a325809-d8e6-4234-997d-8b6784c16152', '2023-12-30 13:21:09.009974', '2002-12-29',
        '2023-12-30 13:21:09.010030', 'José'),
       ('8d1f4870-25d1-4933-913e-b9a84614cec3', '2023-12-30 13:21:09.009974', '2003-12-29',
        '2023-12-30 13:21:09.010030', 'Joaquim'),
       ('ef9eade7-3241-4e8c-91a8-15a4fff88828', '2023-12-30 13:21:09.009974', '1981-01-12',
        '2023-12-30 13:21:09.010030', 'Cleber Souza');


INSERT INTO endereco (cep, numero, data_cadastro, data_ultima_atualizacao, id, pessoa_id, complemento, logradouro, tipo_endereco)
VALUES (88101350, 620, '2023-12-30 16:10:58.317447', '2023-12-30 16:10:58.317470', 'e612ba2c-1a3d-4681-8753-7dde83836f8c', 'ef9eade7-3241-4e8c-91a8-15a4fff88828', 'apto 1101', 'João Saturnino Ouriques', 'RUA');