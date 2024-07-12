# Projeto de Gestão de Projetos e Tarefas

Este projeto é uma aplicação web de gerenciamento de projetos e tarefas desenvolvida como parte de um desafio técnico para a posição de Desenvolvedor Java. Ele permite aos usuários visualizar, adicionar, editar e excluir projetos e suas respectivas tarefas.

## Requisitos Funcionais

### Cadastro de Projetos:
- Adicionar novos projetos com título, descrição e data de início.
  
### Listagem de Projetos:
- Exibir uma lista de todos os projetos cadastrados com opções para visualizar, editar e excluir.

### Cadastro de Tarefas:
- Adicionar novas tarefas para um projeto existente, incluindo título, descrição, prioridade e estimativa em horas.

### Listagem de Tarefas:
- Exibir uma lista de todas as tarefas associadas a um projeto com opções para visualizar, editar e excluir.

## Requisitos Técnicos

- Utilização do padrão de projeto MVC (Model-View-Controller).
- Uso do framework RichFaces para aprimoramento da interface do usuário.
- Configuração do Spring para injeção de dependências nos beans gerenciados pelo JSF.
- Utilização do Hibernate para mapeamento das entidades Projeto e Tarefa.
- Implementação de consultas HQL para operações de CRUD.

## Tecnologias Utilizadas

- Java 8
- Spring MVC
- Hibernate
- JSF (JavaServer Faces)
- RichFaces
- PostgreSQL
- Maven

## Pré-requisitos

Antes de iniciar, certifique-se de ter as seguintes ferramentas instaladas:

- JDK 8
- Maven
- PostgreSQL
- Git

## Configuração do Ambiente

1. **Clonando o Repositório:**

- git clone https://github.com/AlessandroOS/gerenciamento_projetos.git

2. **Configuração do Banco de Dados:**
- Crie um banco de dados PostgreSQL chamado `projeto`.
  CREATE DATABASE projeto;

- Crie um usuário PostgreSQL com permissões para acessar o banco.
  CREATE USER postgres WITH PASSWORD 'postgres';
  GRANT ALL PRIVILEGES ON DATABASE projeto TO postgres;

3. **Configuração do Projeto:**
- Verifique o arquivo de configuração do Spring em `/gerenciamento_projetos/src/main/webapp/WEB-INF/applicationContext.xml` para garantir que esteja configurado corretamente.

4. **Executando a Aplicação:**
- Para usar a aplicação, é necessário ter o Tomcat 9 instalado e configurado.
  
Acesse a aplicação em: [http://localhost:8080/gerenciamento-projetos/projetos.xhtml](http://localhost:8080/gerenciamento-projetos/projetos.xhtml)

5. **Dados Preexistentes:**
- Para facilitar o teste da aplicação, alguns dados já vêm inseridos automaticamente através da classe DataLoader. Esses dados incluem projetos e tarefas iniciais que são carregados no banco de dados ao iniciar a aplicação.
