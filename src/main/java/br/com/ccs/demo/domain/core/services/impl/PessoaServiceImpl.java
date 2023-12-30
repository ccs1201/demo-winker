package br.com.ccs.demo.domain.core.services.impl;

import br.com.ccs.demo.domain.core.repositories.PessoaRepository;
import br.com.ccs.demo.domain.core.services.PessoaService;
import br.com.ccs.demo.domain.entities.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository repository;
    private static final String NOT_FOUND_MSG = "Não foi possível localizar a pessoa com ID %s";
    private static final String JA_CADASTRADA = "Pessoa com nome %s já cadastrada.";

    @Override
    public Pessoa save(Pessoa pessoa) {
        try {
            return repository.save(pessoa);
        } catch (DataIntegrityViolationException e) {
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.CONFLICT, String.format(JA_CADASTRADA, pessoa.getNome()));
        }
    }

    @Override
    public void delete(UUID pessoaId) {
        repository.deleteById(pessoaId);
    }

    @Override
    public Pessoa update(UUID id, Pessoa pessoa) {
        this.findById(id);
        pessoa.setId(id);
        return repository.save(pessoa);
    }

    @Override
    public Pessoa findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format(NOT_FOUND_MSG, id)));
    }

    @Override
    public Page<Pessoa> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Pessoa findComEndereco(UUID id) {
        return repository.findComEndereco(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format(NOT_FOUND_MSG, id)));
    }
}
