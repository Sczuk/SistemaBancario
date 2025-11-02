package entity.pessoa.clientes;

import entity.conta.Conta;
import entity.pessoa.Pessoa;

public class ClienteMenor extends Pessoa {
    private Conta conta;
    private int id;

    public ClienteMenor(String nome, String cpf, String dataDeNascimento,int idade, int id) {
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
                "\nid: "+getId()+
                "\nidade: "+getIdade();
    }
}
