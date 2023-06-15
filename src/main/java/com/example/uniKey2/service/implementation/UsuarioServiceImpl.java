package com.example.uniKey2.service.implementation;



import com.example.uniKey2.model.Usuario;
import com.example.uniKey2.model.exception.BusinessRuleException;
import com.example.uniKey2.repository.UsuarioRepository;
import com.example.uniKey2.service.UsuarioService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void validarEmail(String email) {
        boolean exist = usuarioRepository.existsByEmail(email);
        if(exist) throw new BusinessRuleException("Já existe um usuario cadastrado com esse email");
    }


    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    @Transactional
    public Usuario cadastrar(Usuario usuario) {
        validarEmail(usuario.getEmail());
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario update(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Optional<Usuario> findByEmailAndSenha(String email, String senha) {
        return usuarioRepository.findByEmailAndSenha(email, senha);
    }
}

