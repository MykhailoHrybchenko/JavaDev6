package org.example.fourthTask;

import org.example.firstTask.Database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    public List<LongestProject> findLongestProjects() throws IOException {
        List<LongestProject> projectsList = new ArrayList<>();
        String query = readSqlQuery("sqlQueries/find_longest_project.sql");
        try(Connection connection = Database.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                int monthCount = resultSet.getInt("PROJECT_DURATION");
                projectsList.add(new LongestProject(id, monthCount));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return projectsList;
    }

    public List<MaxProjectsClient> findMaxProjectsClient() throws IOException {
        List<MaxProjectsClient> maxProjectsClientsList = new ArrayList<>();
        String query = readSqlQuery("sqlQueries/find_max_projects_client (2).sql");
        try(Connection connection = Database.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                int projectsCount = resultSet.getInt("PROJECTS_COUNT");
                maxProjectsClientsList.add(new MaxProjectsClient(name, projectsCount));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return maxProjectsClientsList;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorkers() throws IOException {
        List<MaxSalaryWorker> maxSalaryWorkers = new ArrayList<>();
        String query = readSqlQuery("sqlQueries/find_max_salary_worker.sql");
        try(Connection con = Database.getInstance().getConnection();
            Statement statement = con.createStatement();
            ResultSet set = statement.executeQuery(query)) {
            while (set.next()) {
                String name = set.getString("NAME");
                int salary = set.getInt("SALARY");
                maxSalaryWorkers.add(new MaxSalaryWorker(name, salary));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return maxSalaryWorkers;
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorkers() throws IOException {
        List<YoungestEldestWorkers> youngestEldestWorkersList = new ArrayList<>();
        String query = readSqlQuery("sqlQueries/find_youngest_eldest_workers.sql");
        try(Connection con = Database.getInstance().getConnection();
            Statement statement = con.createStatement();
            ResultSet set = statement.executeQuery(query)) {
            while (set.next()) {
                String type = set.getString("TYPE");
                String name = set.getString("NAME");
                LocalDate birthday = set.getDate("BIRTHDAY").toLocalDate();
                youngestEldestWorkersList.add(new YoungestEldestWorkers(type,name,birthday));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return youngestEldestWorkersList;
    }

    public List<ProjectPrices> printProjectPrices() throws IOException {
        List<ProjectPrices> projectPricesList = new ArrayList<>();
        String query = readSqlQuery("sqlQueries/print_project_prices.sql");
        try(Connection con = Database.getInstance().getConnection();
            Statement statement = con.createStatement();
            ResultSet set = statement.executeQuery(query)) {
            while (set.next()) {
                String name = set.getString("PROJECT_NAME");
                int price = set.getInt("PRICE");
                projectPricesList.add(new ProjectPrices(name, price));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return projectPricesList;
    }

    private String readSqlQuery(String filepath) throws IOException {
        InputStream stream = getClass().getClassLoader().getResourceAsStream(filepath);
        if (stream != null) {
            return new String(stream.readAllBytes());
        }
        return null;
    }
}
