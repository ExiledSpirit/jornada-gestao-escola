package com.senai.main.controller;

import com.senai.main.model.EntidadeGenerica;
import com.senai.main.service.ServiceGenerico;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

public abstract class ControllerGenerico<T extends EntidadeGenerica, ID extends Serializable> {
    protected abstract ServiceGenerico<T, ID> getServiceGenerico();

    protected ControllerGenerico(){ }

    /**
     * Endpoint responsável por buscar todas as entidades
     * armazenadas no banco de dados
     *
     * @return ResponseEntity com a lista das entidades encontradas
     * @throws Exception
     */
    @PreAuthorize(value = "aluno")
    @GetMapping("")
    public ResponseEntity pesquisar() throws Exception{
        return new ResponseEntity<>(getServiceGenerico().pesquisar(), HttpStatus.OK);
    }

    /**
     * Endpoint responsável por persistir
     * a entidade recebida por parâmetro
     *
     * @param entidade
     * @return ResponseEntity com a entidade salva
     * @throws Exception
     */
    @PreAuthorize(value = "aluno")
    @PostMapping("")
    public ResponseEntity salvar(@RequestBody T entidade) throws Exception{
        return new ResponseEntity<>(getServiceGenerico().salvar(entidade), HttpStatus.CREATED);
    }

    /**
     * Endpoint responsável por deletar logicamente(deletado=true)
     * a entidade encontrada de acordo com o ID passado por parâmetro
     * @param id
     * @return ResponseEntity com a entidade deletada
     * @throws Exception
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deletarPorId(@PathVariable ID id) throws Exception {
        return new ResponseEntity<>(getServiceGenerico().deletarPorId(id), HttpStatus.OK);
    }

    /**
     * Endpoint responsável por buscar uma entidade armazenada
     * no banco de acordo com o ID passado por parâmetro
     * @param id
     * @return ResponseEntity com a entidade encontrada
     * @throws Exception
     */
    @GetMapping("/{id}")
    public ResponseEntity pesquisarPorId(@PathVariable ID id) throws Exception {
        return new ResponseEntity<>(getServiceGenerico().pesquisarPorId(id), HttpStatus.OK);
    }

    /**
     * Endpoint responsável por atualizar uma entidade
     * existente no sistema de acordo com os dados passados
     * pelo parâmetro
     *
     * @param id
     * @param entidade
     * @return ResponseEntity com a entidade atualizada
     * @throws Exception
     */
    @PutMapping("/{id}")
    public ResponseEntity atualizarPorId(@PathVariable ID id,
                                         @RequestBody T entidade) throws Exception {
        return new ResponseEntity<>(getServiceGenerico().atualizarPorId(entidade), HttpStatus.OK);
    }
}
