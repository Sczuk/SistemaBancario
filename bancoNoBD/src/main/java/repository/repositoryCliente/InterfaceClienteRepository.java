package repository.repositoryCliente;

import model.pessoa.Pessoa;

public interface InterfaceClienteRepository {

    boolean createCliente(Pessoa pessoa);

    boolean deleteCliente(int id);

    boolean updateClienteName(Pessoa pessoa, int id);

    Pessoa getCliente(int id);

}
