package test;


import controller.cliente.ClienteMaiorController;
import entity.conta.ContaCorrente;
import repository.conta.ContaCorrenteRepository;
import repository.conta.createConta.contaCorrente.ContaCorrenteMaiorRepository;


public class test {
    public static void main(String[] args) {


        System.out.println(ContaCorrenteRepository.getContaCorrente(4));
    }
}
