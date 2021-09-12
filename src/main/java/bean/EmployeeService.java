package bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("employeeService")
public class EmployeeService {

    @Autowired
    private AgeSorter ageSorter;

    @Autowired
    private SalarySorter salarySorter;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private EmployeeFileSaver employeeFileSaver;

    @Autowired
    private MockEmployeeSaver mockEmployeeSaver;

    public void getHighestSalary(){
        List<Employee> employeeList = applicationContext.getBean("employeeList", List.class);
        double max = 0;
        for (int i = 0; i < employeeList.size(); i++) {
            if(employeeList.get(i).getSalary() > max){
                max = employeeList.get(i).getSalary();
            }
        }
        for (int i = 0; i < employeeList.size(); i++) {
            if(employeeList.get(i).getSalary() == max){
                System.out.println(employeeList.get(i));
            }
        }
    }

    public void getSorted(String choose){
        List<Employee> employeeList = applicationContext.getBean("employeeList", List.class);
        if(choose.contains("age")){
            System.out.println("List sort by age is: ");
            ageSorter.sort(employeeList);
            mockEmployeeSaver.save(employeeList);
        }else if(choose.contains("salary")){
            salarySorter.sort(employeeList);
            employeeFileSaver.save(employeeList);
            System.out.println("Save file successful");
        }
    }
}
