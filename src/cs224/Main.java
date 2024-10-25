package cs224;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    static CSVReader csvReader = new CSVReader();
    static CSVExporter csvExporter = new CSVExporter();
    static SortingAlgos sortingAlgos = new SortingAlgos();

    public static void getEmployeesSortExport(String csvFileName) {
        for (int i = 0; i < 5; i++) {
            try {
                String sortingAlgo = "";
                ArrayList<Employee> employees;
                employees = csvReader.getEmployeesFromFile(csvFileName);
                long startTime = System.nanoTime();

                switch (i) {
                    case 0:
                        sortingAlgo = "bubble_sort";
                        System.out.printf("Sorting \"%5s\" with sorting algorithm \"%5s\"...\n", csvFileName, sortingAlgo);
                        sortingAlgos.bubble_sort(employees);
                        break;
                    case 1:
                        sortingAlgo = "insertion_sort";
                        System.out.printf("Sorting \"%5s\" with sorting algorithm \"%5s\"...\n", csvFileName, sortingAlgo);
                        sortingAlgos.insertion_sort(employees);
                        break;
                    case 2:
                        sortingAlgo = "merge_sort";
                        System.out.printf("Sorting \"%5s\" with sorting algorithm \"%5s\"...\n", csvFileName, sortingAlgo);
                        sortingAlgos.merge_sort(employees);
                        break;
                    case 3:
                        sortingAlgo = "quick_sort";
                        System.out.printf("Sorting \"%5s\" with sorting algorithm \"%5s\"...\n", csvFileName, sortingAlgo);
                        sortingAlgos.quick_sort(employees);
                        break;
                    case 4:
                        sortingAlgo = "selection_sort";
                        System.out.printf("Sorting \"%5s\" with sorting algorithm \"%5s\"...\n", csvFileName, sortingAlgo);
                        sortingAlgos.selection_sort(employees);
                        break;
                }

                long endTime = System.nanoTime();
                float duration = (float) (endTime - startTime) / 1_000_000_000;
                System.out.printf("Sorted \"%5s\" with sorting algorithm \"%5s\", took %.2f seconds\n", csvFileName, sortingAlgo, duration);

                csvExporter.export(employees, csvFileName, sortingAlgo);
            } catch (IOException e) {
                System.err.println("Error whilst trying to get employees from CSV file:" + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        String[] csvFileNames = {"company_a", "company_b", "company_c", "company_e"};
        for (String csvFileName : csvFileNames) getEmployeesSortExport(csvFileName);
    }
}