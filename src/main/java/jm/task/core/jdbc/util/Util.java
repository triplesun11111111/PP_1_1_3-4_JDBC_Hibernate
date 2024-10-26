package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public static Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/my_database";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Tyjntyjn14";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Всё оки. ");
        } catch (SQLException e) {
            System.out.println("Ничего не соединилось с БД!! " + e.getMessage());
            throw new RuntimeException();
        } catch (ClassNotFoundException e) {
            System.out.println("Всё вообще оч плохо, драйвера нет! " + e.getMessage());
            throw new RuntimeException();
        }
        return connection;
    }

    public static void closeConnecrion() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Не закрывается!!!");
                throw new RuntimeException();
            }
        }
    }
}
