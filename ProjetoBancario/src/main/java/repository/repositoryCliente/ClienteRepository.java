package repository.repositoryCliente;

import config.ConnectionDataBase;
import model.pessoa.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    public static List<Pessoa> getCpfs(){
        List<Pessoa> cpfs = new ArrayList<>();
        String sql = "select cpf from cliente union select cpf from clientemenor";

        try(Connection conn = ConnectionDataBase.getConnection();
            PreparedStatement stmt = conn.prepareCall(sql);
            ResultSet rs = stmt.executeQuery()){
            while (rs.next()){
                cpfs.add(new Pessoa(rs.getNString(1)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cpfs;
    }
}
