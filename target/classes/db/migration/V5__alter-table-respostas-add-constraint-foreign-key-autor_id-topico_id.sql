alter table respostas
    add column autor_id bigint,
    add column topico_id bigint;

alter table respostas
    add constraint fk_resposta_autor_id
    foreign key (autor_id) references usuarios(id);

alter table respostas
    add constraint fk_resposta_topico_id
    foreign key (topico_id) references topicos(id);
