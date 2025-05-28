# b2b-orders-api

## Descrição
API para gerenciamento de usuários, clientes e autenticação com JWT usando Spring Boot.

## Tecnologias
- Java 17
- Spring Boot 3
- Spring Security
- JWT
- PostgreSQL
- Redis (futuro uso)

## Entidades
- User: id, email, senha, roles
- Role: roles do sistema (ADMIN, SALES, CUSTOMER)
- Customer: cliente básico

## Autenticação
- Login via e-mail e senha
- Geração de JWT com validade 1 hora
- Refresh token (em implementação futura)

## Como rodar
- Configure o banco PostgreSQL e Redis (via Docker recomendado)
- Ajuste `application.properties` com dados do banco
- Rode a aplicação
- Use o endpoint POST `/api/auth/login` para obter token JWT

## Testes
- Teste endpoints protegidos usando o token JWT no header `Authorization`

