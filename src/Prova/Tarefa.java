package Prova;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tarefa {
  public int idPedido;
  public double valorFrete;
  public int prioridade;
  public Tarefa proximo;

}
