package com.example.uniKey2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Senhas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String senha;

    @Column
    private String descricao;

    @ManyToOne
    @JoinColumn
    private Usuario usuario;

    // Construtores, getters e setters aqui

}
