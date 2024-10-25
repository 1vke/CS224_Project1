package cs224;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVExporter {
    public void export(ArrayList<Employee> employees, String csvFileName, String sortingAlgo) throws IOException {
        System.out.printf("Exporting \"%s\" sorted via \"%s\"\n", csvFileName, sortingAlgo);

        try (FileWriter writer = new FileWriter("sortedCSVS/"+csvFileName+"/"+sortingAlgo+".csv")) {
            writer.append("Id,FirstName,LastName,Age\n");

            for (Employee employee : employees) {
                writer.append(employee.toString());
                if (employees.indexOf(employee) != employees.size()-1) writer.append("\n");
            }
        }

        System.out.println("Exported "+csvFileName+"-"+sortingAlgo+"\n\n");
    }
}
