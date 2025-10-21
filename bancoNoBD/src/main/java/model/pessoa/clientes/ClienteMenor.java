package model.pessoa.clientes;

import model.conta.Conta;
import model.pessoa.Pessoa;

public class ClienteMenor extends Pessoa {
    private Conta conta;
    private int id;

    public ClienteMenor(String nome, String cpf, String dataDeNascimento, int id) {
        super(nome, cpf, dataDeNascimento);
        this.id = id;
    }
}
