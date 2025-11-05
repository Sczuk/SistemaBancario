package service.conta.contaPoupanca;

import entity.conta.ContaPoupanca;
import entity.pessoa.clientes.Cliente;
import repository.conta.ContaPoupancaRepository;
import repository.conta.contaCorrente.ContaCorrenteMenorRepository;
import repository.conta.contaPoupanca.ContaPoupancaMaiorRepository;
import repository.conta.contaPoupanca.ContaPoupancaMenorRepository;

public class ContaPoupancaService {

    public static void cadastroContaPoupanca(ContaPoupanca conta, Cliente cliente) {

        if(cliente.getIdade() >= 18){
            ContaPoupancaMaiorRepository.createConta(conta);
        }
        if(cliente.getIdade() < 18){
            if(!ContaPoupancaMenorRepository.getIdsMenor().contains(cliente.getId())){
                ContaPoupancaMenorRepository.createConta(conta);
            }else{
                throw new IllegalArgumentException("Cliente ja criado");
            }
        }
    }

    public static void deleteContaPoupanca(ContaPoupanca conta){
        if(!ContaPoupancaRepository.getIds().contains(conta.getId())) throw new IllegalArgumentException("Id nao referenciado com nenhuma conta");
        ContaPoupancaRepository.deletarConta(conta);
    }


}
