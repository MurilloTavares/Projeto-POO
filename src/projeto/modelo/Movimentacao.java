package projeto.modelo;

import java.time.LocalDate;

public class Movimentacao {
    
    //---enums---
    private enum Tipo{
        ENTRADA(1), SAIDA(2);
        
        private int valor;
        Tipo(int valor){
            this.valor = valor;
        }
        
    }
    private enum Categoria{
        ALIMENTACAO(1), CARTAO_CREDITO(2), DISPESAS_DOMESTICAS(3), SAUDE(4), PESSOAL(5), OUTROS(6);
        
        private int valor;
        Categoria(int valor){
            this.valor = valor;
        }
        
    }
    
    //---atributos---
    private String descricao;
    private LocalDate data;
    private float valor;
    private Tipo tipo;
    private Categoria categoria;
    
    //---construtor---
    public Movimentacao(String descricao, LocalDate data, float valor, Tipo tipo, Categoria categoria) {
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    //---getters---
    public String getDescricao() {
        return descricao;
    }
    public LocalDate getData() {
        return data;
    }
    public float getValor() {
        return valor;
    }
    public Tipo getTipo() {
        return tipo;
    }
    public Categoria getCategoria() {
        return categoria;
    }

    //---setters---
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    
}
