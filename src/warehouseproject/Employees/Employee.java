package warehouseproject.Employees;

import java.util.ArrayList;

public abstract class Employee {

    private int id;
    private String name;
    private static int nEmployees = 0;
    private int salary;
    private int bonus;
    
    private static ArrayList<Employee> employeeList = new ArrayList<>();

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
        nEmployees++;
        this.id = nEmployees;
        employeeList.add(this);
    }
    
    // Fortsätt implementera employee och låt dom ha en relation till en butik.

}
