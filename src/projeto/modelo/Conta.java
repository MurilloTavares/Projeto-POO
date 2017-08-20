package projeto.modelo;

import java.time.LocalDate;

public class Conta {
    
    private final String email;
    private String senha;
    
    private String nome;
    private String sobrenome;
    private LocalDate nascimento;
    private char sexo;

    public Conta(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
}
