package service;

import bean.Employee;

import java.util.List;

public interface EmployeeSaver {
    void save(List<Employee> list);
}
