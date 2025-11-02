package test;


import controller.cliente.ClienteMaiorController;
import controller.cliente.ClienteValidationController;
import entity.conta.Conta;
import entity.conta.ContaCorrente;
import entity.pessoa.Pessoa;
import entity.pessoa.clientes.ClienteMaior;
import repository.conta.ContaCorrenteRepository;
import repository.conta.createConta.contaMaior.ContaCorrenteMaiorRepository;


public class test {
    public static void main(String[] args) {
        ContaCorrente conta = ContaCorrenteMaiorRepository.getConta(4);

        System.out.println(conta);

        int idCliente = conta.getIdCliente();

        System.out.println(ClienteMaiorController.getCliente(idCliente));
    }
}
