package models;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PilhaLivroTest {

    PilhaLivro pilha;

    Livro l1;
    Livro l2;
    Livro l3;

    @BeforeEach
    public void init(){
        pilha = PilhaLivro.builder().build();
        l1 = new Livro("titulo1", 100, 2010, null);
        l2 = new Livro("titulo2", 200, 2020, null);
        l3 = new Livro("titulo3", 300, 2030, null);
    }

    @Test
    @Description("Teste de inserção com pilha vazia")
    void insertEmPilhaVazia(){
        pilha.push(l1);
        pilha.push(l2);
        pilha.push(l3);
        Livro topo = pilha.peek();
        assertEquals(l3.getTitulo(), topo.getTitulo());
    }
    @Test
    @Description("teste de remoção da pilha")
    void removePilha(){
        pilha.push(l1);
        pilha.push(l2);
        pilha.push(l3);
        pilha.pop();
        Livro topo = pilha.peek();
        assertEquals(l2.getTitulo(), topo.getTitulo());
        pilha.pop();
        topo = pilha.peek();
        assertEquals(l1.getTitulo(), topo.getTitulo());


    }

    @Test
    @Description("Teste de view")
    void viewPilhaTest(){
        pilha.push(l1);
        pilha.push(l2);
        pilha.push(l3);
        String r = pilha.view();
        System.out.println(r);

        assertEquals("titulo3\ntitulo2\ntitulo1\n", r);

    }

}