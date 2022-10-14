package br.com.exerciciodois.ExercicioDois;
public class EntidadePessoa {

    private Long id;
    private String nome;
    private int idade;
    private String CPF;
    private String telefone;

    public EntidadePessoa() {
    }


    

    public EntidadePessoa(Long id, String nome, int idade, String CPF, String telefone) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.CPF = CPF;
        this.telefone = telefone;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
