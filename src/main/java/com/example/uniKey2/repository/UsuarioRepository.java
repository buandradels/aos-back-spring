package com.example.uniKey2.repository;

import com.example.uniKey2.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;



import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmailAndSenha(String email, String senha);
    boolean existsByEmailAndSenha(String email, String senha);
    boolean existsByEmail(String email);
}
