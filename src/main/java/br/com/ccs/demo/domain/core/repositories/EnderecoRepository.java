package br.com.ccs.demo.domain.core.repositories;

import br.com.ccs.demo.domain.entities.Endereco;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {
    @Query("select e from Endereco e where e.pessoa.id= :pessoaId")
    Page<Endereco> findByPessoaId(UUID pessoaId, Pageable pageable);
}
