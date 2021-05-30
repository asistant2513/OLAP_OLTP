package com.example.bands.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String url = "jdbc:sqlserver://localhost:1357;database=metal";

    private static final String username = "sa";

    private static final String pwd = "1111";

    public static Connection getConnection(){
        Connection c = null;
        try{
            c = DriverManager.getConnection(url, username, pwd);
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return c;
    }
}
