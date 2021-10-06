package com.senai.main.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Model genérico que compartilhará dos atributos para todas
 * as outras entidades do sistema
 */
@MappedSuperclass
public class EntidadeGenerica implements Serializable {
    /**
     * ID da entidade
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Data de cadastro da entidade
     */
    @Column(name = "data_cadastro")
    private Date dataCadastro;

    /**
     * Data de alteração da entidade
     */
    @Column(name = "data_alteracao")
    private Date dataAlteracao;

    /**
     * Se a entidade foi ou não deletada
     */
    @Column(name = "deletado")
    private boolean deletado;

    /**
     * Construtor com todos os parâmetros da entidade
     *
     * @param id
     * @param dataCadastro
     * @param dataAlteracao
     * @param deletado
     */
    public EntidadeGenerica(Long id, Date dataCadastro, Date dataAlteracao, boolean deletado) {
        this.id = id;
        this.dataCadastro = dataCadastro;
        this.dataAlteracao = dataAlteracao;
        this.deletado = deletado;
    }

    /**
     * Construtor vazio
     */
    public EntidadeGenerica() {}

    /**
     * Getters e setters
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public boolean isDeletado() {
        return deletado;
    }

    public void setDeletado(boolean deletado) {
        this.deletado = deletado;
    }
}
