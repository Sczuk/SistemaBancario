package repository.repositoryConta;

import model.conta.Conta;

public class ContaMenorRepository implements InterfaceContaRepository{
    @Override
    public void createConta(Conta conta) {

    }

    @Override
    public void deleteConta(int id) {

    }

    @Override
    public void updateConta(Conta conta, int id) {

    }

    @Override
    public void depositar(int id, double quantia) {

    }

    @Override
    public void tranferir(Conta remetente, int destinatarioId, double quantia) {

    }

    @Override
    public Conta getConta(int id) {
        return null;
    }
}
