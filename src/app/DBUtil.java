package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    // TODO: tweak to your local settings
    private static final String URL  = "jdbc:mysql://localhost:3306/javafxsample?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "Admin@123!12"; // put your password if you set one

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // ensure driver is loaded
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL Driver not found", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
