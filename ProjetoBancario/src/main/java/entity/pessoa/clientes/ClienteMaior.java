package entity.pessoa.clientes;

import entity.conta.Conta;
import entity.pessoa.Pessoa;

import java.util.List;

public class ClienteMaior extends Pessoa {
    private List<Conta> contas;
    private int id;

    public ClienteMaior(String nome, String cpf, String dataDeNascimento, int idade, int id) {
        super(nome, cpf, dataDeNascimento,idade);
        this.id = id;
    }
    public ClienteMaior(String nome, String cpf, String dataDeNascimento, int idade) {
        super(nome, cpf, dataDeNascimento,idade);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "\nnome: "+getNome()+
                "\ncpf: "+getCpf()+
                "\ndata de nascimento: "+getDataDeNascimento()+
                "\nIdade: "+getIdade()+
                "\nid: "+getId();
    }
}
