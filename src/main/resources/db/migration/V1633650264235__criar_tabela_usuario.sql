CREATE SEQUENCE IF NOT EXISTS usuario_id_seq;

CREATE TABLE IF NOT EXISTS usuario(
    id int DEFAULT NEXTVAL('usuario_id_seq'),
    data_cadastro timestamp DEFAULT current_timestamp,
    data_alteracao timestamp,
    deletado boolean DEFAULT false,
    username varchar(64) UNIQUE,
    password varchar(64),
    privilegio smallInt,
    PRIMARY KEY(id)
);