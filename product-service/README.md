# Product Service

Este serviço é responsável pelo gerenciamento de produtos no ecossistema Marketplace, seguindo os princípios da arquitetura limpa.

## Funcionalidades
- Cadastro de produtos
- Consulta, atualização e remoção de produtos
- API REST documentada via Swagger/OpenAPI
- Persistência em banco PostgreSQL
- Métricas expostas para Prometheus

## Estrutura do projeto
- **domain/model**: Entidade Product
- **domain/port/in**: Interface de casos de uso (ProductUseCase)
- **domain/port/out**: Interface de persistência (ProductRepositoryPort)
- **application/service**: Serviço de aplicação (ProductService)
- **infrastructure/adapter/in**: Controller REST (ProductController)
- **infrastructure/adapter/out**: Adapter e repositório JPA
- **dto**: Objetos de transferência de dados
- **config**: Configurações de segurança, Swagger, etc.

## Como rodar
1. Configure o banco PostgreSQL (pode usar Docker Compose)
2. Ajuste o `application.properties` conforme seu ambiente
3. Execute o serviço:
   ```bash
   ./mvnw spring-boot:run
   ```

## Endpoints principais
- `POST /products` - Cadastro de produto
- `GET /products` - Listagem de produtos
- `GET /products/{id}` - Consulta por ID
- `PUT /products/{id}` - Atualização
- `DELETE /products/{id}` - Remoção

## Documentação e métricas
- Swagger UI: [`/swagger-ui.html`](http://localhost:8080/swagger-ui.html)
- OpenAPI: `/v3/api-docs`
- Prometheus: `/actuator/prometheus`
- Health: `/actuator/health`

## Segurança
- O endpoint de cadastro de produto e a documentação Swagger estão liberados para acesso público.
- Os demais endpoints podem exigir autenticação conforme configuração do Spring Security.

---

> Dúvidas ou sugestões? Contribua ou abra uma issue!

