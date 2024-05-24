#criar o database chamado db_emprestimos
CREATE DATABASE IF NOT EXISTS db_emprestimos;

#entrar no database db_emprestimos
USE db_emprestimos;

#remove as tabelas para recriá-las

drop table if exists ferramentas;

drop table if exists amigos;

drop table if exists emprestimos;


#cria a tabela de Ferramenta 

CREATE DATABASE IF NOT EXISTS db_emprestimos;
USE db_emprestimos;
CREATE TABLE IF NOT EXISTS ferramentas (
    id_ferramenta INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    marca VARCHAR(255),
    custo_aquisicao DECIMAL(10, 2),
    status BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS amigos (
    id_amigo INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    telefone VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS emprestimos (
    id_emprestimo INT AUTO_INCREMENT PRIMARY KEY,
    id_amigo INT,
    data_emprestimo DATE,
    data_devolucao DATE,
    FOREIGN KEY (id_ferramenta) REFERENCES ferramentas(id_ferramenta),
    FOREIGN KEY (id_amigo) REFERENCES amigos(id_amigo)
);


CREATE TABLE ferramentas_emprestadas (
    id_emprestimo INT NOT NULL,
    id_ferramenta INT NOT NULL,
    data_devolucao DATE DEFAULT NULL,
    FOREIGN KEY (id_emprestimo) REFERENCES emprestimos(id_emprestimo),
    FOREIGN KEY (id_ferramenta) REFERENCES ferramentas(id_ferramenta)
);
