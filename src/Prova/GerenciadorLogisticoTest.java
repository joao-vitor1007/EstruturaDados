package Prova;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GerenciadorLogisticoTest {
    GerenciadorLogistico tarefa;
    Tarefa t1;
    Tarefa t2;
    Tarefa t3;
    Tarefa t4;

    @BeforeEach
    void init(){
        tarefa = new GerenciadorLogistico();
    }
    @Test
    void testeDesfazerVoltaParaPosicaoCorreta() {
       tarefa.receberPedido(1, 50.0, 1);
       tarefa.receberPedido(2, 100.0, 5);
       tarefa.receberPedido(3, 75.0, 3);

       tarefa.processarProximo();
        assertEquals(2,tarefa.contarPedidosNaFila());

       tarefa.desfazerProcessamento();
        assertEquals(3,tarefa.contarPedidosNaFila());

       tarefa.processarProximo();
        assertEquals(2,tarefa.contarPedidosNaFila());
    }

    @Test
    void testeSomaTotalValoresSimultaneamente() {
       tarefa.receberPedido(1, 50.0, 1);
       tarefa.receberPedido(2, 100.0, 5);
       tarefa.receberPedido(3, 75.0, 3);

       tarefa.processarProximo();

        double totalFretes =tarefa.calcularValorTotalFretes();

        assertEquals(225.0, totalFretes);
    }

    @Test
    void testeErroAoDesfazerEmPilhaVazia() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
           tarefa.desfazerProcessamento();
        });

        assertTrue(exception.getMessage().contains("A pilha de histórico está vazia"));
    }
}

