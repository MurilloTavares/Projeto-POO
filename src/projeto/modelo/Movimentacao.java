package projeto.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Movimentacao {
    
    //---atributos---
    private String descricao;
    private LocalDate data;
    private float valor;
    
    //---construtor---
    public Movimentacao(String descricao, LocalDate data, float valor) {
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
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
    public String getDataFormat(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/LLLL/yyyy");
        return data.format(formatter);
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

}
