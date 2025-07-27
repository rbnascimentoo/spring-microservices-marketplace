# User Service

Este serviço é responsável pelo gerenciamento de usuários no ecossistema Marketplace. Ele segue os princípios da arquitetura limpa, separando domínio, aplicação, infraestrutura e apresentação.

## Principais funcionalidades
- Cadastro de usuários
- Consulta, atualização e remoção de usuários
- Exposição de API REST documentada via Swagger/OpenAPI
- Persistência em banco PostgreSQL
- Métricas expostas para Prometheus

## Estrutura do projeto
- **domain/model**: Entidades e regras de negócio
- **domain/port/in**: Interfaces de casos de uso
- **domain/port/out**: Interfaces para dependências externas
- **application/service**: Serviços de aplicação
- **infrastructure/adapter/in**: Controllers REST
- **infrastructure/adapter/out**: Implementações técnicas (DAO, Repository)
- **dto**: Objetos de transferência de dados
- **exception**: Exceções customizadas
- **config**: Configurações de segurança, beans, etc.

## Como rodar
1. Configure o banco PostgreSQL (pode usar Docker Compose)
2. Ajuste o `application.properties` conforme seu ambiente
3. Execute o serviço:
   ```bash
   ./mvnw spring-boot:run
   ```

## Endpoints principais
- `POST /users` - Cadastro de usuário
- `GET /users` - Listagem de usuários
- `GET /users/{id}` - Consulta por ID
- `PUT /users/{id}` - Atualização
- `DELETE /users/{id}` - Remoção

## Documentação e métricas
- Swagger UI: [`/swagger-ui.html`](http://localhost:8080/swagger-ui.html)
- OpenAPI: `/v3/api-docs`
- Prometheus: `/actuator/prometheus`
- Health: `/actuator/health`

## Segurança
- O endpoint de cadastro de usuário e a documentação Swagger estão liberados para acesso público.
- Os demais endpoints podem exigir autenticação conforme configuração do Spring Security.

---

> Dúvidas ou sugestões? Contribua ou abra uma issue!

