package com.dexterv.services;

import com.dexterv.domain.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    List<Employee> getActiveEmployees();
    List<Employee> getEmployeesSortedBySalaryDesc();
    Set<String> getAllUniqueSkills();
    Map<String, Double> getAverageSalaryByDepartment();
    Optional<Employee> getTopEarner();
    Long countEmployeesWithSkill(String skill);
    Map<String, Long> getActiveEmployeeCountByDepartment();
    List<Employee> getEmployeesSharingOneSkills();
    List<Employee> getEmployeesBetweenSalary( double minSalary, double maxSalary);
}
