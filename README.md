# javaee projetofinal

## Instruções para executar o código
```
# Inicializar rabbitmq
docker run -d --hostname rabbitmq --name rabbitmq-management -p 15672:15672 -p 5671:5671 -p 5672:5672 rabbitmq:management

# Inicializar a aplicação
mvn spring-boot:run
```


## Instruções para testar as funcionalidades
### Acessar o seguinte link [http://localhost:8085/swagger-ui.html](http://localhost:8085/swagger-ui.html)

