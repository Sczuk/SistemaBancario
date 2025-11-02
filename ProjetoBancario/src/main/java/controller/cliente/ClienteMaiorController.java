package controller.cliente;

import entity.pessoa.clientes.ClienteMaior;
import service.cliente.ClienteMaiorService;

public class ClienteMaiorController {

    public static boolean deletarClienteMenor(int id){
        if(id<0) throw new IllegalArgumentException("Id nao pode ser menor que zero");
        return ClienteMaiorService.deletarCliente(id);
    }

    public static ClienteMaior getCliente(int id){
        if(id<0)throw new IllegalArgumentException("Id nao pode ser menor que zero");
        return ClienteMaiorService.getCliente(id);
    }

    public static boolean updateClienteName(ClienteMaior nome, int id){
        if(id<0)throw new IllegalArgumentException("Id nao pode ser menor que zero");
        if(nome.getNome().trim().isEmpty()||nome.getNome().trim().length()==2) throw new IllegalArgumentException("Nome Invalido");
        ClienteValidationController.formatandoNome(nome);
        return ClienteMaiorService.updateClienteName(nome,id);
    }
}
