package repository.conta.createConta.contaCorrente;

import config.ConnectionDataBase;
import entity.conta.ContaCorrente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContaCorrenteMaiorRepository{


    public static void createContaCorrente(ContaCorrente contaCorrente) {
        String sql = "insert into contacorrente(saldo,estado,limiteSaldo, limiteSaque, id_cliente) values(?,?,?,?,?)";

        try(Connection conn = ConnectionDataBase.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setDouble(1,contaCorrente.getSaldo());
            stmt.setBoolean(2, contaCorrente.isStatus());
            stmt.setDouble(3,contaCorrente.getLimeteSaldo());
            stmt.setDouble(4,contaCorrente.getLimeteSaque());
            stmt.setInt(5,contaCorrente.getIdCliente());
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static ContaCorrente getContaCorrente(int id) {
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
