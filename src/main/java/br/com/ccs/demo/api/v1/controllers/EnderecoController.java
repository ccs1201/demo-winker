package br.com.ccs.demo.api.v1.controllers;

import br.com.ccs.demo.api.v1.models.input.EnderecoInput;
import br.com.ccs.demo.api.v1.models.output.EnderecoOutput;
import br.com.ccs.demo.domain.core.services.EnderecoService;
import br.com.ccs.demo.domain.core.services.impl.EnderecoServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/endereco")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoService service;
    private static final String URI_PESSOA = "/pessoa/{pessoa_id}";

    @PostMapping(URI_PESSOA)
    @ResponseStatus(HttpStatus.CREATED)
    public EnderecoOutput post(@PathVariable @NotNull UUID pessoa_id, @Valid @RequestBody EnderecoInput input) {
        return EnderecoOutput.toOutput(service.save(pessoa_id, input.toEndereco()));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<EnderecoOutput> getAll(@PageableDefault Pageable pageable) {
        return EnderecoOutput.toPage(service.findAll(pageable));
    }

    @GetMapping(URI_PESSOA)
    @ResponseStatus(HttpStatus.OK)
    public Page<EnderecoOutput> getEnderecoPessoa(@NotNull @PathVariable UUID pessoa_id, @PageableDefault Pageable pageable) {
        return EnderecoOutput.toPage(service.findByPessoa(pessoa_id, pageable));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull UUID id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EnderecoOutput getById(@NotNull @PathVariable UUID id) {
        return EnderecoOutput.toOutput(service.findById(id));
    }
}
