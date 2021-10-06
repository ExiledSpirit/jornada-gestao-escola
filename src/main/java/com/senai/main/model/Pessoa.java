package com.senai.main.model;

import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;


/**
 * Model para a classe pessoa
 */
@Entity
@Table(name = "pessoa", schema = "escola")
@Where(clause = "deletado = false")
public class Pessoa extends EntidadeGenerica {
    /**
     * Nome da entidade
     */
    @Column(name = "nome")
    private String nome;

    /**
     * Cpf da pessoa
     */
    @Column(name = "cpf")
    private String cpf;

    /**
     * Email da pessoa
     */
    @Column(name = "email")
    private String email;

    /**
     * Data de nascimento da pessoa
     */
    @Column(name = "data_nascimento")
    private Date dataNascimento;

    /**
     * Construtor com todos os parâmetros
     *
     * @param id
     * @param dataCadastro
     * @param dataAlteracao
     * @param deletado
     * @param nome
     * @param cpf
     * @param email
     * @param dataNascimento
     */
    public Pessoa(Long id, Date dataCadastro, Date dataAlteracao, boolean deletado, String nome, String cpf, String email, Date dataNascimento) {
        super(id, dataCadastro, dataAlteracao, deletado);
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    /**
     * Construtor com os parâmetros da entidade
     *
     * @param nome
     * @param cpf
     * @param email
     * @param dataNascimento
     */
    public Pessoa(String nome, String cpf, String email, Date dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    /**
     * Construtor vazio
     */
    public Pessoa() {}

    /**
     * Getters e setters
     */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNascimento() {
        return dataNascimento;
    }

    public void setNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
