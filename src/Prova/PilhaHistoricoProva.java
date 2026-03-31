package Prova;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PilhaHistoricoProva {

    private Tarefa topo;

    public boolean isEmpty() {
        return topo == null;
    }

    public void push(Tarefa t) {
        if (!isEmpty()) {
            t.proximo = topo;
        }
        topo = t;
    }

    public Tarefa pop() {
        if (!isEmpty()) {
            Tarefa saiu = topo;
            topo = topo.proximo;
            saiu.proximo = null;

            return saiu;
        }
        return null;
    }

    public Tarefa peek() {
        if (isEmpty()) {
            return null;
        }
        return topo;
    }

    public String view() {
        if (isEmpty()) {
            return "";
        }

        Tarefa atual = topo;
        StringBuilder retorno = new StringBuilder();

        while (atual != null) {
            retorno.append("Pedido ID: ").append(atual.getIdPedido())
                    .append(" (Prioridade: ").append(atual.getPrioridade()).append(")\n");
            atual = atual.proximo;
        }

        return retorno.toString();
    }
}
