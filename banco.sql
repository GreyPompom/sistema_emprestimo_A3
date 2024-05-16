#criar o database chamado db_emprestimos
CREATE DATABASE IF NOT EXISTS db_emprestimos;

#entrar no database db_emprestimos
USE db_emprestimos;

#remove as tabelas para recriá-las

drop table if exists ferramentas;

drop table if exists amigos;

drop table if exists emprestimo;


#cria a tabela de Ferramenta 
CREATE TABLE ferramentas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    custo DOUBLE NOT NULL,
    marca VARCHAR(100) NOT NULL,
    status BOOLEAN NOT NULL DEFAULT TRUE
);

#cria a tabela de Amigo 
CREATE TABLE amigos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20) NOT NULL
);

-- Criação da tabela Emprestimo
CREATE TABLE emprestimo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_ferramenta INT NOT NULL,
    id_amigo INT NOT NULL,
    data_emprestimo DATE NOT NULL,
    data_devolucao DATE,
    FOREIGN KEY (id_ferramenta) REFERENCES ferramentas(id)
,
    FOREIGN KEY (id_amigo) REFERENCES amigo(id)

);


#lista a tabela criada
show tables;
