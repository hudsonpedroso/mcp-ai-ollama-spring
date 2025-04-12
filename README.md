# MCP Spring - Integração com LLama 2 Local via Ollama

## Sobre o Projeto

MCP Spring é uma aplicação Spring Boot que proporciona uma interface simples para comunicação com modelos de linguagem de grande porte (LLMs) executados localmente através do Ollama. Esta implementação específica integra-se com o modelo Llama 2, permitindo enviar prompts e receber respostas via API REST.

## Pré-requisitos

- Java 21 ou superior
- Maven
- [Ollama](https://ollama.ai/) instalado e configurado no ambiente Windows
- Modelo Llama 2 instalado no Ollama (`ollama pull llama2`)

## Configuração

A aplicação utiliza as seguintes configurações, definidas no `application.properties`:

```properties
spring.application.name=mcp-spring

# Configurações da API
ai.provider.api.url=http://localhost:11434/api/generate
ai.provider.api.model=llama2

# Configurações da aplicação
server.port=8080
```

## Estrutura do Projeto

O projeto segue uma arquitetura em camadas:

- **Controller**: Expõe endpoints REST para interação com o cliente
- **Service**: Implementa a lógica de negócios
- **Client**: Gerencia a comunicação com a API Ollama
- **Model**: Define os objetos de transferência de dados (DTOs)
- **Config**: Configura beans e propriedades da aplicação

## Endpoints

### Chat

```
POST /api/chat
```

**Request Body:**
```json
{
  "prompt": "Olá, como você está?"
}
```

**Response:**
```json
{
  "response": "Olá! Estou bem, obrigado por perguntar. Como posso ajudá-lo hoje?"
}
```

## Como Executar

1. Certifique-se de que o Ollama está em execução:
```
ollama serve
```

2. Verifique se o modelo Llama 2 está instalado:
```
ollama list
```
Se não estiver presente, instale-o:
```
ollama pull llama2
```

3. Execute a aplicação Spring:
```
./mvnw spring-boot:run
```

4. Faça requisições para o endpoint `/api/chat` usando qualquer cliente HTTP (Postman, cURL, etc.)

## Detalhes de Implementação

A aplicação utiliza:
- Spring Boot para criar a API REST
- RestTemplate para comunicação HTTP com o Ollama
- Lombok para reduzir a verbosidade do código
- JUnit e Mockito para testes

## Limitações Conhecidas

- A implementação atual é uma versão inicial
- Não suporta streaming de respostas
- Não há gerenciamento de histórico de conversas
- Suporte apenas para o modelo configurado nos properties
