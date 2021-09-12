package bean;

import org.springframework.stereotype.Component;
import service.Sorter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
public class SalarySorter implements Sorter {
    @Override
    public void sort(List<Employee> list) {
        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if(o1.getSalary() < o2.getSalary()) {
                    return -1;
                }
                return 1;
            }
        });
    }
}
