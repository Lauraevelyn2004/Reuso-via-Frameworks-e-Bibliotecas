package br.exemplo.atividade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes automatizados que comprovam o reuso de AuthService
 * e validam o comportamento do CadastroService.
 */
public class CadastroServiceTest {

    private CadastroService cadastroService;
    private AuthService authService;

    @BeforeEach
    public void setUp() {
        authService = new AuthService();
        cadastroService = new CadastroService(authService);
    }

    @Test
    @DisplayName("Deve retornar false ao cadastrar com e-mail inválido")
    public void testCadastroComEmailInvalido() {
        String emailInvalido = "email_invalido";
        String senha = "senha123";

        boolean resultado = cadastroService.cadastrar(emailInvalido, senha);

        assertFalse(resultado, "Cadastro deve falhar com e-mail inválido");
    }

    @Test
    @DisplayName("Deve cadastrar com sucesso usando e-mail e senha válidos")
    public void testCadastroComEmailESenhaValidos() {
        String emailValido = "usuario@exemplo.com";
        String senhaValida = "senha123";

        boolean resultado = cadastroService.cadastrar(emailValido, senhaValida);

        assertTrue(resultado, "Cadastro deve ser bem-sucedido com dados válidos");
    }

    @Test
    @DisplayName("Deve gerar hash BCrypt não vazio ao cadastrar")
    public void testGeracaoDeHashBCrypt() {
        String senha = "senhaSegura123";

        String hash = authService.hashSenha(senha);

        assertNotNull(hash, "Hash não deve ser nulo");
        assertFalse(hash.isEmpty(), "Hash não deve ser vazio");
        assertTrue(hash.startsWith("$2a$") || hash.startsWith("$2b$"), 
                   "Hash deve ser BCrypt válido");
    }

    @Test
    @DisplayName("Deve validar e-mail usando Apache Commons Validator")
    public void testReusoValidacaoEmailCommons() {
        assertTrue(authService.isEmailValido("usuario@exemplo.com"));
        assertTrue(authService.isEmailValido("teste.usuario@dominio.com.br"));
        assertFalse(authService.isEmailValido("email_invalido"));
        assertFalse(authService.isEmailValido("@exemplo.com"));
        assertFalse(authService.isEmailValido("usuario@"));
        assertFalse(authService.isEmailValido(""));
        assertFalse(authService.isEmailValido(null));
    }

    @Test
    @DisplayName("Deve conferir senha corretamente usando BCrypt")
    public void testReusoConferenciaSenhaBCrypt() {
        String senha = "minhaSenha123";
        String hash = authService.hashSenha(senha);

        assertTrue(authService.confereSenha(senha, hash));
        assertFalse(authService.confereSenha("senhaErrada", hash));
    }

    @Test
    @DisplayName("Deve lançar exceção ao tentar gerar hash de senha vazia")
    public void testHashSenhaVazia() {
        assertThrows(IllegalArgumentException.class, 
                     () -> authService.hashSenha(""));
    }

    @Test
    @DisplayName("Deve lançar exceção ao tentar gerar hash de senha nula")
    public void testHashSenhaNula() {
        assertThrows(IllegalArgumentException.class, 
                     () -> authService.hashSenha(null));
    }

    @Test
    @DisplayName("Deve demonstrar reuso completo de bibliotecas consolidadas")
    public void testReusoCompletoBibliotecas() {
        String email = "teste@dominio.com.br";
        String senha = "senha456";

        boolean emailValido = authService.isEmailValido(email);
        assertTrue(emailValido);

        String hash = authService.hashSenha(senha);
        assertNotNull(hash);
        
        boolean senhaConfere = authService.confereSenha(senha, hash);
        assertTrue(senhaConfere);

        boolean cadastroOk = cadastroService.cadastrar(email, senha);
        assertTrue(cadastroOk);
    }
}
