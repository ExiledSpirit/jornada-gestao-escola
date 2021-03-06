package com.senai.main.service;

import com.senai.main.model.Pessoa;
import com.senai.main.repository.PessoaRepository;
import com.senai.main.repository.RepositoryGenerico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service da entidade Pessoa
 */
@Service
public class PessoaService extends ServiceGenerico<Pessoa, Long>{
    private final PessoaRepository pessoaRepository;

    /**
     * Construtor injetando o repository pelo hibernate
     *
     * @param pessoaRepository
     */
    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    /**
     * Sobrescrição do getter genérico, para que o
     * service genérico consiga utilizar o service corretamente
     *
     * @return
     */
    @Override
    protected RepositoryGenerico getRepositoryGenerico() {
        return this.pessoaRepository;
    }
}
