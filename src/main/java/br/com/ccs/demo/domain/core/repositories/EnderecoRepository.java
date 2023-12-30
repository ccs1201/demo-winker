package br.com.ccs.demo.domain.core.repositories;

import br.com.ccs.demo.domain.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {
}
