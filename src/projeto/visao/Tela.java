package projeto.visao;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;
import projeto.modelo.Conta;
import projeto.modelo.Contas;
import projeto.modelo.Movimentacao;
import projeto.modelo.Movimentacao.Categoria;
import projeto.modelo.Movimentacao.Tipo;

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
    private float scFloat(){
        while (!scanner.hasNextFloat()){
            System.out.println("Por favor, Digite um numero valido.");
            scanner.next();
        }
        return scanner.nextFloat();
    }
    private Tipo getTipo(){
        System.out.println("Tipo:");
        System.out.println("Digite:\n1 - para entrada.\n2 - para saida.");
        resposta = scanner.next();
        while(!resposta.equals("1")&&!resposta.equals("2")){
            System.out.println("Valor invalido.");
            System.out.println("Digite:\n1 - para Entrada.\n2 - para Saida.");
            resposta = scanner.next();
        }
        if(resposta.equals("1")){
            return Tipo.ENTRADA;
        }else{
            return Tipo.SAIDA;
        }
    }
    private Categoria getCategoria(){
        System.out.println("Categoria:");
        System.out.println("Digite:\n1 - para Alimentacao.\n2 - para Cartao de credito.\n3 - para Dispesas domesticas.\n4 - para Saude.\n5 - para Pessoal.\n6 - para Outros.");
        resposta = scanner.next();
        while(!resposta.equals("1")&&!resposta.equals("2")&&!resposta.equals("3")&&!resposta.equals("4")&&!resposta.equals("5")&&!resposta.equals("6")){
            System.out.println("Valor invalido.");
            System.out.println("Digite:\n1 - para Alimentacao.\n2 - para Cartao de credito.\n3 - para Dispesas domesticas.\n4 - para Saude.\n5 - para Pessoal.\n6 - para Outros.");
            resposta = scanner.next();
        }
        switch(resposta){
                case "1": return Categoria.ALIMENTACAO;
                case "2": return Categoria.CARTAO_CREDITO;
                case "3": return Categoria.DISPESAS_DOMESTICAS;
                case "4": return Categoria.SAUDE;
                case "5": return Categoria.PESSOAL;
                default : return Categoria.OUTROS;
        }      
    }
    
        
    private boolean tentarDenovo(){
        System.out.println("Deseja tentar novamente? S / N");
        resposta = scanner.next();
        while(!resposta.equalsIgnoreCase("S") && !resposta.equalsIgnoreCase("N")){
            System.out.println("Resposta invalida. Por favor digite 'S' para sim e 'N' para nao.");
            resposta = scanner.next();
        }
        if(resposta.equalsIgnoreCase("S")){
            return true;
        }else{
            return false;
        }
        
    }
    private LocalDate getData(){
        int dia;
        int mes;
        int ano;
        boolean erro;
        while(true){ 
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
                System.out.println("Por favor, digite novamente uma data:");
                erro = true;
            }
            if(!erro){
                if(LocalDate.of(ano, mes, dia).isAfter(LocalDate.now())){
                    System.out.println("Data invalida. :(");
                    System.out.println("Por favor, digite novamente uma data:");
                }else{
                    return LocalDate.of(ano, mes, dia);
                }
            }
        }
        
    }
    
    public void login(){
        while(true){
        System.out.println("---TELA DE LOGIN---");
        System.out.println("Digite:\n1 para logar.\n2 para criar uma conta.");
        System.out.print("Resposta: ");resposta = scanner.next();        
        while(!resposta.equals("1") && !resposta.equals("2")){
            System.out.println("Valor invalido. :(");
            System.out.print("Por favor, digite novamente sua resposta: ");
            resposta = scanner.next();
        }
        System.out.println("");
        if(resposta.equals("1")){ logar(); }
        else{ cadastroConta(); }        
        }
    }
    
    public void cadastroConta(){
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
        cadastroPerfil(conta);
    }
    
    public void cadastroPerfil(Conta conta){
        System.out.println("---CRIAR PERFIL---");
        System.out.print("Nome: ");
        String nome = scanner.next();
        System.out.print("Sobrenome: ");
        String sobrenome = scanner.next();
        System.out.println("Nascimento:");
        LocalDate nascimento = getData();
        char sexo = 0;
        boolean erro;
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
    }
    
    public void logar(){
        System.out.println("---Logar---");
        System.out.print("E-mail: ");
        String email = scanner.next();
        System.out.print("Senha: ");
        String senha = scanner.next();
        while(contas.getConta(email, senha)==null){
            System.out.println("E-mail ou senha invalida.");
            if(!tentarDenovo()){
                return;
            }System.out.print("E-mail: ");
            email = scanner.next();
            System.out.print("Senha: ");
            senha = scanner.next();            
        }
        inicial(contas.getConta(email, senha));
    }
    
    public void inicial(Conta c){
        System.out.println("---Tela Inicial---");
        System.out.println("Digite:");
        System.out.println("1 - para cadastrar uma movimentacao.");
        System.out.println("2 - para gerenciar finanças.");
        System.out.println("3 - para gerenciar perfil.");
        System.out.println("4 - para sair");
        resposta = scanner.next();
        while(!resposta.equals("1")&&!resposta.equals("2")&&!resposta.equals("3")&&!resposta.equals("4")){
            System.out.println("Resposta invalida. Por favor digite uma das opções:");
            System.out.println("1 - para cadastrar uma movimentacao.");
            System.out.println("2 - para gerenciar finanças.");
            System.out.println("3 - para gerenciar perfil.");
            System.out.println("4 - para sair");
            resposta = scanner.next();
        }
        switch(resposta){
            case "1": cadastrarMovimentacao(c);
        }
    }

    public void cadastrarMovimentacao(Conta c){
        System.out.println("---Cadastrar Movimentacao---");
        System.out.println("Descricao: ");
        String desc = scanner.next();
        System.out.println("Data: ");
        LocalDate data = getData();
        System.out.println("Valor: ");
        float valor = scFloat();
        Tipo tipo = getTipo();
        Categoria categoria = getCategoria();
        
        Movimentacao m = new Movimentacao(desc,data,valor,tipo,categoria);
        System.out.println("Nova Movimentacao:");
        System.out.println(m);
        c.getMovs().addMov(m);
        
    }
}
