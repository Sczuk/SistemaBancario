package entity.pessoa.clientes;

import entity.pessoa.Pessoa;

public class Cliente extends Pessoa{
    private int id;

    public Cliente(String cpf) {
        super(cpf);
    }

    public Cliente(String nome, String cpf, String dataDeNascimento, int idade, int id) {
        super(nome, cpf, dataDeNascimento, idade);
        this.id = id;
    }

    public Cliente(String nome, String cpf, String dataDeNascimento,int idade) {
        super(nome, cpf, dataDeNascimento,idade);
    }

    public Cliente(String nome, String cpf, String dataDeNascimento){
        super(nome,cpf, dataDeNascimento);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
