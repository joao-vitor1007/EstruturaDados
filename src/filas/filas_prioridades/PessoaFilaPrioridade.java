package filas.filas_prioridades;

public class PessoaFilaPrioridade {

    PessoaP inicio;
    PessoaP fim;

    boolean isEmpty(){
        return inicio == null && fim == null;
    }

    public void enqueue(PessoaP novaPessoa){
        if (isEmpty()) {
            inicio = fim = novaPessoa;
            return;
        }

        // Se a nova pessoa tem maior prioridade que o início
        if (novaPessoa.getPrioridade() > inicio.getPrioridade()) {
            novaPessoa.proximo = inicio;
            inicio = novaPessoa;
            return;
        }

        PessoaP atual = inicio;

        // Percorre até achar a posição correta
        while (atual.proximo != null &&
                atual.proximo.getPrioridade() >= novaPessoa.getPrioridade()) {
            atual = atual.proximo;
        }

        novaPessoa.proximo = atual.proximo;
        atual.proximo = novaPessoa;

        // Atualiza o fim se inseriu no final
        if (novaPessoa.proximo == null) {
            fim = novaPessoa;
        }
    }

    public void dequeue(){
        if (!isEmpty()) {
            if (inicio == fim) {
                inicio = fim = null;
            } else {
                inicio = inicio.proximo;
            }
        }
    }

    public PessoaP peek(){
        return inicio;
    }

    public String view(){
        if (isEmpty()) return "";

        String ret = "";
        PessoaP atual = inicio;

        while (atual != null){
            ret += atual.getNome() + "(" + atual.getPrioridade() + ") | ";
            atual = atual.proximo;
        }

        return ret;
    }
}