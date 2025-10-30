package service.serviceCliente;

import model.pessoa.Pessoa;
import model.pessoa.clientes.ClienteMenor;
import repository.repositoryCliente.ClienteMenorRepository;

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