package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDataBase {
    private final String url="";
    private final String password="";
    private final String user = "";

    public Connection getConnection()throws SQLException{
        return DriverManager.getConnection(url,user,password);
    }
}
