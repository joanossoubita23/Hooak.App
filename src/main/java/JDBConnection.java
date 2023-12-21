import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBConnection {
    private static final   String DB_URL="jdbc:mysql://127.0.0.1:3306/Hookah_DB";
    private  static final String DB_USER="roo";
    private static final String DB_Password="";
    public static Connection getConnection(){
        Connection conn =null;
    try {
        conn= DriverManager.getConnection(DB_URL,DB_USER,DB_Password);
        System.out.println("Connected Successfully to the Database");

    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return conn;
    }
}
