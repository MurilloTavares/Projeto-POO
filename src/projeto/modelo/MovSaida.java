package projeto.modelo;

import java.time.LocalDate;

public class MovSaida extends Movimentacao{
    
    //---enum---
    public enum Categoria{
        ALIMENTACAO(1), CARTAO_CREDITO(2), DISPESAS_DOMESTICAS(3), SAUDE(4), PESSOAL(5), OUTROS(6);
        
        private int valor;
        Categoria(int valor){
            this.valor = valor;
        }        
    }
    
    //---atributos---
    private Categoria categoria;

    //---construtor---
    public MovSaida(String descricao, LocalDate data, float valor,Categoria categoria) {
        super(descricao, data, valor);
        this.categoria = categoria;
    }
    
    //---getters e setters---
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Movimentação SAIDA{" + "descricao=" + getDescricao() + ", data=" + getDataFormat() + ", valor=" + getValor() + ", categoria=" + categoria +'}';
    }
    
}
