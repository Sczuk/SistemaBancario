package service.serviceCliente;


import model.pessoa.Pessoa;
import model.pessoa.clientes.Cliente;
import repository.repositoryCliente.ClienteMaiorRepository;


public class ClienteMaiorService {

    public static boolean cadastrarCliente(Pessoa pessoa) {
        pessoa.setIdade(ClienteValidationService.getIdade(pessoa.getDataDeNascimento()));
        boolean cadastrado = ClienteMaiorRepository.createCliente(pessoa);
        return cadastrado;
    }

    public static boolean deletarCliente(int id){
        if(ClienteMaiorRepository.getCliente(id)==null) throw new IllegalArgumentException("Id nao correspondente a nenhum Cliente");
        boolean deletado = ClienteMaiorRepository.deleteCliente(id);
        return deletado;
    }

    public static Cliente getCliente(int id){
        if(ClienteMaiorRepository.getCliente(id)==null) throw new IllegalArgumentException("Id nao correspondente a nenhum Cliente");
        Cliente cliente = ClienteMaiorRepository.getCliente(id);
        return cliente;
    }

    public static boolean updateClienteName(String nome, int id){
        if(ClienteMaiorRepository.getCliente(id)==null) throw new IllegalArgumentException("Id nao correspondente a nenhum Cliente");
        boolean clienteAtualizado = ClienteMaiorRepository.updateClienteName(nome,id);
        return clienteAtualizado;
    }
}
