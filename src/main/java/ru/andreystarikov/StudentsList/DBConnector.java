package ru.andreystarikov.StudentsList;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;
import java.util.ArrayList;

public class DBConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/journal?autoReconnect=true&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";


    public static ArrayList<Journal> connectToDB(String task) {

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.out.println("Не удалось запустить класс драйвера");
            e.printStackTrace();
        }
        ArrayList<Journal> journal = new ArrayList<Journal>();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(task);

            while (resultSet.next()) {
                Journal j = new Journal();
                j.setSubject(resultSet.getString(1));
                j.setLastName(resultSet.getString(2));
                j.setFirstName(resultSet.getString(3));
                j.setGrade(resultSet.getDouble(4));
                journal.add(j);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return journal;
    }

}
