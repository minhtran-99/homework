package bean;

import org.springframework.stereotype.Component;
import service.EmployeeSaver;
import java.util.List;

@Component
public class MockEmployeeSaver implements EmployeeSaver {
    @Override
    public void save(List<Employee> list) {
        for (Employee employee : list) {
            System.out.println(employee.toString());
        }
    }
}
