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


    public static void depositar(ContaCorrente conta, double quantia) {
        String sql = "update contaCorrente set saldo=? where id=?";

        try(Connection conn = ConnectionDataBase.getConnection();
        PreparedStatement stmt = conn.prepareCall(sql)){
            stmt.setDouble(1,quantia);
            stmt.setInt(2,conta.getId());
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static void tranferir(ContaCorrente conta, int idDestinatario, double quantiaDestinatario) {
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
            stmt.setDouble(1,conta.getSaldo());
            stmt.setInt(2,conta.getId());
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

        //para fazer a tranferencia vou retornar o saldo atualizado para o remetente e a quantia para o destinatario
    }

    public static void sacar(ContaCorrente conta){
        String sql = "update contaCorrente set saldo=? where id=?";

        try(Connection conn = ConnectionDataBase.getConnection();
        PreparedStatement stmt = conn.prepareCall(sql)){
            stmt.setInt(1,conta.getId());
            stmt.setDouble(2,conta.getSaldo());
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        //vou retirar o saldo e retonar o saldo atualizado
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
