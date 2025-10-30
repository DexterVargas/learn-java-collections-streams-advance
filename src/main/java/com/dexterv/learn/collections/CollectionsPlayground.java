package com.dexterv.learn.collections;

import com.dexterv.domain.Employee;
import com.dexterv.repositories.EmployeeData;
import com.dexterv.services.EmployeeService;
import com.dexterv.services.impl.EmployeeServiceImpl;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionsPlayground {

    List<Employee> employees;

    private final EmployeeService employeeService;

    public CollectionsPlayground() {
        this.employees = EmployeeData.getEmployees();
        this.employeeService = new EmployeeServiceImpl(employees);
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

        // 6️⃣ Find highest-paid employee
        Employee topEarner = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();

        System.out.println("\n Highest-paid employee is: " + topEarner);

        // 7️⃣ Map employee name -> salary
        Map<String, Double> salaryMap = employees.stream()
                .collect(Collectors.toMap(Employee::getName, Employee::getSalary));

        System.out.println("\n Map<String, Double> | Map Employee and salary");
        for (Map.Entry<String, Double> items : salaryMap.entrySet()) {
            String name = items.getKey();
            Double salary = salaryMap.get(name);
            System.out.println("\t" + name + ": " + salary);
        }

        // Find the TOP 3 earners per Department
        Map<String, List<Employee>> top3EarnerPerDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .filter(Employee::isActive)
                                        .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                        .limit(3)
                                        .collect(Collectors.toList())

                        )
                        ));

        System.out.println("\n Get the Top 3 earners per Department");
        for (Map.Entry<String, List<Employee>> items : top3EarnerPerDepartment.entrySet()) {
            String department = items.getKey();
            List<Employee> employeeList = items.getValue();
            System.out.println("\t" + department + ":");
            for (Employee employee : employeeList) {
                System.out.println("\t\t" + employee);
            }
        }

        // Generate a report: Department -> Total Active Employees
        Map<String, Long> totalActiveEmployeePerDepartment = employees.stream()
                .filter(Employee::isActive)
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.counting()));

        System.out.println("\n Total active employees per Department : " +  totalActiveEmployeePerDepartment);

        // TODO: Find employees sharing at least one skill
        // TODO: Count how many employees have “Java” as a skill
        // TODO: Convert to JSON (using Jackson) to simulate API response
        // TODO: Get Employee that have Salary between 85000 ~ 105000
    }

    public void employeeMap(){
        System.out.println("\n**********____Employee getEmployeeById(int id);");
        Employee employee = employeeService.getEmployeeById(1);
        System.out.println(employee);
        System.out.println(employee.getId() + "\n" + employee.getName() + "\n" + employee.getDepartment() + "\n" + employee.getSalary() + "\n" + employee.isActive() );
        System.out.println(String.join(", ", employee.getSkills()));


        System.out.println("\n**********____List<Employee> getAllEmployees();");
        List<Employee> allEmployees = employeeService.getAllEmployees();
        for (Employee employee1 : allEmployees) {
            System.out.println(employee1);
        }

        System.out.println("\n**********____List<Employee> getActiveEmployees();");
        List<Employee> allActiveEmployees = employeeService.getActiveEmployees();
        for (Employee employee1 : allActiveEmployees) {
            System.out.println(employee1);
        }

//        List<Employee> getEmployeesSortedBySalaryDesc();
//        Set<String> getAllUniqueSkills();
//        Map<String, Double> getAverageSalaryByDepartment();
//        Optional<Employee> getTopEarner();
//        Long countEmployeesWithSkill(String skill);
//        Map<String, Long> getActiveEmployeeCountByDepartment();
//        List<Employee> getEmployeesSharingOneSkills();
//        List<Employee> getEmployeesBetweenSalary( double minSalary, double maxSalary);
    }
}
