package projeto.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Movimentacoes {
    
    private final List<Movimentacao> movs;
    
    //---construtor---
    public Movimentacoes(){
        movs = new ArrayList<>();
    }
        
    //---Metodos---
    //Ordenar Movimentacoes
    public void sort(){
        Collections.sort(movs, (Movimentacao m, Movimentacao n) -> m.getData().compareTo(n.getData()));
    }
    
    //Adiciona Movimentacao e Ordena
    public boolean addMov(Movimentacao m){
        boolean b = movs.add(m);
        if (b){ sort(); }
        return b;
    }
    
    //getters
    public int getIndex(Movimentacao m){
        return movs.indexOf(m);
    }    
    public Movimentacao getMov(int index){
        if(index<0 || index>=movs.size()){
            return null;
        }
        return movs.get(index);
    }    
    public List<Movimentacao> getMovs() {
        return movs;
    }
    public List<Movimentacao> getMovs(LocalDate inicio, LocalDate fim){
        List<Movimentacao> temp = new ArrayList<>();
        for(Movimentacao m: movs){
            if(m.getData().isEqual(inicio) || m.getData().isEqual(fim) ||
            (m.getData().isAfter(inicio) && m.getData().isBefore(fim))){
                temp.add(m);
            }
        }
        return temp;
    }
    
    //Atualiza Movimentacao
    public boolean updateMov(int index, Movimentacao nova){
        if(index<0 || index>=movs.size()){
            return false;
        }else{
            movs.set(index, nova);
            sort();
            return true;
        }
    }
    public boolean updateMov(Movimentacao movAntiga, Movimentacao movNova){
        int i = getIndex(movAntiga);
        return updateMov(i,movNova);
    }
    
    //Deleta Movimentacao
    public boolean deleteMov(Movimentacao m){
        boolean b = movs.remove(m);
        if(b){ sort(); }
        return b;
    }
    public boolean deleteMov(int index){
        if(index<0 || index>=movs.size()){
            return false;
        }else{
            movs.remove(index);
            sort();
            return true;
        }
    }
    
    
    
}
