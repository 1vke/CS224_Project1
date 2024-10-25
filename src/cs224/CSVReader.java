package cs224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CSVReader {
    private InputStream getCSVInputStream(String csvFileName) {
        return getClass().getClassLoader().getResourceAsStream(csvFileName+".csv");
    }

    private ArrayList<Employee> getEmployeesFromInputStream(InputStream inputStream) throws IOException {
       ArrayList<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            br.readLine(); // Skips header row

            while ((line = br.readLine()) != null) {
                String[] employeeDetails = line.split(",");
                employees.add(new Employee(Integer.parseInt(employeeDetails[0]), employeeDetails[1], employeeDetails[2], Integer.parseInt(employeeDetails[3])));
            }
        }

        return employees;
    }

    public ArrayList<Employee> getEmployeesFromFile(String fileName) throws IOException {
        InputStream inputStream = getCSVInputStream(fileName);
        return getEmployeesFromInputStream(inputStream);
    }
}

