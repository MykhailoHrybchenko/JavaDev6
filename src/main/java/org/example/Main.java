package org.example;

import org.example.firstTask.Database;
import org.example.fourthTask.*;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        DatabaseQueryService databaseQueryService = new DatabaseQueryService();
//        List<LongestProject> longestProjects = databaseQueryService.findLongestProjects();
//        for (LongestProject project : longestProjects) {
//            System.out.println(project.getId() + " " + project.getMonthCount());
//        }
//
//         List<MaxProjectsClient> maxProjectsClients = databaseQueryService.findMaxProjectsClient();
//        for (MaxProjectsClient maxProjectsClient : maxProjectsClients) {
//            System.out.println(maxProjectsClient.getName() + " " + maxProjectsClient.getProjectCount());
//        }

//         List<MaxSalaryWorker> maxSalaryWorkers = databaseQueryService.findMaxSalaryWorkers();
//            for (MaxSalaryWorker maxSalaryWorker : maxSalaryWorkers) {
//                System.out.println(maxSalaryWorker.getName() + " " + maxSalaryWorker.getSalary());
//            }

//            List<ProjectPrices> projectPrices = databaseQueryService.printProjectPrices();
//            for (ProjectPrices projectPrices1 : projectPrices) {
//                System.out.println(projectPrices1.getName() + " " + projectPrices1.getPrice());
//            }

            List<YoungestEldestWorkers> youngestEldestWorkers = databaseQueryService.findYoungestEldestWorkers();
            for (YoungestEldestWorkers youngestEldestWorkers1 : youngestEldestWorkers) {
                System.out.println(youngestEldestWorkers1.getType() + " " + youngestEldestWorkers1.getName()
                + " " + youngestEldestWorkers1.getBirthday());
            }

    }
}