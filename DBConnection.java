package com.packages;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:derby:C:\\Users\\Admin\\MyDB;create=true";
    private static final String DRIVER = "org.apache.derby.jdbc.ClientDriver";

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL);
            System.out.println("Connected to BankDB!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
