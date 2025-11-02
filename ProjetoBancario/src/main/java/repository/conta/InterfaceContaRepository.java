package repository.conta;

import entity.conta.Conta;

public interface InterfaceContaRepository {

    void depositar(int id, double quantia);

    void tranferir(Conta remetente,int destinatarioId, double quantia);
    
}
