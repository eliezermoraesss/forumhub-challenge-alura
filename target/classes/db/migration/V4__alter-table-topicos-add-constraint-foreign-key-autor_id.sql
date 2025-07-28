alter table topicos
    add constraint fk_topico_autor_id
    foreign key (autor_id) references usuarios(id);
