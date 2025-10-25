# 🧩 Atividade 11 - Engenharia de Software II  
## Reuso via Frameworks e Bibliotecas  

### 📘 Descrição do Projeto  
Este projeto foi desenvolvido como parte da disciplina **Engenharia de Software II**, com o objetivo de aplicar os conceitos de **reuso de software** utilizando **frameworks e bibliotecas consolidadas**.  

A proposta consiste em refatorar um serviço de cadastro de usuários, substituindo códigos manuais e repetitivos de **validação de e-mail** e **criptografia de senha** por componentes reutilizáveis implementados em uma classe dedicada chamada `AuthService`.  
Essa abordagem promove **melhor segurança**, **qualidade** e **padronização** do código, além de demonstrar como frameworks como **Apache Commons Validator** e **Spring Security Crypto** podem ser integrados para agilizar o desenvolvimento.

O projeto inclui os seguintes componentes principais:
- `AuthService` → responsável pela validação de e-mails e geração/verificação de hash de senhas usando BCrypt.  
- `CadastroService` → executa o cadastro de usuários reutilizando os métodos de `AuthService`.  
- `CadastroServiceTest` → contém testes automatizados com **JUnit 5**, verificando os cenários de cadastro, reuso e segurança.  
- `App` → executa uma simulação prática no console mostrando o funcionamento do sistema.

---

### ⚙️ Tecnologias Utilizadas  
- **Java 17**  
- **Maven**  
- **Apache Commons Validator 1.7**  
- **Spring Security Crypto 5.7.11**  
- **JUnit 5 (Spring Boot Starter Test)**  

---

### ✅ Estrutura do Projeto  
```
atividade-reuso-pre-refatoracao/
├── pom.xml
├── README.md
├── src/
│   ├── main/
│   │   └── java/
│   │       └── br/exemplo/atividade/
│   │           ├── App.java
│   │           ├── AuthService.java
│   │           └── CadastroService.java
│   └── test/
│       └── java/
│           └── br/exemplo/atividade/
│               └── CadastroServiceTest.java
├── target/

```
---


---

## ⚙️ Tecnologias/Dependências

- Java 17
- Maven
- Apache Commons Validator 1.7
- Spring Security Crypto 5.7.11
- JUnit 5

---

## 📄 Benefícios do Reuso

O reuso de componentes e bibliotecas consolidadas eleva a produtividade e reduz o tempo de desenvolvimento, evitando a duplicidade de código em diferentes partes do sistema. Além disso, a manutenção se torna mais simples e menos propensa a erros, já que alterações feitas em módulos reutilizados afetam todo o sistema de maneira uniforme. Por fim, o uso de soluções testadas e padronizadas aumenta a segurança, consistência e qualidade do software entregue.

---

##  Autor

**Nome:** Laura Evelyn Neves Oliveira  
**Disciplina:** Engenharia de Software II  
**Instituição:** IFSULDEMINAS - Campus machado 
**Data:** Outubro/2025
