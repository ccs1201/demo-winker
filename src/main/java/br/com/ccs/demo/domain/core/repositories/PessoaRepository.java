package br.com.ccs.demo.domain.core.repositories;

import br.com.ccs.demo.domain.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {
    @Query("select p from Pessoa p join fetch Endereco e where p.id = :id")
    Pessoa findComEndereco(UUID id);
}
