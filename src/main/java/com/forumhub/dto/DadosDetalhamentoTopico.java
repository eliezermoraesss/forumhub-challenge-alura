package com.forumhub.dto;

import com.forumhub.enums.Status;
import com.forumhub.model.Curso;
import com.forumhub.model.Topico;
import com.forumhub.model.Usuario;

import java.time.LocalDate;

public record DadosDetalhamentoTopico(
        Long id,
        String titulo,
        String mensagem,
        LocalDate dataCriacao,
        Status status,
        Usuario autor,
        Curso curso
) {
    public DadosDetalhamentoTopico(Topico topico) {
        this(topico.getId(),
            topico.getTitulo(),
            topico.getMensagem(),
            topico.getDataCriacao(),
            topico.getStatus(),
            topico.getAutor(),
            topico.getCurso());
    }
}
