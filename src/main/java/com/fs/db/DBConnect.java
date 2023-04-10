package com.fs.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	private static final String url = "jdbc:sqlserver://localhost:1433;databaseName=Test01;encrypt=false";
    private static final String user = "sa";
    private static final String password = "07082001";
    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                System.out.println("Error connecting to database: " + e.getMessage());
            }
        }
        return conn;
    }
}
