package com.example.uniKey2.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.Builder;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table( name = "usuarios")
public class Usuario {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    @JsonIgnore
    private String senha;


}

