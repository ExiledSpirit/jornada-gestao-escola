package com.senai.main.controller;

import com.senai.main.model.Pessoa;
import com.senai.main.service.PessoaService;
import com.senai.main.service.ServiceGenerico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller da entidade Pessoa
 */
@RestController
@RequestMapping("/pessoa")
public class PessoaController extends ControllerGenerico<Pessoa, Long>{
    private final PessoaService pessoaService;

    /**
     * Construtor injetando o service pelo spring
     *
     * @param pessoaService
     */
    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    /**
     * Sobrescrição do getter genérico, para que o
     * controller genérico consiga utilizar o service corretamente
     *
     * @return
     */
    @Override
    protected ServiceGenerico getServiceGenerico() {
        return this.pessoaService;
    }
}
