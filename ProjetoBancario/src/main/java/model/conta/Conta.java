package model.conta;

import model.pessoa.clientes.Cliente;

public abstract class Conta {
    private int id;
    private double saldo;
    private Cliente cliente;
    private boolean status;
}
