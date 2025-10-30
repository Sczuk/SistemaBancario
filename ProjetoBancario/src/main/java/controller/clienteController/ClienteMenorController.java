package controller.clienteController;

import model.pessoa.clientes.ClienteMenor;
import service.serviceCliente.ClienteMenorService;

public class ClienteMenorController {

    public static boolean deletarClienteMenor(int id){
        if(id<0) throw new IllegalArgumentException("Id nao pode ser menor que zero");
        return ClienteMenorService.deletarCliente(id);
    }

    public static ClienteMenor getClienteMenor(int id){
        if(id<0) throw new IllegalArgumentException("Id nao pode ser menor que zero");
        return ClienteMenorService.getCliente(id);
    }

    public static boolean updateClienteName(ClienteMenor nome, int id){
        if(nome.getNome().trim().isEmpty()||nome.getNome().trim().length()==2) throw new IllegalArgumentException("Nome Invalido");
        if(id<0)throw new IllegalArgumentException("Id nao pode ser menor que zero");
        ClienteValidationController.formatandoNome(nome);
        return ClienteMenorService.updateClienteName(nome,id);
    }
}
