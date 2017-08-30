package projeto.modelo;

import java.time.LocalDate;

public class MovEntrada extends Movimentacao{

    //---construtor---
    public MovEntrada(String descricao, LocalDate data, float valor) {
        super(descricao, data, valor);
    }
    
    @Override
    public String toString() {
        return "Movimentação ENTRADA{" + "descricao=" + getDescricao() + ", data=" + getDataFormat() + ", valor=" + getValor() + '}';
    }
    
}
