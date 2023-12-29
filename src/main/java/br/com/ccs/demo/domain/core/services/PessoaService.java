package br.com.ccs.demo.domain.core.services;

import br.com.ccs.demo.domain.entities.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface PessoaService {

    Pessoa save(Pessoa pessoa);

    void delete(UUID pessoaId);

    Pessoa update(UUID id, Pessoa pessoa);

    Pessoa findById(UUID id);

    Page<Pessoa> findAll(Pageable pageable);

    Pessoa findComEndereco(UUID id);
}
