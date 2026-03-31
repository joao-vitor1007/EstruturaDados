package Prova;

public class FilaPrioridadeProva {

    private Tarefa inicio;
    private Tarefa fim;

    public boolean isEmpty() {
        return inicio == null;
    }

    public void enqueue(Tarefa novaTarefa) {
        if (isEmpty()) {
            inicio = fim = novaTarefa;
            return;
        }

        if (novaTarefa.getPrioridade() > inicio.getPrioridade()) {
            novaTarefa.proximo = inicio;
            inicio = novaTarefa;
            return;
        }
        Tarefa atual = inicio;

        while (atual.proximo != null &&
                atual.proximo.getPrioridade() >= novaTarefa.getPrioridade()) {
            atual = atual.proximo;
        }
        novaTarefa.proximo = atual.proximo;
        atual.proximo = novaTarefa;


        if (novaTarefa.proximo == null) {
            fim = novaTarefa;
        }
    }

    public Tarefa dequeue() {
        if (isEmpty()) {
            return null;
        }

        Tarefa removida = inicio;

        if (inicio == fim) {
            inicio = fim = null;
        } else {
            inicio = inicio.proximo;
        }


        removida.proximo = null;

        return removida;
    }


    public Tarefa getInicio() {
        return inicio;
    }
}