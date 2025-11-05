package com.example.util;


import java.sql.*;


public class DBUtil {
private static final String URL = "jdbc:mysql://localhost:3306/college_db?useSSL=false&allowPublicKeyRetrieval=true";
private static final String USER = "root"; // change
private static final String PASS = "rootpassword"; // change


static {
try {
Class.forName("com.mysql.cj.jdbc.Driver");
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
}


public static Connection getConnection() throws SQLException {
return DriverManager.getConnection(URL, USER, PASS);
}


public static void close(AutoCloseable ac) {
if (ac == null) return;
try { ac.close(); } catch (Exception e) { /* ignore */ }
}
}
