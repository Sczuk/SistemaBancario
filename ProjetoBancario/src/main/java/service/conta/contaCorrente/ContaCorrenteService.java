package service.conta.contaCorrente;

import entity.conta.ContaCorrente;
import entity.conta.ContaPoupanca;
import entity.pessoa.clientes.Cliente;
import repository.conta.ContaCorrenteRepository;
import repository.conta.ContaPoupancaRepository;
import repository.conta.contaCorrente.ContaCorrenteMaiorRepository;
import repository.conta.contaCorrente.ContaCorrenteMenorRepository;

public class ContaCorrenteService {

    public static void cadastroContaCorrente(ContaCorrente conta, Cliente cliente){
        if(cliente.getIdade() >= 18){
            ContaCorrenteMaiorRepository.createContaCorrente(conta);
        }
        if(cliente.getIdade() < 18){
            if(ContaCorrenteMenorRepository.getContaCorrente(conta)==null){
                ContaCorrenteMenorRepository.createContaCorrente(conta);
            }
            throw new IllegalArgumentException("Cliente ja criado");
        }
    }

    public static void deleteConta(ContaCorrente conta){
        if(!ContaCorrenteRepository.getIds().contains(conta.getId())) throw new IllegalArgumentException("Id nao referenciado com nenhuma conta");
        ContaCorrenteRepository.deletarContaCorrente(conta);
    }

    public static ContaCorrente getConta(ContaCorrente conta){
        if(!ContaCorrenteRepository.getIds().contains(conta.getId())) throw new IllegalArgumentException("Id nao referenciado com nenhuma conta");
        ContaCorrenteRepository.(conta);
    }
}
