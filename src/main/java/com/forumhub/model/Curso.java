package com.forumhub.model;

import com.forumhub.enums.Categoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Curso")
@Table(name = "cursos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    @Enumerated(value = EnumType.STRING)
    private Categoria categoria;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Topico> topicos;
}
