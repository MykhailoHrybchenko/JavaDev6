package org.example.secondTask;

import org.example.firstTask.Database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {
    public static void main(String[] args) throws IOException, SQLException {
        String sqlInitFilePath = "C:\\Users\\Asus\\IdeaProjects\\JavaDev6\\src\\main\\resources\\sqlQueries\\init_db.sql";
        Connection connection = Database.getInstance().getConnection();
        String sqlQuery = readSqlQueryFile(sqlInitFilePath);
        executeSqlQueries(connection, sqlQuery);
        connection.close();
    }

    public static String readSqlQueryFile(String filePath) throws IOException {
        StringBuilder builder = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
        }
        return builder.toString();
    }

    public static void executeSqlQueries(Connection con, String query) throws SQLException {
        Statement statement = con.createStatement();
        String[] queriesList = query.split(";");
        for (String command : queriesList) {
            statement.executeUpdate(command);
        }
        statement.close();
    }
}
