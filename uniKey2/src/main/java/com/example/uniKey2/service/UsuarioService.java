package com.example.uniKey2.service;

import com.example.uniKey2.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    Usuario save(Usuario usuario);

    List<Usuario> findAll();

    Optional<Usuario> findById(Long id);

    Usuario update(Usuario usuario);

    void deleteById(Long id);


    Optional<Usuario> findByEmailAndSenha(String email, String senha);
}
