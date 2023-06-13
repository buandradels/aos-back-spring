package com.example.uniKey2.service;

import com.example.uniKey2.model.Senhas;

import java.util.List;
import java.util.Optional;

public interface SenhasService {

    Senhas save(Senhas senha);

    List<Senhas> findAll();

    Optional<Senhas> findById(Long id);

    Senhas update(Senhas senha);

    void deleteById(Long id);

}
