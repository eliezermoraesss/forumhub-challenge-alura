package com.forumhub.dto;

import java.time.LocalDate;

public record DadosCadastroTopicoDto(
        Long id,
        String titulo,
        String mensagem,
        LocalDate dataCriacao,
        String status
) {}
