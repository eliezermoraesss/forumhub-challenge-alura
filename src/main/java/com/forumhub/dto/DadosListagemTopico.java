package com.forumhub.dto;

import com.forumhub.enums.Status;
import com.forumhub.model.Topico;

import java.time.LocalDate;

public record DadosListagemTopico(
        Long id,
        String titulo,
        String mensagem,
        LocalDate dataCriacao,
        Status status,
        String nomeCurso
) {
    public DadosListagemTopico(Topico topico) {
        this(topico.getId(),
            topico.getTitulo(),
            topico.getMensagem(),
            topico.getDataCriacao(),
            topico.getStatus(),
            topico.getCurso().getNome());
    }
}
