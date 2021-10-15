package com.senai.main.controller;

import com.senai.main.model.Usuario;
import com.senai.main.service.ServiceGenerico;
import com.senai.main.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller da entidade usuário
 */
@RestController
@RequestMapping("usuario")
public class UsuarioController extends ControllerGenerico<Usuario, Long>{
    private final UsuarioService usuarioService;

    /**
     * Construtor injetando o service pelo spring
     * @param usuarioService
     */
    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /**
     * Endpoint responsável por
     * autenticar um login de usuário
     * @param usuario
     * @return
     * @throws Exception
     */
    @PostMapping("autenticar")
    public ResponseEntity<Usuario> autenticar(@RequestBody Usuario usuario) throws Exception{
        Usuario novoUsuario = usuarioService.autenticar(usuario);
        return new ResponseEntity<>(novoUsuario, HttpStatus.OK);
    }

    /**
     * Sobrescrição do getter genérico, para que o
     * controller genérico consiga utilizar o service corretamente
     *
     * @return
     */
    @Override
    protected ServiceGenerico<Usuario, Long> getServiceGenerico() {
        return this.usuarioService;
    }
}
