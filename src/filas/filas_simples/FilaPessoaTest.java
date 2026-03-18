package filas.filas_simples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilaPessoaTest {

    FilaPessoa fila;
    Pessoa p1;
    Pessoa p2;
    Pessoa p3;

    @BeforeEach
    void init(){
        fila =  new FilaPessoa();
        p1 = new Pessoa("João", null);
        p2 = new Pessoa("Pedro", null);
        p3 = new Pessoa("Maria", null);
    }

    @Test
    void insere(){
        fila.enqueue(p1);
        fila.enqueue(p2);
        fila.enqueue(p3);
        assertEquals("João", fila.inicio.getNome());
        assertEquals("Maria", fila.fim.getNome());
    }

    @Test
    void remove(){
        fila.enqueue(p1);
        fila.enqueue(p2);
        fila.enqueue(p3);
        fila.dequeue();
        assertEquals("Pedro", fila.inicio.getNome());
        assertEquals("Maria", fila.fim.getNome());
        fila.dequeue();
        assertEquals("Maria", fila.inicio.getNome());
        assertEquals("Maria", fila.fim.getNome());

        fila.dequeue();
       assertTrue(fila.isEmpty());
    }
    @Test
    void viewTest(){
        fila.enqueue(p2);
        fila.enqueue(p3);
        fila.enqueue(p1);
        assertEquals("Pedro | Maria | João | ", fila.view());
    }
}