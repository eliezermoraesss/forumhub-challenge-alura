create table topicos (
    id bigint not null auto_increment,
    titulo varchar(255),
    mensagem text,
    data_criacao date,
    status_topico varchar(50) not null,
    primary key (id)
);
