package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDatabaseConnection {
    static Connection connection;

    public static Connection createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create connection
            String strUrl = "jdbc:mysql://localhost:3306/weatherlady";
            String strUser = "root";
            String strPassword = "root";

            connection = DriverManager.getConnection(strUrl, strUser, strPassword);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}
