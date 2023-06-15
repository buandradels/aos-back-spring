package com.example.uniKey2.controller;

import com.example.uniKey2.dto.UsuarioDTO;
import com.example.uniKey2.model.Usuario;
import com.example.uniKey2.model.exception.BusinessRuleException;
import com.example.uniKey2.service.UsuarioService;
import com.example.uniKey2.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioService service;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository, UsuarioService service) {
        this.usuarioRepository = usuarioRepository;
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody Usuario usuario) {
        Optional<Usuario> user = usuarioRepository.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha());
        if (user.isPresent()) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity save(@RequestBody UsuarioDTO dto){
        Usuario usuario = Usuario.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .senha(dto.getSenha())
                .build();

        try {
            var usuarioSalvo = service.cadastrar(usuario);
            return new ResponseEntity(usuarioSalvo, HttpStatus.CREATED);
        }
        catch(BusinessRuleException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> findById(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        Usuario updatedUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.ok(updatedUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

