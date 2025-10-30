package com.dexterv.services.impl;

import com.dexterv.domain.Employee;
import com.dexterv.repositories.EmployeeData;
import com.dexterv.services.EmployeeService;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {


    private final List<Employee> employees;

    public EmployeeServiceImpl(List<Employee> employees) {

        this.employees = employees;;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employees.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Employee> getActiveEmployees() {
        return employees.stream()
                .filter(Employee::isActive)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getEmployeesSortedBySalaryDesc() {
        return List.of();
    }

    @Override
    public Set<String> getAllUniqueSkills() {
        return Set.of();
    }

    @Override
    public Map<String, Double> getAverageSalaryByDepartment() {
        return Map.of();
    }

    @Override
    public Optional<Employee> getTopEarner() {
        return Optional.empty();
    }

    @Override
    public Long countEmployeesWithSkill(String skill) {
        return 0L;
    }

    @Override
    public Map<String, Long> getActiveEmployeeCountByDepartment() {
        return Map.of();
    }

    @Override
    public List<Employee> getEmployeesSharingOneSkills() {
        return List.of();
    }

    @Override
    public List<Employee> getEmployeesBetweenSalary(double minSalary, double maxSalary) {
        return List.of();
    }
}
