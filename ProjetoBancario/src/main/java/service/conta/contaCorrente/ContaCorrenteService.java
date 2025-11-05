package service.conta.contaCorrente;

import entity.conta.ContaCorrente;
import entity.pessoa.clientes.Cliente;
import repository.conta.ContaCorrenteRepository;
import repository.conta.contaCorrente.ContaCorrenteMaiorRepository;
import repository.conta.contaCorrente.ContaCorrenteMenorRepository;

public class ContaCorrenteService {

    public static void cadastroContaCorrente(ContaCorrente conta, Cliente cliente){
        if(cliente.getIdade() >= 18){
            ContaCorrenteMaiorRepository.createContaCorrente(conta);
        }
        if(cliente.getIdade() < 18){
            if(!ContaCorrenteMenorRepository.getIdsMenor().contains(cliente.getId())){
                ContaCorrenteMenorRepository.createContaCorrente(conta);
            }else{
                throw new IllegalArgumentException("Cliente ja criado");
            }
        }
    }

    public static void deleteConta(ContaCorrente conta){
        if(!ContaCorrenteRepository.getIds().contains(conta.getId())) throw new IllegalArgumentException("Id nao referenciado com nenhuma conta");
        ContaCorrenteRepository.deletarContaCorrente(conta);
    }

    public static ContaCorrente getConta(int id){
        if(!ContaCorrenteRepository.getIds().contains(id)) throw new IllegalArgumentException("Id nao referenciado com nenhuma conta");
        if(ContaCorrenteMenorRepository.getContaCorrente(id).getIdCliente()!=0){
            return ContaCorrenteMenorRepository.getContaCorrente(id);
        }else{
            return ContaCorrenteMaiorRepository.getContaCorrente(id);
        }
    }

    public static void sacar(ContaCorrente conta, double quantia){
        if(!ContaCorrenteRepository.getIds().contains(conta.getId())) throw new IllegalArgumentException("Id nao referenciado com nenhuma conta");
        if(conta.getLimeteSaque() < quantia) throw new IllegalArgumentException("Voce excedeu seu limite de saque");
        if(conta.getSaldo() < quantia) throw new IllegalArgumentException("Voce nao tem saldo o suficiente");
        conta.setSaldo(conta.getSaldo()-quantia);
        ContaCorrenteRepository.sacar(conta);
    }

    public static void despositar(ContaCorrente conta, double quantia){
        if(!ContaCorrenteRepository.getIds().contains(conta.getId())) throw new IllegalArgumentException("Id nao referenciado com nenhuma conta");
        conta.setSaldo(conta.getSaldo()+quantia);
        if(conta.getLimeteSaldo() < conta.getSaldo()) throw new IllegalArgumentException("Voce excedeu seu limite de saldo");
        ContaCorrenteRepository.depositar(conta);
    }

    public static void transferir(ContaCorrente conta,int idDestinatario, double quantiaDestinatario){
        if(!ContaCorrenteRepository.getIds().contains(conta.getId())) throw new IllegalArgumentException("Id nao referenciado com nenhuma conta");
        if(!ContaCorrenteRepository.getIds().contains(idDestinatario)) throw new IllegalArgumentException("Id nao referenciado com nenhuma conta");
        try{
            ContaCorrenteService.despositar(ContaCorrenteService.getConta(idDestinatario),quantiaDestinatario);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("A conta destinataria, excedeu o limite de saldo");
        }
        ContaCorrenteService.sacar(conta,quantiaDestinatario);
    }

    public static void updateStatus(ContaCorrente conta, boolean status){
        if(!ContaCorrenteRepository.getIds().contains(conta.getId())) throw new IllegalArgumentException("Id nao referenciado com nenhuma conta");
        conta.setStatus(status);
        ContaCorrenteRepository.updateStatus(conta);
    }
}
