package br.com.karenrodrigues.model;

public class JavaBeans {
    private String id;
    private String nome;
    private String profissao;
    private int idade;

    public JavaBeans() {
    }

    public JavaBeans (String id, String nome, String profissao, int idade) {
        this.id = id;
        this.nome = nome;
        this.profissao = profissao;
        this.idade = idade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
