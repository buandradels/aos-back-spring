package com.example.uniKey2.controller;

import com.example.uniKey2.model.Senhas;
import com.example.uniKey2.repository.SenhasRepository;
import com.example.uniKey2.service.SenhasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/senhas")
public class SenhasController {

    private final SenhasRepository senhasRepository;

    @Autowired
    public SenhasController(SenhasRepository senhasRepository) {
        this.senhasRepository = senhasRepository;
    }

    @GetMapping
    public ResponseEntity<List<Senhas>> findAll() {
        List<Senhas> senhas = senhasRepository.findAll();
        return ResponseEntity.ok(senhas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Senhas>> findById(@PathVariable Long id) {
        Optional<Senhas> senha = senhasRepository.findById(id);
        return ResponseEntity.ok(senha);
    }

    @PostMapping
    public ResponseEntity<Senhas> create(@RequestBody Senhas senha) {
        Senhas createdSenha = senhasRepository.save(senha);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSenha);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Senhas> update(@PathVariable Long id, @RequestBody Senhas senha) {
        senha.setId(id);
        Senhas updatedSenha = senhasRepository.save(senha);
        return ResponseEntity.ok(updatedSenha);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        senhasRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
