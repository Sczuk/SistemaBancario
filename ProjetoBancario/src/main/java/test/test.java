package test;


import controller.cliente.ClienteMenorController;
import controller.cliente.ClienteValidationController;
import entity.conta.ContaPoupanca;
import entity.pessoa.clientes.Cliente;
import entity.pessoa.clientes.ClienteMenor;
import repository.conta.ContaPoupancaRepository;
import repository.conta.contaPoupanca.ContaPoupancaMaiorRepository;
import repository.conta.contaPoupanca.ContaPoupancaMenorRepository;


public class test {
    public static void main(String[] args) {


        System.out.println(ContaPoupancaMenorRepository.getIds());



    }
}
