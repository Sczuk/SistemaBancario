package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDataBase {
    private static final String url="";
    private static final String password="";
    private static final String user = "";

    public static Connection getConnection()throws SQLException{
        return DriverManager.getConnection(url, user, password);
    }
}
