package entity.conta;

import entity.pessoa.clientes.ClienteMaior;

public class ContaCorrente extends Conta{
    private double limeteSaldo;
    private double limeteSaque;

    //construtor para criaçao da conta
    public ContaCorrente(double limeteSaldo, double limeteSaque, ClienteMaior clienteMaior){
        super(0,false,clienteMaior.getId());
        this.limeteSaldo = limeteSaldo;
        this.limeteSaque = limeteSaque;
    }

    //contrutor para retornar a conta
    public ContaCorrente(double saldo,double limeteSaldo, double limeteSaque, boolean status, int id, int idCliente){
        super(saldo,status,id,idCliente);
        this.limeteSaque = limeteSaque;
        this.limeteSaldo = limeteSaldo;
    }

    public double getLimeteSaldo() {
        return limeteSaldo;
    }

    public double getLimeteSaque() {
        return limeteSaque;
    }

    public void setLimeteSaldo(double limeteSaldo) {
        this.limeteSaldo = limeteSaldo;
    }

    public void setLimeteSaque(double limeteSaque) {
        this.limeteSaque = limeteSaque;
    }

    @Override
    public String toString() {
        return "\nsaldo: "+getSaldo()+
                "\nstatus: "+isStatus()+
                "\nlimeteSaldo: " + limeteSaldo +
                "\nlimeteSaque: " + limeteSaque+
                "\nid: "+getId();
    }
}
