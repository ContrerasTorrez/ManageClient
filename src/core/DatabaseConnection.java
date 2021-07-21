package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    static final String DB_URL = "jdbc:mysql://localhost/";
    static final String USER = "root";
    static final String PASS = "rosebud";

    public static Connection connection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
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
