package br.com.ccs.demo.api.v1.controllers;

import br.com.ccs.demo.api.v1.models.input.PessoaInput;
import br.com.ccs.demo.api.v1.models.output.PessoaComEnderecoOutput;
import br.com.ccs.demo.api.v1.models.output.PessoaOutput;
import br.com.ccs.demo.domain.core.services.PessoaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/pessoa")
@RequiredArgsConstructor
public class PessoaController {
    private final PessoaService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaOutput postPessoa(@Valid @RequestBody PessoaInput pessoaInput) {
        return PessoaOutput.toOuput(service.save(pessoaInput.toPessoa()));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePessoa(@PathVariable UUID id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PessoaOutput updatePessoa(@PathVariable UUID id, @Valid @RequestBody PessoaInput pessoaInput) {
        return PessoaOutput.toOuput(service.update(id, pessoaInput.toPessoa()));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<PessoaOutput> getAll(@PageableDefault(size = 10, page = 0) Pageable pageable) {
        return PessoaOutput.toPage(service.findAll(pageable));
    }

    @GetMapping("/{id}/enderecos")
    @ResponseStatus(HttpStatus.OK)
    public PessoaComEnderecoOutput gePessoaComEndereco(@PathVariable UUID id) {
        return PessoaComEnderecoOutput.toOutput(service.findComEndereco(id));
    }
}
