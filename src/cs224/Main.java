package cs224;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    static String[] sortingAlgoNames = {"bubble_sort", "insertion_sort", "merge_sort", "quick_sort", "selection_sort"};

    static CSVReader csvReader = new CSVReader();
    static CSVExporter csvExporter = new CSVExporter();
    static SortingAlgos sortingAlgos = new SortingAlgos();

    public static void getEmployeesSortExport(String csvFileName) {
        for (int i = 0; i < 5; i++) {
            try {
                String sortingAlgo;
                ArrayList<Employee> employees;
                employees = csvReader.getEmployeesFromFile(csvFileName);
                long startTime = System.nanoTime();

                sortingAlgo = sortingAlgoNames[i];
                System.out.printf("Sorting \"%5s\" with sorting algorithm \"%5s\"...\n", csvFileName, sortingAlgo);

                switch (i) {
                    case 0 -> sortingAlgos.bubble_sort(employees);
                    case 1 -> sortingAlgos.insertion_sort(employees);
                    case 2 -> sortingAlgos.merge_sort(employees);
                    case 3 -> sortingAlgos.quick_sort(employees);
                    case 4 -> sortingAlgos.selection_sort(employees);
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