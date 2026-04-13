package com.guilda.registro_aventureiros.repository.jpa;

import com.guilda.registro_aventureiros.model.audit.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String username);

    Optional<Usuario> findByEmail(String email);

    boolean existsByUsernameOrEmail(String username, String email);
}