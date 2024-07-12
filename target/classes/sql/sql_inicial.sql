-- Insere projetos de exemplo
INSERT INTO projeto (titulo, descricao, datainicio)
VALUES (1, 'Projeto Alpha', 'Descrição do Projeto Alpha', '2024-01-01'),
       (2, 'Projeto Beta', 'Descrição do Projeto Beta', '2024-02-01'),
       (3, 'Projeto Gamma', 'Descrição do Projeto Gamma', '2024-03-01');

-- Insere tarefas de exemplo para os projetos
INSERT INTO tarefa (id, titulo, descricao, prioridade, estimativahoras, projeto_id)
VALUES (1, 'Tarefa 1 do Projeto Alpha', 'Descrição da Tarefa 1 do Projeto Alpha', 'ALTA', 5, 1),
       (2, 'Tarefa 2 do Projeto Alpha', 'Descrição da Tarefa 2 do Projeto Alpha', 'BAIXA', 3, 1),
       (3, 'Tarefa 1 do Projeto Beta', 'Descrição da Tarefa 1 do Projeto Beta', 'MUITO_BAIXA', 8, 2),
       (4, 'Tarefa 2 do Projeto Beta', 'Descrição da Tarefa 2 do Projeto Beta', 'ALTA', 4, 2),
       (5, 'Tarefa 1 do Projeto Gamma', 'Descrição da Tarefa 1 do Projeto Gamma', 'MUITO_ALTA', 2, 3);
