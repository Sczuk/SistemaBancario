package repository.conta;

import config.ConnectionDataBase;
import entity.conta.Conta;
import entity.conta.ContaCorrente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContaCorrenteRepository {


    public static void depositar(ContaCorrente conta) {
        String sql = "update contaCorrente set saldo=? where id=?";

        try(Connection conn = ConnectionDataBase.getConnection();
        PreparedStatement stmt = conn.prepareCall(sql)){
            stmt.setDouble(1,conta.getSaldo());
            stmt.setInt(2,conta.getId());
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static void sacar(ContaCorrente conta){
        String sql = "update contaCorrente set saldo=? where id=?";

        try(Connection conn = ConnectionDataBase.getConnection();
        PreparedStatement stmt = conn.prepareCall(sql)){
            stmt.setDouble(1,conta.getSaldo());
            stmt.setInt(2,conta.getId());
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void deletarContaCorrente(ContaCorrente conta) {
        String sql = "delete from contacorrente where id=?";

        try(Connection conn = ConnectionDataBase.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,conta.getId());
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static void updateStatus(ContaCorrente conta) {
        String sql = "update contacorrente set estado=? where id=?";

        try(Connection conn = ConnectionDataBase.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setBoolean(1, conta.isStatus());
            stmt.setInt(2,conta.getId());
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static List<Integer> getIds(){
        List<Integer> contas = new ArrayList<>();
        String sql = "select id from contaCorrente";

        try(Connection conn = ConnectionDataBase.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                contas.add(rs.getInt("id"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return contas;
    }
}
