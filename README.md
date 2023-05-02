# CRUD Operations with postgreSQL and java


## Objetivo do projeto
- Criar um CRUD (Create, Read, Update, Delete) em Java com PostgreSQL
- Entender o funcionamento do JDBC
- Entender o funcionamento do delete cascade
- Entender o funcionamento de um CRUD
- Entender o funcionamento de uma Factory
- Entender o funcionamento de um DAO
- Entender o funcionamento de um Model

## model - class Usuario

#### class Usuario
- Atributos
    - id (AUTO_INCREMENT)
    - nome
    - nickname
    - senha
    - nivel

### class Cargo
- Atributos
    - id (AUTO_INCREMENT)
    - nome_cargo
    - status
  
### class UserCargo - Relacionamento entre as classes Usuario e Cargo
- Atributos
    - id (AUTO_INCREMENT)
    - usuario_id
    - cargo_id
    - nome_usuario
    - nome_cargo

## dao - class CargoDAO

#### Métodos da classe CargoDAO

- Create
    - Criar um cargo

- Read
    - Read all
        - Lê todos os cargos

- Update
    - Atualiza um cargo

- Delete
    - Deleta um cargo

## dao - class UserDAO

#### Métodos da classe UserDAO

- Create
    - Criar um usuário
    - Deleta um usuário
    - Deleta um usuário pelo id
    - Deleta um usuário pelo nome

## dao - class UserCargoDAO

#### Métodos da classe UserCargoDAO

- Métodos
    - Criar um relacionamento entre um usuário e um cargo
    - Lê todos os relacionamentos entre usuários e cargos
    - Atualiza um relacionamento entre um usuário e um cargo
    - Deleta um relacionamento entre um usuário e um cargo


## factory - class ConnectionFactory

#### class ConnectionFactory
- Atributos estáticos
    - USERNAME
    - PASSWORD
    - DATABASE_URL

- Métodos
    - createConnectionToPostgreSQL()
    - main() - Testa a conexão com o banco de dados

## Classes para testar os métodos do CRUD

- InsertUser - class InsertUser
    - Insere um usuário no banco de dados

- InsertCargo - class InsertCargo
    - Insere um cargo no banco de dados

- InsertRelacioCargoUser - class InsertRelacioCargoUser
    - Insere um relacionamento entre um usuário e um cargo no banco de dados

- DeleteUser - class DeleteUser
    - Deleta um usuário no banco de dados pelo id

- DeleteCargo - class DeleteCargo
    - Deleta um cargo no banco de dados pelo id

- ViewCargoUser - class ViewCargoUser
    - Lê todos os relacionamentos entre usuários e cargos

## libraries - pom.xml gerenciador de dependências do Maven

     <dependencies>
        <!-- https://mvnrepository.com/artifact/org.postgresql/postgresql -->
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.6.0</version>
        </dependency>
        <dependency>
            <groupId>net.datafaker</groupId>
            <artifactId>datafaker</artifactId>
            <version>1.9.0</version>
        </dependency>
    </dependencies>

- postgresql- Conexão com o banco de dados
- datafaker - Gera dados aleatórios

## Postgres - query para criar o banco de dados e a tabela
    create database sistema

    create table cargo
    (
    id     serial
    primary key,
    nome   varchar(100) not null,
    status boolean      not null
    );

    create table usuario
    (
    id       serial
    primary key,
    nome     varchar(100) not null,
    nickname varchar(100) not null,
    senha    varchar(100) not null,
    nivel    varchar(100) not null
    );

    create table usuario_cargo
    (
    id         serial
    primary key,
    usuario_id integer not null
    references usuario
    on delete cascade,
    cargo_id   integer not null
    references cargo
    on delete cascade
    );