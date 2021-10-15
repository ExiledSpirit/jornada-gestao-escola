package com.senai.main.service;

import com.senai.main.exception.IdNotFoundException;
import com.senai.main.model.EntidadeGenerica;
import com.senai.main.repository.RepositoryGenerico;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;


/**
 * Service genérico que possui metódos compartilhados
 * por todas as outras entidades do sistema
 * @param <T>
 * @param <ID>
 */
public abstract class ServiceGenerico<T extends EntidadeGenerica, ID extends Serializable> {
    protected abstract RepositoryGenerico<T, ID> getRepositoryGenerico();

    /**
     * Lista todas as entidades armazenadas
     *
     * @return List<Entidade>
     */
    public List<T> pesquisar() {
        return this.getRepositoryGenerico().findAll();
    }

    /**
     * Persiste uma entidade no banco
     *
     * @param entidade
     * @return T Entidade salva
     */
    public T salvar(T entidade) throws Exception {
        return this.getRepositoryGenerico().save(entidade);
    }

    /**
     * Busca uma entidade específica à partir de seu ID
     *
     * @param id
     * @return T entidade encontrada
     * @throws Throwable
     */
    public T pesquisarPorId(ID id) {
        return this.getRepositoryGenerico().findById(id)
                .orElseThrow(() -> new IdNotFoundException("ID " + id + " não encontrado."));
    }

    /**
     * Atualiza uma entidade existente no sistema
     * à partir de seu ID e entidade passada
     *
     * @param entidade
     * @return T entidade atualizada
     */
    public T atualizarPorId(T entidade) throws Exception {
        return this.getRepositoryGenerico().save(entidade);
    }

    /**
     * Deletação lógica
     *
     * @param id
     * @return T objeto deletado
     */
    public T deletarPorId(ID id) {
        T entidade = getRepositoryGenerico().findById(id)
                .orElseThrow(() -> new IdNotFoundException("ID " + id + " não encontrado."));
        entidade.setDeletado(true);
        return getRepositoryGenerico().save(entidade);
    }
}
