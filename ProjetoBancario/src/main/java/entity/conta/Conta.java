package entity.conta;

import entity.pessoa.clientes.ClienteMaior;
import entity.pessoa.clientes.ClienteMenor;

public abstract class Conta {
    private int id;
    private ClienteMaior clienteMaior;
    private ClienteMenor clienteMenor;
    private boolean status;
    private double saldo;
    private int idCliente;

    public Conta(double saldo,boolean status, int idCliente){
        this.saldo = saldo;
        this.status = status;
        this.idCliente = idCliente;
    }

    public Conta(double saldo,boolean status,int id,int idCliente){
        this(saldo,status,idCliente);
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
