# BarberManager – Sprint 2

Este projeto é um sistema inicial de gerenciamento de clientes e agendamentos para uma barbearia, desenvolvido utilizando **Spring Boot**.  
A Sprint 2 tem como objetivo entregar um conjunto mínimo de funcionalidades funcionando de ponta a ponta.

---

## 🚀 Funcionalidades Entregues na Sprint 2

### ✅ Cadastro simples de Clientes
- Criação de novos clientes via endpoint.
- Armazenamento no banco de dados H2.
- Retorno listável e funcional.

### 📌 Endpoints funcionais
**Clientes**
- `POST /clientes` – cadastrar cliente  
- `GET /clientes` – listar clientes

---

## 🗂️ Estrutura do Projeto

A estrutura atual utilizada no desenvolvimento é:

```
src/main/java/com/miguelsilva/barbermanager/barbermanager/
├── controller
│   ├── ClienteController.java
│   └── AgendamentoController.java
├── model
│   ├── Cliente.java
│   └── Agendamento.java
├── repository
│   ├── ClienteRepository.java
│   └── AgendamentoRepository.java
├── service
│   └── ClienteService.java
└── BarbermanagerApplication.java
```

---

## 🛢️ Banco de Dados

- Banco utilizado: **H2** (em memória)  
- Não requer instalação  
- Carrega automaticamente ao iniciar o projeto  
- É apagado automaticamente ao parar a aplicação (útil para testes)

---

## ▶️ Como Executar o Projeto

1. Abra o projeto no **VS Code**.
2. Abra o arquivo `BarbermanagerApplication.java`.
3. Clique em **Run** (ícone ▶️ no canto superior da classe).
4. A API estará disponível em:  
   **http://localhost:8080/**

---

## 🔎 Testando os Endpoints

### ➤ Listar clientes  
http://localhost:8080/clientes

### ➤ Cadastrar cliente  
Requisição POST para:  
http://localhost:8080/clientes

Body (JSON):
```json
{
  "nome": "Miguel",
  "telefone": "99999-9999",
  "email": "miguel@gmail.com"
}
```

---

## 📝 Observações Importantes

- A Sprint 2 entrega um módulo completo funcionando (**Clientes**).  
- O módulo de **Agendamentos** foi criado, mas será implementado na Sprint 3.  
- Projeto organizado em camadas:
  - **Model**
  - **Repository**
  - **Service**
  - **Controller**
- Segue boas práticas de separação de responsabilidades.  
- Utiliza um banco de dados simples e fácil de testar (**H2**).
