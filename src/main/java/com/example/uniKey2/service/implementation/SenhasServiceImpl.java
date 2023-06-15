package com.example.uniKey2.service.implementation;

;

import com.example.uniKey2.model.Senhas;
import com.example.uniKey2.repository.SenhasRepository;
import com.example.uniKey2.service.SenhasService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SenhasServiceImpl implements SenhasService {

    private final SenhasRepository senhasRepository;

    public SenhasServiceImpl(SenhasRepository senhasRepository) {
        this.senhasRepository = senhasRepository;
    }

    @Override
    public Senhas save(Senhas senha) {
        return senhasRepository.save(senha);
    }

    @Override
    public List<Senhas> findAll() {
        return senhasRepository.findAll();
    }

    @Override
    public Optional<Senhas> findById(Long id) {
        return senhasRepository.findById(id);
    }

    @Override
    public Senhas update(Senhas senha) {
        return senhasRepository.save(senha);
    }

    @Override
    public void deleteById(Long id) {
        senhasRepository.deleteById(id);
    }

}

