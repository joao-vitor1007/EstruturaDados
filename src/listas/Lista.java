package listas;

public class Lista {

    int qtd = 0;
    No pontoInicial;

    boolean isEmpty() {
        return qtd == 0;
    }
    void addEspecifico(No novo, int pos) {
        if (pos < 0) {
            throw new IllegalArgumentException("Posição inválida");
        }

        if (isEmpty() || pos == 0) {
            novo.proximo = pontoInicial;
            pontoInicial = novo;
            return;
        }

        No atual = pontoInicial;
        int index = 0;
        while (atual != null && index < pos - 1) {
            atual = atual.proximo;
            index++;
        }

        if (atual == null) {
            throw new IndexOutOfBoundsException("Posição fora da lista");
        }

        novo.proximo = atual.proximo;
        atual.proximo = novo;
    }

    void add(No novo) {
        if (isEmpty()) {
            pontoInicial = novo;

        }else{
            No ultimo = buscaUltimo();
        }

        qtd++;
    }

    void remove(int pos){
        if(!isEmpty() && pos <= qtd){
           No remover = buscarPos(pos);
           if(remover == null)
               return;
           if (remover.anterior != null)
               remover.anterior.proximo = remover.proximo;
           if (remover.proximo != null)
               remover.proximo.anterior = remover.anterior;
           if (remover == pontoInicial)
               pontoInicial = remover.proximo;
           remover.anterior.proximo = remover.proximo;
           remover.proximo.anterior = remover.anterior;
           qtd --;
        }
    }

    String view(){
        String ret = "";
        No atual = pontoInicial;
        for(int i=0; i<qtd; i++){
            ret += atual.valor + "|";
            atual = atual.proximo;
        }
        return ret;
    }

    private No buscaUltimo(){
        No ultimo = pontoInicial;
        for (int i=0; i< qtd; i++){
            ultimo = ultimo.proximo;
        }
        return ultimo;
    }

    private No buscarPos(int pos){
        No noPos = pontoInicial;
        for(int i=0; i<pos; i++){
            noPos = noPos.proximo;

        }
        return noPos;
    }
}
