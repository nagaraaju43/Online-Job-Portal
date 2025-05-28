package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static Connection Conn;

    public static Connection getconn() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Conn = DriverManager.getConnection(
            	    "jdbc:mysql://localhost:3306/job_portal?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
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
        return Conn;
    }
}
