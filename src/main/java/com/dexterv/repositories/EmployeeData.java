package com.dexterv.repositories;

import com.dexterv.domain.Employee;

import java.util.Arrays;
import java.util.List;

public class EmployeeData {

    public static List<Employee> getEmployees(){
        return List.of(
                new Employee(1, "Alice", "Engineering", 90000, Arrays.asList("Java", "Spring", "Docker"), true),
                new Employee(2, "Bob", "Engineering", 85000, Arrays.asList("Java", "React", "AWS"), true),
                new Employee(3, "Charlie", "HR", 60000, Arrays.asList("Communication", "Recruitment"), true),
                new Employee(4, "Diana", "Finance", 95000, Arrays.asList("Excel", "Accounting", "Budgeting"), false),
                new Employee(5, "Eve", "Engineering", 105000, Arrays.asList("Java", "Kubernetes", "Microservices"), true),
                new Employee(6, "Frank", "Sales", 70000, Arrays.asList("Negotiation", "CRM"), true),
                new Employee(7, "Grace", "Marketing", 75000, Arrays.asList("SEO", "Content Creation", "Social Media"), true),
                new Employee(8, "Henry", "Engineering", 110000, Arrays.asList("Python", "Machine Learning", "TensorFlow"), true),
                new Employee(9, "Ivy", "HR", 55000, Arrays.asList("Employee Relations", "Onboarding"), false),
                new Employee(10, "Jack", "Sales", 120000, Arrays.asList("Client Management", "Strategy"), true),
                new Employee(11, "Kelly", "Finance", 88000, Arrays.asList("Financial Analysis", "SAP"), true)
        );
    }
}
