package projeto.visao;

import java.util.Scanner;
import projeto.modelo.Conta;

public class App {    
    
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        Tela tela = new Tela();
        
        int r = tela.login();
        Conta c = null;
        if(r==2){
            c = tela.cadastroConta();
            c = tela.cadastroPerfil(c);
            System.out.println(c);
        }
        
        
        
        
                
        
        
        
        
    }
}
