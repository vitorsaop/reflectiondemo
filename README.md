# Reflection Demo

Projeto Java para estudo e demonstração prática do uso de Reflection, com foco em transformar entidades em DTOs de forma genérica, sem dependência de frameworks externosm, ou seja, utilizando apenas a API da linguagem Java.

## Objetivo

Explorar o potencial técnico do Reflection em Java, ilustrando sua aplicação em cenários de transformação de objetos.

## Funcionalidades

- Conversão automática de entidades para DTOs usando Reflection.
- Implementação genérica, desacoplada de nomes de pacotes ou sufixos.
- Testes automatizados com JUnit.
- Exemplo prático de uso em um serviço.

## Estrutura

- `model/`: Entidades de domínio (ex: Pessoa, Endereco)
- `dto/`: Data Transfer Objects
- `reflexao/`: Classe utilitária para transformação via Reflection
- `service/`: Serviço de exemplo utilizando a transformação
- `repository/`: Repositório simulado para obtenção de dados

## Estudos realizados

- Manipulação de campos e instâncias via Reflection
- Boas práticas para desacoplamento e generalização de código
- Testes unitários para validação de cenários de sucesso e erro
- Diferenças entre entidades e DTOs
- Limitações e cuidados ao usar Reflection

## Como executar

1. Clone o repositório
2. Compile com Maven:  
   `mvn clean install`
3. Execute a classe principal:  
   `TesteReflexao.java`
4. Rode os testes:  
   `mvn test`

---

Projeto para fins didáticos e experimentação.
