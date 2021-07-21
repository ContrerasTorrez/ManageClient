package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
        static final String USER = "root";
    static final String PASS = "rosebud";
    static final String DB_A = "jdbc:mysql://localhost/EMPLOYEE?user=root&password=rosebud";


    public static Connection connection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_A);
            // Do something with the Connection
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("connection(): SQLException: " + ex.getMessage());
            System.out.println("connection(): SQLState: " + ex.getSQLState());
            System.out.println("connection(): VendorError: " + ex.getErrorCode());
        }
        return conn;
    }


    public static Statement statement() {
        Statement stmt = null;
        try {
            stmt = connection().createStatement();
        }catch (SQLException ex){
            System.out.println("statement(): SQLException: " + ex.getMessage());
            System.out.println("statement(): SQLState: " + ex.getSQLState());
            System.out.println("statement(): VendorError: " + ex.getErrorCode());
        }
        return stmt;
    }

}
