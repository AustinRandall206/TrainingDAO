import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {

    private static String url = "jdbc:mariadb://localhost:3306/tutorial";
    private static String user = "root";
    private static String password = "password";

    private Database() {

    }
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    public static void closePreparedStatement(PreparedStatement ps) throws SQLException {
        ps.close();
    }
    public static void closeConnection(Connection connection) throws SQLException {
        connection.endRequest();
    }
}
