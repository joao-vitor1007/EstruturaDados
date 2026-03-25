package filas.filas_prioridades.desafio_fila_prioridade;

import filas.filas_prioridades.PessoaP;

public class FilaPrioridade {

    No inicio;
    No fim;

    boolean isEmpty() {
        return inicio == null && fim == null;
    }

    public void enqueue(No novoNo) {
        if (isEmpty()) {
            inicio = fim = novoNo;
            return;
        }
        if (novoNo.getPrioridade() > inicio.getPrioridade()) {
            novoNo.proximo = inicio;
            inicio = novoNo;
            return;
        }

        No atual = inicio;

        // Percorre até achar a posição correta
        while (atual.proximo != null &&
                atual.proximo.getPrioridade() >= novoNo.getPrioridade()) {
            atual = atual.proximo;
        }

        novoNo.proximo = atual.proximo;
        atual.proximo = novoNo;

        // Atualiza o fim se inseriu no final
        if (novoNo.proximo == null) {
            fim = novoNo;
        }
    }

    public void dequeue() {
        if (!isEmpty()) {
            if (inicio == fim) {
                inicio = fim = null;
            } else {
                inicio = inicio.proximo;
            }
        }
    }

    public No peek() {
        return inicio;
    }

    public String view(){
        if (isEmpty()) return "";

        String ret = "";
        No atual = inicio;

        while (atual != null){
            ret += atual.getTarefa() + "(" + atual.getPrioridade() + ") | ";
            atual = atual.proximo;
        }

        return ret;
    }
}


