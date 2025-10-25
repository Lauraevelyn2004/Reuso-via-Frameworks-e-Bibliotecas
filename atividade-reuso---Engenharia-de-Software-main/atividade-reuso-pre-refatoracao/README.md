# Atividade — Reuso via Frameworks e Bibliotecas

## Dicas
- Injete `AuthService` via construtor em `CadastroService`.
- Não altere o contrato externo do método `cadastrar`.
- Dependências a adicionar **após** a refatoração:

```xml
<dependency>
  <groupId>commons-validator</groupId>
  <artifactId>commons-validator</artifactId>
  <version>1.7</version>
</dependency>
<dependency>
  <groupId>org.springframework.security</groupId>
  <artifactId>spring-security-crypto</artifactId>
</dependency>
```