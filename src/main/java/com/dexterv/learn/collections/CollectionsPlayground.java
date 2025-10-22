package com.dexterv.learn.collections;

import com.dexterv.domain.Employee;
import com.dexterv.repository.EmployeeData;
import org.w3c.dom.ls.LSOutput;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionsPlayground {

    List<Employee> employees;


    public CollectionsPlayground() {
        this.employees = EmployeeData.getEmployees();
    }

    public void employeeData(){
        // 1️⃣ Filter active employees
        List<Employee> activeEmployees = employees.stream()
                .filter(Employee::isActive)
                .collect(Collectors.toList()); // can be replace with toList();
        System.out.println("\nGet Active Employees:");
        for (Employee employee : activeEmployees) {
            System.out.println(employee);
        }

        // 2️⃣ Sort employees by salary descending
        List<Employee> sortedBySalary = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .toList();

        System.out.println("\nSort By Salary:");
        for (Employee employee : sortedBySalary) {
            System.out.println(employee);
        }

        // 3️⃣ Group by department
        Map<String, List<Employee>> groupByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("\n Map<String, List<Employee>> | Grouped By Department:");
        for (Map.Entry<String, List<Employee>> items : groupByDepartment.entrySet()) {

            String department = items.getKey();
            List<Employee> employees = items.getValue();

            System.out.println("\t" + department + ":");
            for (Employee employee : employees) {
                System.out.println("\t\t" + employee);
            }

        }

        // 4️⃣ Extract all unique skills
        Set<String> allSkills = employees.stream()
                .flatMap(e -> e.getSkills().stream())
                .collect(Collectors.toSet());

        System.out.println("\nSet<String> | flatMap | All Skills:");
        for (String skill : allSkills) {
            System.out.println(skill);
        }

        // 5️⃣ Average salary per department
        Map<String, Double> avgSalaryByDepartment = employees.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)
                        ));

        System.out.println("\n Map<String, Double> | Get Average Salary By Department");
        for (Map.Entry<String, Double> items : avgSalaryByDepartment.entrySet()) {
            String department = items.getKey();
            Double salary = avgSalaryByDepartment.get(department);

            System.out.println("\t" + department + ": " + salary);
        }
    }
}
