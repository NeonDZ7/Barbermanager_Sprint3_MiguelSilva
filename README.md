BarberManager — Sistema de Gestão para Barbearias

Projeto desenvolvido para o Curso de Sistema p/ Internet / Desenvolvimento Web, utilizando Java, Spring Boot, HTML, CSS e JavaScript.
O BarberManager é um sistema simples e funcional para gerenciamento de barbearias, permitindo controle de clientes, serviços e agendamentos, com backend em Java e interface web integrada.

🚀 Funcionalidades Principais
📌 Cadastro e Gerenciamento

Cadastro de clientes

Cadastro de serviços

Gerenciamento e listagem de agendamentos

📌 Backend (Java + Spring Boot)

API REST organizada em controllers, models e repositories
Persistência de dados usando Spring Data JPA
Endpoints acessados pelo frontend usando JavaScript (fetch)

📌 Frontend (HTML, CSS e JavaScript)

Interface limpa e responsiva
Consumo da API Java via JavaScript (fetch)
Páginas conectadas à lógica do backend
Separação clara entre estrutura (HTML), estilo (CSS) e requisições (JS)

🛠️ Tecnologias Utilizadas
Backend

Java 17
Spring Boot
Spring Web
Spring Data JPA
Maven
Frontend
HTML5
CSS3

JavaScript (para consumo da API)

📁 Estrutura do Projeto
Projeto_Java/barbermanager
 ├── src/main/java/...  (código fonte Java)
 ├── src/main/resources/templates  (HTML)
 ├── src/main/resources/static/css  (estilos)
 ├── src/main/resources/static/js   (lógica JS)
 └── pom.xml

▶️ Como Executar o Projeto

Instale:
Java 17
Maven
Spring Boot (executado pelo Maven)

No terminal, dentro da pasta do projeto, execute:
mvn spring-boot:run

Acesse no navegador:
http://localhost:8080
