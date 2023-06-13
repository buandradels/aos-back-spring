package com.example.uniKey2.repository;

import com.example.uniKey2.model.Senhas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SenhasRepository extends JpaRepository<Senhas, Long> {

}
