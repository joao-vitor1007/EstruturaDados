package filas.filas_prioridades.desafio_fila_prioridade;

import filas.filas_prioridades.PessoaP;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class No {
    public String tarefa;
    public double valor;
    public int prioridade;
    public No proximo;

}


