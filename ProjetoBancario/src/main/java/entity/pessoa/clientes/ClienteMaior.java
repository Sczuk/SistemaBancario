package entity.pessoa.clientes;

import entity.conta.Conta;
import entity.pessoa.Pessoa;

import java.util.List;

public class ClienteMaior extends Cliente{
    private List<Conta> contas;

    public ClienteMaior(String nome, String cpf, String dataDeNascimento, int idade, int id) {
        super(nome, cpf, dataDeNascimento,idade,id);
    }
    public ClienteMaior(String nome, String cpf, String dataDeNascimento, int idade) {
        super(nome, cpf, dataDeNascimento,idade);
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
