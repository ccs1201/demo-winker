package br.com.ccs.demo.api.controllers;

import br.com.ccs.demo.api.model.input.PessoaInput;
import br.com.ccs.demo.api.model.output.PessoaOutput;
import br.com.ccs.demo.domain.core.services.PessoaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pessoa")
@RequiredArgsConstructor
public class PessoaController {
    private final PessoaService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaOutput postPessoa(@Valid @RequestBody PessoaInput pessoaInput) {


        return null;

    }
}
