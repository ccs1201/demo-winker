package br.com.ccs.demo.domain.core.services;

import br.com.ccs.demo.domain.entities.Endereco;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface EnderecoService {
    Endereco save(UUID pessoaId, Endereco endereco);

    Page<Endereco> findAll(Pageable pageable);

    Page<Endereco> findByPessoa(UUID pessoaId, Pageable pageable);

    void delete(UUID id);

    Endereco findById(UUID id);
}
