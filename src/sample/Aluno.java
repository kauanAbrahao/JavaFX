package sample;

import java.time.LocalDate;

public class Aluno {

    private long id;
    private String ra;
    private String nome;
    private LocalDate nascimento;

    public Aluno(){
        this.id = id++;
    }

    public Long getId(){
        return this.id;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
}
