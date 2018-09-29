package warehouseproject.Employees;

public class StoreManager extends Employee implements Managerable{

    public StoreManager(String name, int salary) {
        super(name, salary);
    }

    @Override
    public void fireEmployee() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
