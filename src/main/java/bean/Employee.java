package bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;

    public Employee(){
    }

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() { return age; }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee" + id +
                ": Id= " + id +
                ", Name= " + name +
                ", Age= " + age +
                ", Salary= " + salary;
    }

    @Bean(name = "employeeList")
    public List<Employee> employeeList(){
        List<Employee> listEmploy = new ArrayList<>();
        Employee employee = null;
        for (int i = 1; i < 11; i++) {
            employee = new Employee();
            employee.setId(i);
            employee.setName("Employee-" + i);
            employee.setAge(ThreadLocalRandom.current().nextInt(18,60));
            employee.setSalary(ThreadLocalRandom.current().nextDouble(1.0, 9.9));
            listEmploy.add(employee);
        }
        return listEmploy;
    }

}
