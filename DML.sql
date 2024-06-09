
##INSERTS
INSERT INTO ferramentas 
(nome, marca, custo_aquisicao, status) 
VALUES ('Martelo', 'Tramontina', 25.99, 0), 
('Chave de Fenda', 'Stanley', 15.50, 0);

INSERT INTO amigos 
(nome, telefone) 
VALUES ('João', '(11) 9999-8888'),
 ('Maria', '(21) 9876-5432');

 INSERT INTO emprestimos 
(id_amigo, data_emprestimo, data_devolucao, status)
 VALUES (1, '2024-06-01', '2024-06-10', 1), 
(2, '2024-06-05', '2024-06-15', 1); 

INSERT INTO ferramentas_emprestadas 
(id_emprestimo, id_ferramenta) 
VALUES 
(1, 1), (2, 2);
