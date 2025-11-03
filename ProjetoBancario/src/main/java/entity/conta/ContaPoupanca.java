package entity.conta;

import entity.pessoa.clientes.Cliente;

public class ContaPoupanca extends Conta{
    private double saldoGuardado;

    public ContaPoupanca(Cliente cliente) {
        super(0, false, cliente.getId());
        this.saldoGuardado = 0;
    }

    public ContaPoupanca(double saldo,double saldoGuardado, boolean status, int id, int idCliente){
        super(saldo, status, id, idCliente);
        this.saldoGuardado = saldoGuardado;
    }

    public double getSaldoGuardado() {
        return saldoGuardado;
    }

    @Override
    public String toString() {
        return  "\nsaldo: "+getSaldo()+
                "\nstatus: "+isStatus()+
                "\nsaldo Guardado: "+getSaldoGuardado()+
                "\nid: "+getId();
    }
}
