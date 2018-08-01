# javaee projetofinal

## Instruções para executar o código
```
# Inicializar rabbitmq
docker run -d --hostname rabbitmq --name rabbitmq-management -p 15672:15672 -p 5671:5671 -p 5672:5672 rabbitmq:management

# Inicializar a aplicação
mvn spring-boot:run
```

### Configurar email
Alterar dentro da classe com.javaee.rodrigoandrades.projeto_final.listeners.VendaListener método enviarEmail as variáveis:
final String fromEmail
<br>
final String password 


## Instruções para testar as funcionalidades
### Acessar o seguinte link [http://localhost:8085/swagger-ui.html](http://localhost:8085/swagger-ui.html)

## Lista de bibliotecas utilizadas e suas funções
* Spring Boot(Aplicação Java)
* Banco de dados H2(Persistência de dados)
* javax.mail(envio de email)
* springfox/swagger(documentação da API)
* RabbitMQ(Processar transações de forma assíncrona)