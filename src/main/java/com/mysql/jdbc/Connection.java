package com.mysql.jdbc;


import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    static Connection con;

    public static Connection getConn() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            con = (Connection) DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sb_todo?useSSL=false&serverTimezone=UTC",
                "root",
                "root"
            );
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found. Add the MySQL connector JAR to your classpath.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Database connection failed! Check database URL, username, and password.");
            e.printStackTrace();
        }
        return con;
    }
}

