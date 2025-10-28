package service.serviceCliente;


import model.pessoa.Pessoa;
import model.pessoa.clientes.Cliente;
import repository.repositoryCliente.ClienteRepository;


public class ClienteService {

    public static boolean cadastrarCliente(Pessoa pessoa) {
        //adicionar a validaçao do cpf
        pessoa.setIdade(ClienteValidationService.getIdade(pessoa.getDataDeNascimento()));
        boolean cadastrado = ClienteRepository.createCliente(pessoa);
        return cadastrado;
    }

    public static boolean deletarCliente(int id){
        if(ClienteRepository.getCliente(id)==null) throw new NullPointerException("Id nao correspondente a nenhum Cliente");
        boolean deletado = ClienteRepository.deleteCliente(id);
        return deletado;
    }

    public static Cliente getCliente(int id){
        if(ClienteRepository.getCliente(id)==null) throw new NullPointerException("Id nao correspondente a nenhum Cliente");
        Cliente cliente = ClienteRepository.getCliente(id);
        return cliente;
    }

    public static boolean updateClienteName(String nome, int id){
        if(ClienteRepository.getCliente(id)==null) throw new NullPointerException("Id nao correspondente a nenhum Cliente");
        boolean clienteAtualizado = ClienteRepository.updateClienteName(nome,id);
        return clienteAtualizado;
    }
}
