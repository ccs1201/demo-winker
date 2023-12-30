package br.com.ccs.demo.domain.core.services.impl;

import br.com.ccs.demo.domain.core.repositories.EnderecoRepository;
import br.com.ccs.demo.domain.entities.Endereco;
import br.com.ccs.demo.domain.entities.Pessoa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class EnderecoService {

    private final EnderecoRepository repository;

    public Endereco save(UUID pessoaId, Endereco endereco) {
        var pessoa = new Pessoa();
        pessoa.setId(pessoaId);
        endereco.setPessoa(pessoa);
        return repository.save(endereco);
    }
}
