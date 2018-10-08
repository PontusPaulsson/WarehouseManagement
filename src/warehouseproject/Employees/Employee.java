package warehouseproject.Employees;

import warehouseproject.Stores.StoreMemory;

import java.util.ArrayList;

public abstract class Employee {

    private int id;
    private String name;
    private static int nEmployees = 0;
    private int salary;
    private int bonus;
    private StoreMemory store;
    
    private static ArrayList<Employee> employeeList = new ArrayList<>();

    public Employee(String name, int salary, StoreMemory store) {
        this.name = name;
        this.salary = salary;
        nEmployees++;
        this.id = nEmployees;
        employeeList.add(this);
        this.store = store;
    }

    public String getName() {
        return name;
    }

    public StoreMemory getStore() {
        return store;
    }

    public static ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public int getId() {
        return id;
    }
// Fortsätt implementera employee och låt dom ha en relation till en butik.




}
