package com.senai.main.repository;

import com.senai.main.model.EntidadeGenerica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;


/**
 * Repository genérico, voltado para todas as classes
 * genéricas do sistema
 *
 * @param <T> Classe para generics
 * @param <ID>Primary Key para generics
 */
@NoRepositoryBean
public interface RepositoryGenerico<T extends EntidadeGenerica, ID extends Serializable> extends JpaRepository<T, ID> {
}
