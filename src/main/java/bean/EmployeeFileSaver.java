package bean;

import org.springframework.stereotype.Component;
import service.EmployeeSaver;

import java.io.*;
import java.util.List;

@Component
public class EmployeeFileSaver implements EmployeeSaver {

    @Override
    public void save(List<Employee> list) {
        File file = new File("D://employee.txt");
        FileWriter fileout = null;
        try {
            fileout = new FileWriter(file);
            for (Employee employee : list) {
                String line = employee.toString();
                fileout.write(line + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileout != null) {
                try {
                    fileout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
