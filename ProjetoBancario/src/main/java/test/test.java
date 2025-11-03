package test;


import controller.cliente.ClienteMaiorController;
import entity.conta.ContaCorrente;
import entity.conta.ContaPoupanca;
import entity.pessoa.clientes.Cliente;
import entity.pessoa.clientes.ClienteMaior;
import repository.conta.ContaCorrenteRepository;
import repository.conta.ContaPoupancaRepository;
import repository.conta.createConta.contaCorrente.ContaCorrenteMaiorRepository;
import repository.conta.createConta.contaPoupanca.ContaPoupancaMaiorRepository;


public class test {
    public static void main(String[] args) {

        ContaPoupanca conta = ContaPoupancaMaiorRepository.getContaPoupanca(2);
        ContaPoupancaRepository.sacar(conta,50);

    }
}
