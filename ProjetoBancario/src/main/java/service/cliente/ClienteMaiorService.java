package service.cliente;


import entity.pessoa.Pessoa;
import entity.pessoa.clientes.Cliente;
import entity.pessoa.clientes.ClienteMaior;
import repository.cliente.ClienteMaiorRepository;


public class ClienteMaiorService {

    public static boolean cadastrarCliente(Cliente cliente) {
        return ClienteMaiorRepository.createCliente(new ClienteMaior(cliente.getNome(), cliente.getCpf(), cliente.getDataDeNascimento(),ClienteValidationService.getIdade(cliente.getDataDeNascimento())));
    }

    public static boolean deletarCliente(int id){
        if(ClienteMaiorRepository.getCliente(id)==null) throw new IllegalArgumentException("Id nao correspondente a nenhum Cliente");
        boolean deletado = ClienteMaiorRepository.deleteCliente(id);
        return deletado;
    }

    public static ClienteMaior getCliente(int id){
        if(ClienteMaiorRepository.getCliente(id)==null) throw new IllegalArgumentException("Id nao correspondente a nenhum Cliente");
        ClienteMaior clienteMaior = ClienteMaiorRepository.getCliente(id);
        return clienteMaior;
    }

    public static boolean updateClienteName(ClienteMaior clienteMaior, int id){
        if(ClienteMaiorRepository.getCliente(id)==null) throw new IllegalArgumentException("Id nao correspondente a nenhum Cliente");
        boolean clienteAtualizado = ClienteMaiorRepository.updateClienteName(clienteMaior, id);
        return clienteAtualizado;
    }
}
