package projeto.visao;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;
import projeto.modelo.Conta;
import projeto.modelo.Contas;

public class Tela {
    
    Contas contas = new Contas();
    Scanner scanner = new Scanner(System.in);
    String resposta;
    
    private int scInt(){
        while (!scanner.hasNextInt()){
            System.out.println("Por favor, Digite um numero.");
            scanner.next();
        }
        return scanner.nextInt();
    }
    
    public int login(){
        System.out.println("---TELA DE LOGIN---");
        System.out.println("Digite:\n1 para logar.\n2 para criar uma conta.");
        System.out.print("Resposta: ");resposta = scanner.next();        
        while(!resposta.equals("1") && !resposta.equals("2")){
            System.out.println("Valor invalido. :(");
            System.out.print("Por favor, digite novamente sua resposta: ");
            resposta = scanner.next();
        }
        System.out.println("");
        if(resposta.equals("1")){ return 1; }
        else{ return 2; }
    }
    
    public Conta cadastroConta(){
        System.out.println("---CRIAR UMA CONTA---");
        
        //Cadastrar E-mail
        System.out.print("E-mail: ");
        String email = scanner.next();
        while(contas.getIndex(email)!= -1){
            System.out.println("O E-mail '"+resposta+"' ja existe :(");
            System.out.print("Por favor, digite outro E-mail: ");
        }
        
        //Cadastrar Senha
        System.out.print("Senha: ");
        String senha = scanner.next();
        System.out.print("Confirme sua senha: ");
        String confirm = scanner.next();
        while(!senha.equals(confirm)){
            System.out.println("Senha errada :(");
            System.out.print("Por favor, digite novamente sua senha: ");
            senha = scanner.next();
            System.out.print("Confirme novamente sua senha: ");
            confirm = scanner.next();
        }
        
        Conta conta = new Conta(email,senha);
        contas.addConta(conta);
        System.out.println("Parabens! Sua conta foi criada com sucesso.\n");
        
        return conta;
    }
    
    public Conta cadastroPerfil(Conta conta){
        System.out.println("---CRIAR PERFIL---");
        System.out.print("Nome: ");
        String nome = scanner.next();
        System.out.print("Sobrenome: ");
        String sobrenome = scanner.next();
        int dia;
        int mes;
        int ano;
        boolean erro;
        System.out.println("Nascimento:");
        do{ 
            erro = false;
            System.out.print("Dia: ");
            dia = scInt();
            System.out.print("Mes: ");
            mes = scInt();
            System.out.print("Ano: ");
            ano = scInt();
            try{
                LocalDate nascimento = LocalDate.of(ano, mes, dia);
            }catch(Exception e){
                System.out.println("Data invalida. :(");
                System.out.println("Por favor, digite novamente a data de nascimento:");
                erro = true;
            }
            if(!erro && LocalDate.of(ano, mes, dia).isAfter(LocalDate.now())){
                System.out.println("Data invalida. :(");
                System.out.println("Por favor, digite novamente a data de nascimento:");
                erro = true;                
            }
        }while(erro);
        LocalDate nascimento = LocalDate.of(ano, mes, dia);
        char sexo = 0;
        do{            
            erro = false;
            System.out.print("Sexo(Digite M para MASCULINO ou F para FEMININO): ");
            resposta = scanner.next();
            switch (resposta) {
                case "M":
                case "m":
                    sexo = 'M';
                    break;
                case "F":
                case "f":
                    sexo = 'F';
                    break;
                default:
                    System.out.println("Valor invalido. :(");
                    System.out.println("Por favor, digite novamente seu sexo.");
                    erro = true;
                    break;
            }
        }while(erro);
        
        System.out.println("Parabens "+nome+". Seu perfil agora esta completo. :)");
        System.out.println("Selecione a opcao 'Gerenciar Perfil' caso deseje alterar dados do seu perfil.\n");
        conta.setNome(nome);
        conta.setSobrenome(sobrenome);
        conta.setNascimento(nascimento);
        conta.setSexo(sexo);
        
        System.out.println(conta);
        
        return conta;
    }
    
}
