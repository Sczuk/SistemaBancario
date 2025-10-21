package repository.repositoryCliente;

import model.pessoa.Pessoa;

public class ClienteMenorRepository implements InterfaceClienteRepository{
    @Override
    public boolean createCliente(Pessoa pessoa) {
        return false;
    }

    @Override
    public boolean deleteCliente(int id) {
        return false;
    }

    @Override
    public boolean updateClienteName(Pessoa pessoa, int id) {
        return false;
    }

    @Override
    public Pessoa getCliente(int id) {
        return null;
    }
}
