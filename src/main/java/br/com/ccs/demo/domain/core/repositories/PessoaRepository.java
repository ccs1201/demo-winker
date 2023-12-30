package br.com.ccs.demo.domain.core.repositories;

import br.com.ccs.demo.domain.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {
    @Query("select distinct p from Pessoa p left join fetch p.enderecos where p.id = :id")
    Optional<Pessoa> findComEndereco(UUID id);
}
