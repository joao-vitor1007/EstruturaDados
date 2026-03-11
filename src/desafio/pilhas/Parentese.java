package desafio.pilhas;

import lombok.*;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Parentese {
    private String valor;
    Parentese proximo;
}
