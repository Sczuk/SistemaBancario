package repository.repositoryCliente;

import model.pessoa.Pessoa;

public interface InterfaceClienteRepository {

    void create(Pessoa pessoa);

    void delete(int id);

    void update(Pessoa pessoa, int id);

    Pessoa getCliente(int id);

}
