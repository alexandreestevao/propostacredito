# spring-boot-docker

Executando aplicações Spring Boot no Docker

## Pré requisito
- Maven 3
- Java 8
- Docker 1.13.0+

## Preparando ambiente


```
mvn clean package dockerfile:build 
docker-compose up
```

## Documentação Swagger

```
http://localhost:8080/swagger-ui.html#/
```

## Frontend

```
Instalar http-server para rodar aplicação
Ubuntu:  npm install http-server -g
Depois basta iniciar: http-server

```

```
Se levantar o banckend primeiro, ele assumirá a porta 808
Fique atento na porta que o frontend levanrará, se a 8080 estiver ocupada ele assume a 8081
```