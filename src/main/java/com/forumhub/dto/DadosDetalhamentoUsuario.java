package com.forumhub.dto;

public record DadosDetalhamentoUsuario(Long id, String nome, String email) {

    public DadosDetalhamentoUsuario(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
}
