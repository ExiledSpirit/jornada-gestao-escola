CREATE SEQUENCE IF NOT EXISTS pessoa_id_seq;

CREATE TABLE IF NOT EXISTS pessoa(
    id int DEFAULT NEXTVAL('pessoa_id_seq'),
    data_cadastro timestamp DEFAULT current_timestamp,
    data_alteracao timestamp,
    deletado boolean DEFAULT false,
    nome varchar(100),
    cpf varchar(15),
    email varchar(60),
    data_nascimento Date,
    PRIMARY KEY(id)
);