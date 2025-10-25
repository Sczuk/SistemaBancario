package service.serviceCliente;

import model.pessoa.Pessoa;
import model.pessoa.clientes.ClienteMenor;
import repository.repositoryCliente.ClienteMenorRepository;

public class ClienteMenorService {

    //terminar tudo aqui

    public static boolean cadastrarClienteMenor(Pessoa pessoa){
        ClienteMenorRepository.createCliente(pessoa);
        return false;
    }

    public static boolean deletarCliente(){
        return false;
    }

    public static ClienteMenor getCliente(){
        return null;
    }

    public static boolean updateClienteName(){
        return false;
    }
}
