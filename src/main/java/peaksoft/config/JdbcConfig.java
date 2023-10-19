package peaksoft.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * author: Ulansky
 */
public class JdbcConfig {
    public static Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/postgres",
                            "postgres",
                            "postgres");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
