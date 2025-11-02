package entity.pessoa;

public class Pessoa {
    private String nome;
    private String cpf;
    private String dataDeNascimento;
    private int idade;

    public Pessoa(String nome, String cpf, String dataDeNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
    }
    public Pessoa(String nome, String cpf, String dataDeNascimento,int idade){
        this(nome, cpf, dataDeNascimento);
        this.idade=idade;
    }
    public Pessoa(String cpf){
        this.cpf = cpf;
    }


    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }
}
