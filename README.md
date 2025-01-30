# Projedo TODO LIST
  Este projeto utiliza Docker Compose para configurar um ambiente de desenvolvimento com Microsoft SQL Server 2022 e uma aplicação Spring Boot que se conecta ao banco de dados. Ele é ideal para desenvolvimento e testes isolados de aplicações que utilizam o MSSQL como banco de dados.

## Pré requisitos

  Para executar a aplicação é necessário:
  - Java 21 
  - Maven 3.8+
  - Docker
## Executando o projeto
Com o MAVEN instalado execute o package do projeto.

```shell
  mvn clean package
```
Desta forma quando executar o compose, tera o jar para criar a imagem e por consequencia o container.

Pode ser executado via cmd utilizando docker-compose


```shell
  docker-compose up --build 
```

Esse comando irá:

* Baixar a imagem oficial do SQL Server 2022.
* Construir a imagem da aplicação Spring Boot a partir do Dockerfile.
* Rodar os dois containers: um para o SQL Server e outro para a aplicação Spring Boot.
### Passo 3: Acessar a Aplicação
Após os containers estarem rodando, você pode acessar a aplicação em:

```shell
  http://localhost:8001/
```

# Para conhecimento
A API é composta de um endpoint que realiza o CRUD de um TODO LIST, na URI `` /todo `` é possivel realizar as operações.
