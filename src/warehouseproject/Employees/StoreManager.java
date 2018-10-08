package warehouseproject.Employees;

import warehouseproject.Stores.StoreMemory;

public class StoreManager extends Employee implements Managerable{

    public StoreManager(String name, int salary, StoreMemory store) {
        super(name, salary, store);
    }

    @Override
    public void fireEmployee() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
