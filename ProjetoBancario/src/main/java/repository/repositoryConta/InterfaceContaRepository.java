package repository.repositoryConta;

import model.conta.Conta;

public interface InterfaceContaRepository {

    void createConta(Conta conta);

    void deleteConta(int id);

    void updateConta(Conta conta, int id);

    void depositar(int id, double quantia);

    void tranferir(Conta remetente,int destinatarioId, double quantia);

    Conta getConta(int id);
    
}
