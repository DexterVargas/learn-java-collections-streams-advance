package com.dexterv.learn.collections;

import com.dexterv.domain.Employee;
import com.dexterv.repository.EmployeeData;
import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.stream.Collectors;

public class CollectionsPlayground {

    List<Employee> employees;


    public CollectionsPlayground() {
        this.employees = EmployeeData.getEmployees();
    }

    public void employeeData(){
        // filter active players
        List<Employee> activeEmployees = employees.stream()
                .filter(Employee::isActive)
                .collect(Collectors.toList()); // can be replace with toList();

        for (Employee employee : activeEmployees) {
            System.out.println(employee);
        }
    }
}
