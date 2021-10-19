package com.senai.main.model;

import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity(name = "usuario")
@Where(clause = "deletado = false")
public class Usuario extends EntidadeGenerica {
    /**
     * Username do usuário
     */
    @Column(name = "username")
    private String username;

    /**
     * Password do usuário
     */
    @Column(name = "password")
    private String password;

    /**
     * Privilegio do usuário
     */
    @Column(name = "privilegio")
    private Integer privilegio;

    /**
     * Construtor com todos os parâmetros
     *
     * @param id
     * @param dataCadastro
     * @param dataAlteracao
     * @param deletado
     * @param username
     * @param password
     * @param privilegio
     */
    public Usuario(Long id, Date dataCadastro, Date dataAlteracao, boolean deletado, String username, String password,
                   Integer privilegio) {
        super(id, dataCadastro, dataAlteracao, deletado);
        this.username = username;
        this.password = password;
        this.privilegio = privilegio;
    }

    /**
     * Construtor com todos os parâmetros dessa entidade
     *
     * @param username
     * @param password
     */
    public Usuario(String username, String password, Integer privilegio) {
        this.username = username;
        this.password = password;
        this.privilegio = privilegio;
    }

    /**
     * Construtor vazio
     */
    public Usuario() { }

    /**
     * Getters e setters
     */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(Integer privilegio) {
        this.privilegio = privilegio;
    }
}
