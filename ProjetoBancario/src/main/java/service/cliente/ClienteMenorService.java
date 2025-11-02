package service.cliente;

import entity.pessoa.Pessoa;
import entity.pessoa.clientes.ClienteMenor;
import repository.cliente.ClienteMenorRepository;

public class ClienteMenorService {

    public static boolean cadastrarClienteMenor(Pessoa pessoa){
        pessoa.setIdade(ClienteValidationService.getIdade(pessoa.getDataDeNascimento()));
        boolean clienteCriado = ClienteMenorRepository.createCliente(pessoa);
        return clienteCriado;
    }

    public static boolean deletarCliente(int id){
        if(ClienteMenorRepository.getCliente(id)==null) throw new IllegalArgumentException("Id nao correspondente a nenhum Cliente");
        boolean delatado = ClienteMenorRepository.deleteCliente(id);
        return delatado;
    }

    public static ClienteMenor getCliente(int id){
        if(ClienteMenorRepository.getCliente(id)==null) throw new IllegalArgumentException("Id nao correspondente a nenhum Cliente");
        ClienteMenor clienteMenor = ClienteMenorRepository.getCliente(id);
        return clienteMenor;
    }

    public static boolean updateClienteName(ClienteMenor cliente, int id){
        if(ClienteMenorRepository.getCliente(id)==null) throw new IllegalArgumentException("Id nao correspondente a nenhum Cliente");
        boolean clienteAtualizado = ClienteMenorRepository.updateClienteName(cliente, id);
        return clienteAtualizado;
    }
}