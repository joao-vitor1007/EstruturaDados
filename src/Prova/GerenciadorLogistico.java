package Prova;

public class GerenciadorLogistico {

    private FilaPrioridadeProva filaPrioridade;
    private PilhaHistoricoProva pilhaHistorico;

    public GerenciadorLogistico() {
        this.filaPrioridade = new FilaPrioridadeProva();
        this.pilhaHistorico = new PilhaHistoricoProva();
    }

    public void receberPedido(int id, double valor, int prioridade) {
        Tarefa novaTarefa = new Tarefa(id, valor, prioridade, null);
        filaPrioridade.enqueue(novaTarefa);
    }

    public void processarProximo() {
        Tarefa tarefaProcessada = filaPrioridade.dequeue();

        if (tarefaProcessada != null) {
            pilhaHistorico.push(tarefaProcessada);
        } else {
            System.out.println("A fila de pedidos está vazia.");
        }
    }

    public void desfazerProcessamento() {
        if (pilhaHistorico.isEmpty()) {
            throw new RuntimeException("Erro: Não há processamentos para desfazer. A pilha de histórico está vazia.");
        }

        Tarefa tarefaDesfeita = pilhaHistorico.pop();
        filaPrioridade.enqueue(tarefaDesfeita);
    }

    public int contarPedidosNaFila() {
        int contador = 0;
        Tarefa atual = filaPrioridade.getInicio();

        while (atual != null) {
            contador++;
            atual = atual.getProximo();
        }

        return contador;
    }

    public double calcularValorTotalFretes() {
        double total = 0.0;

        Tarefa atualFila = filaPrioridade.getInicio();
        while (atualFila != null) {
            total += atualFila.getValorFrete();
            atualFila = atualFila.getProximo();
        }

        Tarefa atualPilha = pilhaHistorico.getTopo();
        while (atualPilha != null) {
            total += atualPilha.getValorFrete();
            atualPilha = atualPilha.getProximo();
        }

        return total;
    }
}