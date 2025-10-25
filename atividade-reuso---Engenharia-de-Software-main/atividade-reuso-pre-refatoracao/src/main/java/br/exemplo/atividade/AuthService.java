package br.exemplo.atividade;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AuthService {

    private final BCryptPasswordEncoder passwordEncoder;

    public AuthService() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public boolean isEmailValido(String email) {
        if (email == null || email.isBlank()) {
            return false;
        }
        return EmailValidator.getInstance().isValid(email);
    }

    public String hashSenha(String senha) {
        if (senha == null || senha.isBlank()) {
            throw new IllegalArgumentException("Senha não pode ser nula ou vazia.");
        }
        return passwordEncoder.encode(senha);
    }

    public boolean confereSenha(String senha, String hash) {
        if (senha == null || senha.isBlank() || hash == null || hash.isBlank()) {
            return false;
        }
        return passwordEncoder.matches(senha, hash);
    }
}
