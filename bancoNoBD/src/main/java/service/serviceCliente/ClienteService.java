package service.serviceCliente;


import model.pessoa.Pessoa;
import model.pessoa.clientes.Cliente;
import repository.repositoryCliente.ClienteRepository;

import java.util.function.Predicate;

public class ClienteService {

    public static boolean cadastrarCliente(Pessoa pessoa) {
        boolean cadastrado = ClienteRepository.createCliente(pessoa);
        return cadastrado;
    }

    public static boolean deletarCliente(int id){
        if(ClienteRepository.getCliente(id).equals(null)) throw new NullPointerException("Id nao correspondente a nenhum Cliente");
        boolean deletado = ClienteRepository.deleteCliente(id);
        return deletado;
    }

    public static Cliente getCliente(int id){
        if(ClienteRepository.getCliente(id).equals(null)) throw new NullPointerException("Id nao correspondente a nenhum Cliente");
        return ClienteRepository.getCliente(id);
    }

    public static boolean updateClienteName(Cliente cliente, int id){
        if(ClienteRepository.getCliente(id).equals(null)) throw new NullPointerException("Id nao correspondente a nenhum Cliente");
        boolean clienteAtualizado = ClienteRepository.updateClienteName(cliente,id);
        return clienteAtualizado;
    }
}
