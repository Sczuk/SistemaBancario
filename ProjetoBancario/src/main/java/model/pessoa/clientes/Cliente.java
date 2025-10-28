package model.pessoa.clientes;

import model.conta.Conta;
import model.pessoa.Pessoa;

import java.util.List;

public class Cliente extends Pessoa {
    private List<Conta> contas;
    private int id;

    public Cliente(String nome, String cpf, String dataDeNascimento,int idade, int id) {
        super(nome, cpf, dataDeNascimento,idade);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "\nnome: "+getNome()+
                "\ncpf: "+getCpf()+
                "\ndata de nascimento: "+getDataDeNascimento()+
                "\nid: "+getId();
    }
}
