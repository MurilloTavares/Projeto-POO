package projeto.visao;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import projeto.modelo.Conta;
import projeto.modelo.Contas;
import projeto.modelo.Movimentacao;
import projeto.modelo.Movimentacao.Categoria;
import projeto.modelo.Movimentacao.Tipo;
import projeto.modelo.Movimentacoes;

public class Tela {
    
    Contas contas = new Contas();
    Scanner scanner = new Scanner(System.in);
    
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
        String resposta = scanner.next();
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
        String resposta = scanner.next();
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
        String resposta = scanner.next();
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
                }else if(ChronoUnit.YEARS.between(LocalDate.of(ano, mes, dia),LocalDate.now())>100){
                    System.out.println("Data fora do intervalo válido. :(");
                    System.out.println("Por favor, digite novamente uma data:");
                }else{
                    return LocalDate.of(ano, mes, dia);
                }
            }
        }
        
    }
    
    public boolean temNumero(String s){
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++){
            if (Character.isDigit(c[i])){
                return true;
            }
        }
        return false;
    }
    
    public void login(){
        while(true){
        System.out.println("---TELA DE LOGIN---");
        System.out.println("Digite:\n1 para logar.\n2 para criar uma conta.");
        System.out.print("Resposta: ");
        String resposta = scanner.next();        
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
            System.out.println("O E-mail '"+email+"' ja existe. :(");            
            if(!tentarDenovo()){
                return;
            }
            System.out.print("Por favor, digite outro E-mail: ");
            email = scanner.next();
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
        while(temNumero(nome)){
            System.out.println("Erro. O nome não pode conter números.");
            System.out.print("Por favor digite um nome válido: ");
            nome = scanner.next();
        }
        System.out.print("Sobrenome: ");
        String sobrenome = scanner.next();
        while(temNumero(sobrenome)){
            System.out.println("Erro. O sobrenome não pode conter números.");
            System.out.print("Por favor digite um sobrenome válido: ");
            sobrenome = scanner.next();
        }
        System.out.println("Nascimento:");
        LocalDate nascimento = getData();
        char sexo = 0;
        boolean erro;
        do{            
            erro = false;
            System.out.print("Sexo(Digite M para MASCULINO ou F para FEMININO): ");
            String resposta = scanner.next();
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
        while(true){
        System.out.println("---Tela Inicial---");
        System.out.println("Digite:");
        System.out.println("1 - para cadastrar uma movimentacao.");
        System.out.println("2 - para gerenciar finanças.");
        System.out.println("3 - para gerenciar perfil.");
        System.out.println("4 - para sair");
        String resposta = scanner.next();
        while(!resposta.equals("1")&&!resposta.equals("2")&&!resposta.equals("3")&&!resposta.equals("4")){
            System.out.println("Resposta invalida. Por favor digite uma das opções:");
            System.out.println("1 - para cadastrar uma movimentacao.");
            System.out.println("2 - para gerenciar finanças.");
            System.out.println("3 - para gerenciar perfil.");
            System.out.println("4 - para sair");
            resposta = scanner.next();
        }
        switch(resposta){
            case "1":
                cadastrarMovimentacao(c);
                break;
            case "2":
                gerenciarFinancas(c.getMovs());
                break;
            case "3":
                gerenciarPerfil(c);
                break;
            case "4":
                return ;
        }
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
    
    public void gerenciarFinancas(Movimentacoes movs){
        while(true){
        System.out.println("---GERENCIAR FINANCAS---");
        System.out.println("Digite:");
        System.out.println("1 - para visualizar movimentacoes.");
        System.out.println("2 - para excluir uma movimentacao.");
        System.out.println("3 - para atualizar uma movimentacao.");
        System.out.println("4 - para voltar.");
        String resposta = scanner.next();
        while(!resposta.equals("1")&&!resposta.equals("2")&&!resposta.equals("3")&&!resposta.equals("4")){
            System.out.println("Resposta invalida. Por favor digite uma das opções:");
            System.out.println("1 - para visualizar movimentacoes.");
            System.out.println("2 - para excluir uma movimentacao.");
            System.out.println("3 - para atualizar uma movimentacao.");
            System.out.println("4 - para voltar.");
            resposta = scanner.next();
        }
        switch(resposta){
            case "1":
                visualizarMovs(movs);
                break;
            case "2":
                excluirMov(movs);
                break;
            case "3":
                atualizarMov(movs);
                break;
            case "4":
                return;
        }
        }        
    }
    
    public void visualizarMovs(Movimentacoes movs){
        System.out.println("---Movimentacoes---");
        System.out.println(movs.getMovs());
    }
    public void excluirMov(Movimentacoes movs){
        
    }
    public void atualizarMov(Movimentacoes movs){
        
    }
    
    public void gerenciarPerfil(Conta c){
        while(true){
        System.out.println("---GERENCIAR PERFIL---");
        System.out.println("Perfil Atual:");
        System.out.println(c);
        System.out.println("Qual campo deseja modificar?");
        System.out.println("1 - Nome.");
        System.out.println("2 - Sobrenome.");
        System.out.println("3 - Nascimento.");
        System.out.println("4 - sexo.");
        System.out.println("5 - Para modificar a senha.");
        System.out.println("6 - voltar.");
        String resposta = scanner.next();
        while(!resposta.equals("1")&&!resposta.equals("2")&&!resposta.equals("3")&&!resposta.equals("4")&&!resposta.equals("5")&&!resposta.equals("6")){
            System.out.println("Resposta invalida. Por favor digite uma das opções:");
            System.out.println("1 - Para modificar o nome.");
            System.out.println("2 - Para modificar o sobrenome.");
            System.out.println("3 - Para modificar o nascimento.");
            System.out.println("4 - Para modificar o sexo.");
            System.out.println("5 - Para modificar a senha.");
            System.out.println("6 - voltar.");
            resposta = scanner.next();
        }
        switch(resposta){
            case "1":
                System.out.print("Digite o novo nome: ");
                String nome = scanner.next();
                while(temNumero(nome)){
                    System.out.println("Erro. O nome não pode conter números.");
                    System.out.print("Por favor digite um nome válido: ");
                    nome = scanner.next();
                }
                c.setNome(nome);
                System.out.println("Seu nome agora é "+c.getNome()+".");
                break;
            case "2":
                System.out.print("Digite o novo sobrenome: ");
                String sobrenome = scanner.next();
                while(temNumero(sobrenome)){
                    System.out.println("Erro. O sobrenome não pode conter números.");
                    System.out.print("Por favor digite um sobrenome válido: ");
                    sobrenome = scanner.next();
                }
                c.setSobrenome(sobrenome);
                System.out.println("Seu sobrenome agora é "+c.getSobrenome()+".");
                break;
            case "3":
                System.out.println("Digite a nova data de nascimento: ");
                LocalDate nascimento = getData();
                c.setNascimento(nascimento);
                System.out.println("Sua data de nascimento agora é "+c.getNascimento()+".");
                break;
            case "4":
                boolean erro;
                char sexo = c.getSexo();
                do{            
                    erro = false;
                System.out.print("Digite o novo sexo(Digite M para MASCULINO ou F para FEMININO): ");
                String resp = scanner.next();
                    switch (resp) {
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
                c.setSexo(sexo);
                System.out.println("Seu novo sexo agora é "+c.getSexo()+".");
                break;
            case "5":
                System.out.println("Digite sua senha antiga: ");
                String senha = scanner.next();
                while(!c.getSenha().equals(senha)){
                    System.out.println("Senha incorreta.");
                    if(!tentarDenovo()){
                    return;
                    }else{
                        System.out.println("Digite sua senha antiga: ");
                        senha = scanner.next();
                    }
                }
                    System.out.println("Digite sua nova senha: ");
                    String novasenha = scanner.next();
                    System.out.println("Confirme sua nova senha: ");
                    String confnovasenha = scanner.next();
                    while(!novasenha.equals(confnovasenha)){
                        System.out.println("Erro. As senhas não são iguais.");
                        if(!tentarDenovo()){
                            return;
                        }else{
                            System.out.println("Digite sua nova senha: ");
                            novasenha = scanner.next();
                            System.out.println("Confirme sua nova senha: ");
                            confnovasenha = scanner.next();
                        }
                    }
                c.setSenha(novasenha);
                System.out.println("Sua nova senha agora é: "+c.getSenha());
                break;
            case "6":
                return;
        }
        }    
               
    }
}
