package br.exemplo.atividade;

public class CadastroService {

    private final AuthService auth;

    public CadastroService(AuthService auth) {
        this.auth = auth;
    }

    public boolean cadastrar(String email, String senha) {
        // Reuso: validação de e-mail via AuthService
        if (!auth.isEmailValido(email)) {
            System.out.println("E-mail inválido!");
            return false;
        }

        try {
            String hash = auth.hashSenha(senha);
            System.out.println("Usuário cadastrado com sucesso!");
            System.out.println("E-mail: " + email);
            System.out.println("Hash gerado: " + hash);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            return false;
        }
    }
}
