package service.serviceCliente;


import model.pessoa.Pessoa;
import model.pessoa.clientes.ClienteMaior;
import repository.repositoryCliente.ClienteMaiorRepository;


public class ClienteMaiorService {

    public static boolean cadastrarCliente(Pessoa pessoa) {
        return ClienteMaiorRepository.createCliente(new ClienteMaior(pessoa.getNome(), pessoa.getCpf(), pessoa.getDataDeNascimento(),ClienteValidationService.getIdade(pessoa.getDataDeNascimento())));
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
