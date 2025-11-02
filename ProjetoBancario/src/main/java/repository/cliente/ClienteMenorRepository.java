package repository.cliente;

import config.ConnectionDataBase;
import entity.pessoa.Pessoa;
import entity.pessoa.clientes.ClienteMenor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteMenorRepository {

    public static boolean createCliente(Pessoa pessoa) {
        String sql = "Insert into clienteMenor(nome,cpf,dataDeNascimento,idade) Values(?,?,?,?)";

        try (Connection conn = ConnectionDataBase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,pessoa.getNome());
            stmt.setString(2,pessoa.getCpf());
            stmt.setString(3,pessoa.getDataDeNascimento());
            stmt.setInt(4,pessoa.getIdade());
            if(stmt.executeUpdate() == 1) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static boolean deleteCliente(int id) {
        String sql = "Delete from clienteMenor where id=?";

        try(Connection conn = ConnectionDataBase.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,id);
            if(stmt.executeUpdate()==1)return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }


    public static boolean updateClienteName(ClienteMenor cliente, int id) {
        String sql = "UPDATE clientemenor set nome=? where id=?";

        try(Connection conn = ConnectionDataBase.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, cliente.getNome());
            stmt.setInt(2, id);
            if(stmt.executeUpdate()==1)return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }


    public static ClienteMenor getCliente(int id) {
        String sql = "Select * from clienteMenor where id=?";
        ClienteMenor cliente = null;

        try(Connection conn = ConnectionDataBase.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,id);
            try(ResultSet rs = stmt.executeQuery()){
                if(!rs.next()) return null;
                cliente = new ClienteMenor(rs.getNString("nome"),rs.getNString("cpf"),rs.getNString("dataDeNascimento"),rs.getInt("idade"),rs.getInt("id"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cliente;
    }
}
