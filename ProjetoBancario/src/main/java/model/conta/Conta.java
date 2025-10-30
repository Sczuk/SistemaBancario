package model.conta;

import model.pessoa.clientes.ClienteMaior;

public abstract class Conta {
    private int id;
    private double saldo;
    private ClienteMaior clienteMaior;
    private boolean status;
}
