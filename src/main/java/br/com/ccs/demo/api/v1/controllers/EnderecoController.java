package br.com.ccs.demo.api.v1.controllers;

import br.com.ccs.demo.api.v1.models.input.EnderecoInput;
import br.com.ccs.demo.api.v1.models.output.EnderecoOutput;
import br.com.ccs.demo.domain.core.services.impl.EnderecoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/pessoa/{pessoa_id}/endereco")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EnderecoOutput post(@PathVariable UUID pessoa_id, @Valid @RequestBody EnderecoInput input) {
        return EnderecoOutput.toOutput(service.save(pessoa_id, input.toEndereco()));
    }
}
