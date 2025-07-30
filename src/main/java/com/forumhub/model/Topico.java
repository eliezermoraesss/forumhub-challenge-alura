package com.forumhub.model;

import com.forumhub.dto.DadosCadastroTopicoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "Topico")
@Table(name = "topicos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    @Column(unique = true)
    private String mensagem;
    private LocalDate dataCriacao;
    private String status;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
    private List<Resposta> respostas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    public Topico(DadosCadastroTopicoDto dadosDto) {
        this.id = dadosDto.id();
        this.titulo = dadosDto.titulo();
        this.mensagem = dadosDto.mensagem();
        this.dataCriacao = dadosDto.dataCriacao();
        this.status = dadosDto.status();
        this.autor = new Usuario(); // Assuming you will set the author later
        this.respostas = dadosDto.respostas(); // Assuming you will handle responses separately
    }
}
