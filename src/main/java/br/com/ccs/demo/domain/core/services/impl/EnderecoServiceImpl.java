package br.com.ccs.demo.domain.core.services.impl;

import br.com.ccs.demo.domain.core.repositories.EnderecoRepository;
import br.com.ccs.demo.domain.core.services.EnderecoService;
import br.com.ccs.demo.domain.entities.Endereco;
import br.com.ccs.demo.domain.entities.Pessoa;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

import static org.springframework.http.HttpStatus.*;

@Service
@AllArgsConstructor
@Slf4j
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository repository;
    private static final String PESSOA_NOT_FOUND_MSG = "Não foi possível localizar a pessoa com ID %s";
    private static final String NOT_FOUND_MSG = "Não foi possível localizar o endereço de ID %s";

    @Override
    public Endereco save(UUID pessoaId, Endereco endereco) {
        var pessoa = new Pessoa();
        pessoa.setId(pessoaId);
        endereco.setPessoa(pessoa);
        try {
            return repository.save(endereco);
        } catch (DataIntegrityViolationException e) {
            log.error(e.getStackTrace().toString());
            throw new ResponseStatusException(BAD_REQUEST,
                    String.format(PESSOA_NOT_FOUND_MSG, pessoaId));
        }
    }

    @Override
    public Page<Endereco> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<Endereco> findByPessoa(UUID pessoaId, Pageable pageable) {
        return repository.findByPessoaId(pessoaId, pageable);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Endereco findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(BAD_REQUEST,
                String.format(NOT_FOUND_MSG, id)));
    }
}
