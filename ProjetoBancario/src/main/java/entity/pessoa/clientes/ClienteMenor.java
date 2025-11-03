package entity.pessoa.clientes;

import entity.conta.Conta;

public class ClienteMenor extends Cliente {
    private Conta conta;

    public ClienteMenor(String nome, String cpf, String dataDeNascimento,int idade, int id) {
        super(nome,cpf,dataDeNascimento,idade,id);
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
