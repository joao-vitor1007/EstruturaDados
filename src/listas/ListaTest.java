package listas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaTest {

    Lista lista;

    @BeforeEach
    void init(){
        lista = new Lista();
    }

    @Test
    void addTest(){
        assertTrue(lista.isEmpty());
        lista.add(new No("A", null, null));
        lista.add(new No("B", null, null));
        lista.add(new No("C", null, null));
        lista.add(new No("D", null, null));
    }

    @Test
    void removeTest(){
        assertTrue(lista.isEmpty());
        lista.add(new No("A"));
        lista.add(new No("B"));
        lista.add(new No("C"));
        lista.add(new No("D"));
        lista.remove(2);
        assertEquals("A|B|D|", lista, lista.view());
    }

    @Test
    void addEspecificoTest(){
        assertTrue(lista.isEmpty());
        lista.add(new No("A"));
        lista.add(new No("B"));
        lista.add(new No("C"));
        lista.add(new No("D"));
        lista.addEspecifico(new No("X"), 2);
        assertEquals("A|B|D|", lista, lista.view());
    }
}