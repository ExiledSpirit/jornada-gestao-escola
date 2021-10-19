INSERT INTO usuario
(data_cadastro, deletado, username, "password", privilegio)
VALUES(CURRENT_TIMESTAMP, false, 'admin', '8C6976E5B5410415BDE908BD4DEE15DFB167A9C873FC4BB8A81F6F2AB448A918', 0);

INSERT INTO usuario
(data_cadastro, deletado, username, "password", privilegio)
VALUES(CURRENT_TIMESTAMP, false, 'professor', '17C1532CA6CFF8F6A3A8200028AF6C2580BF37F39E10CB0966E8A573E3B24A1F', 1);

INSERT INTO usuario
(data_cadastro, deletado, username, "password", privilegio)
VALUES(CURRENT_TIMESTAMP, false, 'aluno', 'A21D6F3803F0491C32444EF91A0836BE243CC4DA5186357E805B7009A5B0669B', 2);