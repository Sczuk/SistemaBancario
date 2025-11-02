package repository.cliente;

import config.ConnectionDataBase;
import entity.pessoa.clientes.ClienteMaior;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteMaiorRepository {

    public static ClienteMaior getCliente(int id) {
        String sql = "Select * from cliente where id=?";
        ClienteMaior clienteMaior = null;

        try(Connection conn = ConnectionDataBase.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,id);
            try(ResultSet rs = stmt.executeQuery()){
               if(!rs.next())return null;
               clienteMaior = new ClienteMaior(rs.getNString("nome"), rs.getNString("cpf"), rs.getNString("dataDeNascimento"),rs.getInt("idade"),rs.getInt("id"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return clienteMaior;
    }

    public static boolean updateClienteName(ClienteMaior clienteMaior, int id) {
        String sql = "UPDATE cliente set nome=? where id=?";

        try(Connection conn = ConnectionDataBase.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, clienteMaior.getNome());
            stmt.setInt(2,id);
            if(stmt.executeUpdate()==1) return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteCliente(int id) {
        String sql = "Delete from cliente where id=?";

        try(Connection conn = ConnectionDataBase.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,id);
            if(stmt.executeUpdate()==1) return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }


    public static boolean createCliente(ClienteMaior clienteMaior) {
        String sql = "Insert Into cliente(nome,cpf,dataDeNascimento,idade) Values (?,?,?,?)";

        try(Connection conn = ConnectionDataBase.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, clienteMaior.getNome());
            stmt.setString(2, clienteMaior.getCpf());
            stmt.setString(3, clienteMaior.getDataDeNascimento());
            stmt.setInt(4,clienteMaior.getIdade());
            if(stmt.executeUpdate()==1) return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
