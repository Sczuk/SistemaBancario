package model.pessoa.clientes;

import model.conta.Conta;
import model.pessoa.Pessoa;

import java.util.List;

public class Cliente extends Pessoa {
    private List<Conta> contas;
    private int id;

    public Cliente(String nome, String cpf, String dataDeNascimento, int id) {
        super(nome, cpf, dataDeNascimento);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "nome: "+getNome()+
                "cpf: "+getCpf()+
                "data de nascimento: "+getDataDeNascimento()+
                "id: "+getId();
    }
}
