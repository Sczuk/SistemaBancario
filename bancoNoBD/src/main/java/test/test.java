package test;

import model.pessoa.Pessoa;
import model.pessoa.clientes.Cliente;
import service.serviceCliente.ServiceCliente;

public class test {
    public static void main(String[] args) {
        Cliente user = new Cliente("nome","12345678","21/12/2008",1);
        Cliente user1 = new Cliente("henrique","12345678","21/12/2010",1);

        System.out.println(ServiceCliente.getIdade(user));
        System.out.println("===============================");
        System.out.println(ServiceCliente.getIdade(user1));
    }
}
