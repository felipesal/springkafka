# Apache Kafka com Spring

## Repositório de estudo do curso da udemy dobre kafka aplicado com Spring

https://www.udemy.com/course/apache-kafka-com-spring-direto-ao-ponto/

## Executando projeto:
Para executar, basta entrar na pasta e executar o comando:
```
docker-compose up -d
```

## Utlizando o projeto:
Utilizar o postman e bater na url `localhost:8080/peoples` e lançar um post com o payload:
```
{
  "name":"Pedro",
  "cpf":"11111111101",
  "books":[
    "livro1",
    "livro2",
    "livro3"
  ]
}
```

Nesse momento a aplicação vai mandar uma mensagem para o consumer(que está no mesmo projeto) e vai persistir os dados no banco de dados H2. Para conferir,
bater na URL `localhost:8080/h2-console` e verificar os dados persistidos.
