package repository.conta.createConta.contaMaior;

import config.ConnectionDataBase;
import entity.conta.Conta;
import entity.conta.ContaCorrente;
import entity.pessoa.clientes.ClienteMaior;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContaCorrenteMaiorRepository{

    public static void createConta(ContaCorrente conta) {
        String sql = "insert into contacorrente(saldo,estado,limiteSaldo, limiteSaque, id_cliente) values(?,?,?,?,?)";

        try(Connection conn = ConnectionDataBase.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setDouble(1,conta.getSaldo());
            stmt.setBoolean(2, conta.isStatus());
            stmt.setDouble(3,conta.getLimeteSaldo());
            stmt.setDouble(4,conta.getLimeteSaque());
            stmt.setInt(5,conta.getIdCliente());
            System.out.println(conta.getIdCliente());
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static void deletarConta(int id) {
        String sql = "delete from contacorrente where id=?";

        try(Connection conn = ConnectionDataBase.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,id);
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static void updateEstado(int id, boolean status) {
        String sql = "update contacorrente set estado=? where id=?";

        try(Connection conn = ConnectionDataBase.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setBoolean(1, status);
            stmt.setInt(2,id);
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static ContaCorrente getConta(int id) {
        String sql = "select * from contacorrente where id=?";
        ContaCorrente contaCorrente = null;

        try(Connection conn = ConnectionDataBase.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,id);
            try(ResultSet rs = stmt.executeQuery()){
                rs.next();
                contaCorrente = new ContaCorrente(rs.getDouble("saldo"),rs.getDouble("limiteSaldo"),rs.getDouble("limiteSaque"),rs.getBoolean("estado"),rs.getInt("id"),rs.getInt("id_cliente"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return contaCorrente;
    }
}
