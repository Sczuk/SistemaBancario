package repository.conta.createConta.contaPoupanca;

import config.ConnectionDataBase;
import entity.conta.ContaPoupanca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContaPoupancaMaiorRepository {

    public static void createConta(ContaPoupanca conta) {
        String slq = "insert into contaPoupanca(saldo,estado,saldoGuardado,id_cliente) values(?,?,?,?)";

        try(Connection conn = ConnectionDataBase.getConnection();
            PreparedStatement stmt = conn.prepareStatement(slq)) {
            stmt.setDouble(1,conta.getSaldo());
            stmt.setBoolean(2, conta.isStatus());
            stmt.setDouble(3,conta.getSaldoGuardado());
            stmt.setInt(4,conta.getIdCliente());
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static ContaPoupanca getContaPoupanca(int id) {
        String sql = "select * from contaPoupanca where id=?";
        ContaPoupanca contaPoupanca = null;

        try(Connection conn = ConnectionDataBase.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,id);
            try(ResultSet rs = stmt.executeQuery()){
                rs.next();
                contaPoupanca = new ContaPoupanca(rs.getDouble("saldo"),rs.getDouble("saldoGuardado"),rs.getBoolean("estado"),rs.getInt("id"),rs.getInt("id_cliente"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return contaPoupanca;
    }
}
