package projeto.modelo;

import java.util.ArrayList;
import java.util.List;

public class Contas {
    
    private final List<Conta> contas;
    
    //---construtor---
    public Contas() {
        contas = new ArrayList<>();
    }
    
    //---getter---
    public List<Conta> getContas() {
        return contas;
    }
    
    //---Metodos---
    //Adiciona Conta caso nao exista
    public boolean addConta(Conta c){
        if (contas.contains(c)){
            return false;
        }else{
            return contas.add(c);
        }
    }
    
    //Retorna Conta
    public Conta getConta(String email){
        for(Conta c : contas){
            if(c.getEmail().equals(email)){
                return c;
            }
        }
        return null;
    }
    
    //Retorna index da Conta
    public int getIndex(Conta c){
        return contas.indexOf(c);
    }
    public int getIndex(String email){
        return contas.indexOf(getConta(email));
    }
    
    //Atualiza Conta
    public boolean updateConta(Conta antiga, Conta nova){
        int i = getIndex(antiga);
        if(i<0){
            return false;
        }else{
            contas.set(i, nova);
            return true;
        }
    }
    public boolean updateConta(int index, Conta nova){
        if(index<0 || index>=contas.size()){
            return false;
        }else{
            contas.set(index, nova);
            return true;
        }
    }
    
    //Deleta Conta
    public boolean deleteConta(Conta c){
        return contas.remove(c);
    }
    public boolean deleteConta(int index){
        if(index<0 || index>=contas.size()){
            return false;
        }else{
            contas.remove(index);
            return true;
        }
        
    }
    
    
    
}
