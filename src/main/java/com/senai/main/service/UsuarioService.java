package com.senai.main.service;

import com.senai.main.exception.LoginNotFoundException;
import com.senai.main.model.Usuario;
import com.senai.main.repository.RepositoryGenerico;
import com.senai.main.repository.UsuarioRepository;
import com.senai.main.utils.Encode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends ServiceGenerico<Usuario, Long>{
    private final UsuarioRepository usuarioRepository;

    /**
     * Construtor injetando o repository pelo hibernate
     *
     * @param usuarioRepository
     */
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Método sobrescrito responsável por persistir um usuário no banco
     * após encriptar a senha do mesmo
     * @param usuario
     * @return
     * @throws Exception
     */
    @Override
    public Usuario salvar(Usuario usuario) throws Exception {
        Usuario novoUsuario = usuario;
        novoUsuario.setPassword(Encode.encriptar(novoUsuario.getPassword()));
        return usuarioRepository.save(novoUsuario);
    }

    @Override
    public Usuario atualizarPorId(Usuario usuario) throws Exception {
        Usuario novoUsuario = usuario;
        novoUsuario.setPassword(Encode.encriptar(novoUsuario.getPassword()));
        return usuarioRepository.save(novoUsuario);
    }

    /**
     * Método responsável por autenticar algum login de
     * usuário
     * @param usuario
     * @return
     */
    public Usuario autenticar(Usuario usuario) throws Exception{
        String senhaEncriptada = Encode.encriptar(usuario.getPassword());
        return usuarioRepository.autenticar(usuario.getUsername(), senhaEncriptada)
                .orElseThrow(() -> new LoginNotFoundException("Usuário não encontrado"));
    }
    /**
     * Sobrescrição do getter genérico, para que o
     * service genérico consiga utilizar o repository corretamente
     *
     * @return
     */
    @Override
    protected RepositoryGenerico getRepositoryGenerico() {
        return this.usuarioRepository;
    }
}
