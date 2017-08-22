package projeto.modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Conta {
    
    private final String email;
    private String senha;
    
    private String nome;
    private String sobrenome;
    private LocalDate nascimento;
    private char sexo;
    
    private Movimentacoes movs;

    public Conta(String email, String senha) {
        this.email = email;
        this.senha = senha;
        movs = new Movimentacoes();
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
    public Movimentacoes getMovs(){
        return movs;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.email);
        hash = 53 * hash + Objects.hashCode(this.senha);
        hash = 53 * hash + Objects.hashCode(this.nome);
        hash = 53 * hash + Objects.hashCode(this.sobrenome);
        hash = 53 * hash + Objects.hashCode(this.nascimento);
        hash = 53 * hash + this.sexo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Conta other = (Conta) obj;
        if (this.sexo != other.sexo) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.sobrenome, other.sobrenome)) {
            return false;
        }
        if (!Objects.equals(this.nascimento, other.nascimento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Conta{" + "email=" + email + ", senha=" + senha + ", nome=" + nome + ", sobrenome=" + sobrenome + ", nascimento=" + nascimento + ", sexo=" + sexo + '}';
    }
    
    
    
}
