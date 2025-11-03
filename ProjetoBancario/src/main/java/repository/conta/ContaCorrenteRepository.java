package repository.conta;

import config.ConnectionDataBase;
import entity.conta.ContaCorrente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContaCorrenteRepository {


    public static void depositar(int id, double quantia) {
        String sql = "update contaCorrente set saldo=? where id=?";

        try(Connection conn = ConnectionDataBase.getConnection();
        PreparedStatement stmt = conn.prepareCall(sql)){
            stmt.setDouble(1,quantia);
            stmt.setInt(2,id);
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static void tranferir(int idRemetente, int idDestinatario, double saldoRemetente, double quantiaDestinatario) {
        String sql = "update contaCorrente set saldo=? where id=?";

        try(Connection conn = ConnectionDataBase.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setDouble(1,quantiaDestinatario);
            stmt.setInt(2,idDestinatario);
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

        try(Connection conn = ConnectionDataBase.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setDouble(1,saldoRemetente);
            stmt.setInt(2,idRemetente);
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

        //para fazer a tranferencia vou retornar o saldo atualizado para o remetente e a quantia para o destinatario
    }

    public static void sacar(int id, double saldo){
        String sql = "update contaCorrente set saldo=? where id=?";

        try(Connection conn = ConnectionDataBase.getConnection();
        PreparedStatement stmt = conn.prepareCall(sql)){
            stmt.setInt(1,id);
            stmt.setDouble(2,saldo);
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void deletarContaCorrente(int id) {
        String sql = "delete from contacorrente where id=?";

        try(Connection conn = ConnectionDataBase.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,id);
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static void updateStatus(int id, boolean status) {
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
