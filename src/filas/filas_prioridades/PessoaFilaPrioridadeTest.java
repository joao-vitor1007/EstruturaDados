package filas.filas_prioridades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaFilaPrioridadeTest {

        PessoaFilaPrioridade fila;
        PessoaP p1;
        PessoaP p2;
        PessoaP p3;

        @BeforeEach
        void init() {
            fila = new PessoaFilaPrioridade();

            p1 = new PessoaP("João", 1, null);
            p2 = new PessoaP("Pedro", 5, null);
            p3 = new PessoaP("Maria", 3, null);
        }

        @Test
        void insere() {
            fila.enqueue(p1);
            fila.enqueue(p2);
            fila.enqueue(p3);

            // Maior prioridade vem primeiro
            assertEquals("Pedro", fila.inicio.getNome());
            assertEquals("João", fila.fim.getNome());
        }

        @Test
        void remove() {
            fila.enqueue(p1);
            fila.enqueue(p2);
            fila.enqueue(p3);

            fila.dequeue();
            assertEquals("Maria", fila.inicio.getNome());
            assertEquals("João", fila.fim.getNome());

            fila.dequeue();
            assertEquals("João", fila.inicio.getNome());
            assertEquals("João", fila.fim.getNome());

            fila.dequeue();
            assertTrue(fila.isEmpty());
        }

        @Test
        void viewTest() {
            fila.enqueue(p1); // prioridade 1
            fila.enqueue(p2); // prioridade 5
            fila.enqueue(p3); // prioridade 3

            assertEquals("Pedro(5) | Maria(3) | João(1) | ", fila.view());
        }
    }
