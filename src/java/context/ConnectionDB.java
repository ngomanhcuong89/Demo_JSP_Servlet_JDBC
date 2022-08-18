package context;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
    public static Connection Connect()
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=webbanhang;User=sa;Password=sa";
            Connection conn = DriverManager.getConnection(url);
            return conn;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
}
