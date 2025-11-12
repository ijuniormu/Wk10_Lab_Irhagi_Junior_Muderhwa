package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
    private static final String INSERT_SQL =
            "INSERT INTO users (username, last_name, first_name, password, created_at) " +
                    "VALUES (?, ?, ?, ?, NOW())";

    public static void insertUser(String username, String lastName, String firstName, String password) throws SQLException {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {

            // PreparedStatement: prevents SQL injection & handles escaping.
            ps.setString(1, username);
            ps.setString(2, lastName);
            ps.setString(3, firstName);
            ps.setString(4, password);

            ps.executeUpdate();
        }
    }
}
