package desafio;

import static org.junit.jupiter.api.Assertions.*;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PilhaParenteseTest {

    PilhaParentese pilha;

    Parentese abre;
    Parentese fecha;

    @BeforeEach
    public void init() {
        pilha = PilhaParentese.builder().build();
        abre = new Parentese("(", null);
        fecha = new Parentese(")", null);
    }

    @Test
    @Description("Ver se está fechando os parenteses")
    void parenteseTest() {

        String texto = "(())";

        if (texto.length() > 0 && texto.charAt(0) == ')') {
            assertFalse(true); // falha no teste
        }

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);

            if (c == '(') {
                pilha.push(new Parentese("(", null));
            }
            else if (c == ')') {
                if (pilha.isEmpty()){
                    assertFalse( true);
                }
                pilha.pop();
            }
        }

        assertTrue(pilha.isEmpty());
    }
}