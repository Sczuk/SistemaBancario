package repository.cliente;

import config.ConnectionDataBase;
import entity.pessoa.clientes.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    public static List<Cliente> getCpfs(){
        List<Cliente> cpfs = new ArrayList<>();
        String sql = "select cpf from cliente union select cpf from clientemenor";

        try(Connection conn = ConnectionDataBase.getConnection();
            PreparedStatement stmt = conn.prepareCall(sql);
            ResultSet rs = stmt.executeQuery()){
            while (rs.next()){
                cpfs.add(new Cliente(rs.getNString(1)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cpfs;
    }
}
