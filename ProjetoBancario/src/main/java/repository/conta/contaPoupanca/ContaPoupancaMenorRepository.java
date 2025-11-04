package repository.conta.contaPoupanca;

import config.ConnectionDataBase;
import entity.conta.ContaPoupanca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContaPoupancaMenorRepository  {

    public static void createConta(ContaPoupanca conta) {
        String slq = "insert into contaPoupanca(saldo,estado,saldoGuardado,id_clienteMenor) values(?,?,?,?)";

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

    public static ContaPoupanca getContaPoupanca(ContaPoupanca conta) {
        String sql = "select * from contaPoupanca where id=?";
        ContaPoupanca contaPoupanca = null;

        try(Connection conn = ConnectionDataBase.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,conta.getIdCliente());
            try(ResultSet rs = stmt.executeQuery()){
                rs.next();
                contaPoupanca = new ContaPoupanca(rs.getDouble("saldo"),rs.getDouble("saldoGuardado"),rs.getBoolean("estado"),rs.getInt("id"),rs.getInt("id_clienteMenor"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return contaPoupanca;
    }

}
