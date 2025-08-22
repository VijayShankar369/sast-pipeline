package com.example;
import java.sql.*;

public class VulnerableApp {
    // This will be detected as hardcoded password
    private static final String DB_PASSWORD = "admin123!";
    private static final String API_KEY = "sk-1234567890abcdef";
    
    public void getUser(String username) throws SQLException {
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost/app", "root", DB_PASSWORD);
        Statement stmt = conn.createStatement();
        
        // This will be detected as SQL injection
        String sql = "SELECT * FROM users WHERE username = '" + username + "'";
        stmt.executeQuery(sql);
    }
    
    public static void main(String[] args) throws SQLException {
        new VulnerableApp().getUser("admin' OR '1'='1");
    }
}
EOF
