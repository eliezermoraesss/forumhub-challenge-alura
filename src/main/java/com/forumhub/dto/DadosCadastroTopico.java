package com.forumhub.dto;

import com.forumhub.enums.Status;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastroTopico(

        @NotBlank
        String titulo,

        @NotBlank
        String mensagem,

        @FutureOrPresent
        LocalDate dataCriacao,

        @NotNull
        Status status,

        @NotBlank
        String nomeCurso
) {}
