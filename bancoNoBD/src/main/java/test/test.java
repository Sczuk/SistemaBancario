package test;

import model.pessoa.clientes.Cliente;
import service.serviceCliente.ClienteService;

public class test {
    public static void main(String[] args) {
        Cliente user = new Cliente("nome","12345678","21/12/oioi",1);
        Cliente user1 = new Cliente("henrique","12345678","21/12/2010",1);

        System.out.println(ClienteService.getIdade(user));
        System.out.println("=====");
        System.out.println(ClienteService.getIdade(user1));
    }
}
