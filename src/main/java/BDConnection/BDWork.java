package BDConnection;

import java.sql.*;

/**
 * Created by DrSwitch on 13.04.2017.
 */
public class BDWork {

    private final String URL = "jdbc:mysql://localhost:3306/infostudent";
    private final String USERNAME = "root";
    private final String PASSWORD = "123";

    private Connection connection;

    public void conBD() {

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
//                System.out.println("Соединение с БД установлено!");
            } else {
//                System.out.println("Ошибка подключения!");
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

}
