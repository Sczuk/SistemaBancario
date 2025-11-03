package repository.conta.createConta.contaCorrente;

import config.ConnectionDataBase;
import entity.conta.ContaCorrente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContaCorrenteMenorRepository  {

    public void createContaCorrente(ContaCorrente contaCorrente) {
        String sql = "insert into clienteMenor(saldo,estado,limiteSaldo,limiteSaque,id_clienteMenor) values(?,?,?,?,?)";

        try(Connection conn = ConnectionDataBase.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setDouble(1,contaCorrente.getSaldo());
            stmt.setBoolean(2,contaCorrente.isStatus());
            stmt.setDouble(3,contaCorrente.getLimeteSaldo());
            stmt.setDouble(4,contaCorrente.getLimeteSaque());
            stmt.setDouble(5,contaCorrente.getIdCliente());
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
