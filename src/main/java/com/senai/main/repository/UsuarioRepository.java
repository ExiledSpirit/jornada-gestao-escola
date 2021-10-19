package com.senai.main.repository;

import com.senai.main.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository da entidade usuário
 */
@Repository
public interface UsuarioRepository extends RepositoryGenerico<Usuario, Long> {
    @Query(name = "autenticar", nativeQuery = true,
            value = "SELECT * FROM usuario u WHERE u.username = :username and u.password = :password" +
                    " and deletado = false limit 1")
    Optional<Usuario> autenticar(String username, String password);
}
