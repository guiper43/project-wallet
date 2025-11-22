# Project Wallet

## Objetivo
O **Project Wallet** é uma simulação de carteira digital desenvolvida com foco em boas práticas, utilizando **Java 21** e **Spring Boot 3.5.7**.  
Serve como base de estudos, treinamento técnico e portfólio pessoal.

## Tecnologias Utilizadas
- Java 21
- Spring Boot 3.5.7
- Maven
- Tomcat (embutido)

## Funcionalidades

### Client — (CRUD completo implementado e testado via REST Client)
Campos do cliente:
- `id`
- `name`
- `balance`

Endpoints implementados:
- **POST /clients** → criar cliente
- **GET /clients** → listar todos
- **GET /clients/{id}** → buscar por ID
- **PUT /clients/{id}** → atualizar cliente
- **DELETE /clients/{id}** → deletar cliente

### Transfer — (Ainda não iniciado)
Campos previstos:
- `originId`
- `destinationId`
- `amount`

## Regras de Negócio
- Não transferir para o mesmo `id`.
- O valor da transferência deve ser positivo.
- A conta de origem deve possuir saldo suficiente.
- Respostas HTTP adequadas:
    - **400** → dados inválidos
    - **404** → cliente não encontrado
    - **500** → erro interno

## Estrutura do Projeto

- **model** → classes de domínio (Client, Transfer)
- **dto** → objetos de entrada e saída (DTOs)
- **repository** → armazenamento em memória via `Map`
- **service** → regras de negócio do CRUD
- **controller** → endpoints REST
- **utils/validations** → validações (id, name, balance)
- **utils/mapper** → `ClientMapper` (Model ↔ DTO)

## Execução
1. Certifique-se de ter o **Java 21** instalado.
2. Execute o projeto pela classe principal (`main`) no IntelliJ.
3. A aplicação estará disponível em: **http://localhost:8080**

## Status do Projeto — Atualizado
- Arquitetura consolidada
- Tomcat funcionando corretamente
- **CRUD completo de Client implementado**
- **Endpoints testados e validados via REST Client**
- Validações em `utils/validations`
- Mapper em `utils/mapper`
- Testes unitários pendentes
- Módulo de Transfer ainda não iniciado  
