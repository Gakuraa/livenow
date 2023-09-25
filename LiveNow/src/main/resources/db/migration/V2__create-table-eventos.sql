CREATE TABLE eventos (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT NOT NULL,
    dataHora DATETIME NOT NULL,
    criador_id BIGINT,
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    complemento varchar(100),
    numero varchar(20),
    uf char(2) not null,
    cidade varchar(100) not null,
    FOREIGN KEY (criador_id) REFERENCES usuarios(id)
);