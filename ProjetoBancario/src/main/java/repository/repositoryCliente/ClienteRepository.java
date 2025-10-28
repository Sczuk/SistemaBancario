package repository.repositoryCliente;

import config.ConnectionDataBase;
import model.pessoa.Pessoa;
import model.pessoa.clientes.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteRepository {

    public static Cliente getCliente(int id) {
        String sql = "Select * from cliente where id=?";
        Cliente cliente = null;

        try(Connection conn = ConnectionDataBase.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,id);
            try(ResultSet rs = stmt.executeQuery()){
               if(!rs.next())return null;
               cliente = new Cliente(rs.getNString("nome"), rs.getNString("cpf"), rs.getNString("dataDeNascimento"),rs.getInt("idade"),rs.getInt("id"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cliente;
    }

    public static boolean updateClienteName(String nome, int id) {
        String sql = "UPDATE cliente set nome=? where id=?";

        try(Connection conn = ConnectionDataBase.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,nome);
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


    public static boolean createCliente(Pessoa pessoa) {
        String sql = "Insert Into cliente(nome,cpf,dataDeNascimento,idade) Values (?,?,?,?)";

        try(Connection conn = ConnectionDataBase.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getCpf());
            stmt.setString(3, pessoa.getDataDeNascimento());
            stmt.setInt(4,pessoa.getIdade());
            if(stmt.executeUpdate()==1) return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
