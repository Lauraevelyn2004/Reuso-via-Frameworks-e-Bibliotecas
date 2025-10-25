package br.exemplo.atividade;

/**
 * Classe principal para demonstração do sistema de cadastro.
 */
public class App {
    public static void main(String[] args) {
        System.out.println("=== Sistema de Cadastro com Reuso ===\n");

        AuthService authService = new AuthService();
        CadastroService cadastroService = new CadastroService(authService);

        System.out.println("--- Teste 1: E-mail válido ---");
        cadastroService.cadastrar("usuario@exemplo.com", "senha123");
        
        System.out.println("\n--- Teste 2: E-mail inválido ---");
        cadastroService.cadastrar("email_invalido", "senha456");
        
        System.out.println("\n--- Teste 3: Senha vazia ---");
        cadastroService.cadastrar("teste@exemplo.com", "");

        System.out.println("\n--- Demonstração de Reuso do AuthService ---");
        String senha = "minhasenha";
        String hash = authService.hashSenha(senha);
        System.out.println("Hash gerado: " + hash);
        System.out.println("Senha confere? " + authService.confereSenha(senha, hash));
        System.out.println("Senha errada confere? " + authService.confereSenha("outrasenha", hash));
    }
}
