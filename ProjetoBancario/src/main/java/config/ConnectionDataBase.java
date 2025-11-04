package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDataBase {
    private static final String url="jdbc:mysql://localhost:3306/sistemabancario";
    private static final String password="901902";
    private static final String user = "sczuk";

    public static Connection getConnection()throws SQLException{
        return DriverManager.getConnection(url, user, password);
    }
}
