# Project Wallet

## Objetivo
O Project Wallet tem o objetivo de simular de forma simplificada uma carteira digital de pagamentos, permitindo transferências entre contas de clientes.  
O projeto foi **arquitetado** com foco em boas práticas de desenvolvimento utilizando Java 21 e Spring Boot 3.5.7, servindo como base para estudo e portfólio técnico. O desenvolvimento está em andamento.

## Tecnologias Utilizadas
- Java 21
- Spring Boot 3.5.7
- Maven
- Tomcat (embutido)

## Funcionalidades
### Client
- Cadastro de clientes contendo os campos:
    - id
    - name
    - balance

### Transfer (a desenvolver)
- Realização de transferências entre contas de clientes utilizando:
    - originId
    - destinationId
    - amount

## Regras de Negócio
- Não é permitido transferir valores entre o mesmo identificador (id).
- O valor da transferência deve ser maior que zero.
- Não é permitido transferir um valor superior ao saldo disponível na conta de origem.
- O sistema deve validar os principais erros HTTP e retornar respostas adequadas:
    - **400** → Requisição inválida (valores incorretos ou dados ausentes)
    - **404** → Client não encontrado
    - **500** → Erro interno no servidor

## Estrutura do Projeto
O projeto está organizado em pacotes conforme boas práticas do Spring Boot:

- **model** → classes de domínio (Client, Transfer).
- **dto** → objetos de transferência de dados entre camadas.
- **repository** → manipulação e persistência dos clientes em memória usando `Map`.
- **service** → regras de negócio e validações.
- **controller** → endpoints REST para cadastro e, futuramente, transferências.

## Execução
1. Certifique-se de ter Java 21 instalado.
2. Execute o projeto diretamente pela classe principal (`main`) no IntelliJ ou através do comando "Run" da IDE.
3. A aplicação estará disponível em `http://localhost:8080`.

## Status do Projeto
- Arquitetura inicial estruturada
- Servidor Tomcat configurado e funcionando
- **Validações do objeto Client concluídas**
- **Criação de clientes implementada**
- **Testes pendentes**
- Desenvolvimento das operações de transferência ainda não iniciado  
