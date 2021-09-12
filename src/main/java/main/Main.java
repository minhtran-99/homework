package main;

import bean.Employee;
import bean.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choose = null;
        ApplicationContext context = new AnnotationConfigApplicationContext("bean");
        EmployeeService employeeService = context.getBean("employeeService", EmployeeService.class);
        System.out.println("Employee has high salary");
        employeeService.getHighestSalary();
        while (true){
            System.out.println("You want choose 'age' or 'salary'");
            choose = sc.nextLine();
            if(choose.contains("age") || choose.contains("salary")){
                employeeService.getSorted(choose);
                break;
            }else {
                System.err.println("Please choose 'age' or 'salary'");
            }
        }

    }
}
