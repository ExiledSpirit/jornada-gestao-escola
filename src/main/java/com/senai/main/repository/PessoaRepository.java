package com.senai.main.repository;

import com.senai.main.model.Pessoa;
import org.springframework.stereotype.Repository;

/**
 * Repository da entidade Pessoa
 */
@Repository
public interface PessoaRepository extends RepositoryGenerico<Pessoa, Long>{
}
