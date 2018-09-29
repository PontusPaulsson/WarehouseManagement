package warehouseproject.Orders;

import warehouseproject.Employees.Employee;
import warehouseproject.Exceptions.OutOfStockException;
import warehouseproject.Items.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class Order {
    public static HashMap<Order, Integer> allOrders = new HashMap<>();
    private HashMap<Item, Integer> itemList;
    private Employee employee;
    private int orderId;
    private OrderType orderType;
    private static int nOrders;

    public Order(Employee employee, OrderType orderType) {
        this.employee = employee;
        nOrders++;
        this.orderId = nOrders;
        this.orderType = orderType;
        itemList = new HashMap<>();
    }

    public  void addItemToOrder(int itemId, int amount){
        Item tempItem = Item.getItemByID(itemId);
        try{
            if(employee.getStore().checkItemStock(itemId, amount));
            itemList.put(tempItem, amount);
        } catch (OutOfStockException ex){
            System.out.println(ex);
        }
    }
    public void executeOrder(){
        allOrders.put(this, calculateOrderTotal());
        for (Item item : itemList.keySet()) {
            employee.getStore().removeItem(item.getID(), 1);
            employee.getStore().sellItem(item.getID());
        }
        System.out.println("Order [" + orderId + "] been added to the database.");
        //Write DB logic here
    }
    private int calculateOrderTotal(){
        double orderTotal = 0;
        for (Item item : itemList.keySet()) {
            orderTotal += item.getPrice() * itemList.get(item);
        }
        return (int) orderTotal;
    }
    private void showOrder(){
        for (Item items : itemList.keySet()) {
            System.out.println(items);
        }
    }

    @Override
    public String toString() {
        return "[" + this.orderId + "] [" + this.orderType + "] by [" + employee.getName() + "] in store [" + employee.getStore().getStoreName() + "] Worth [" + calculateOrderTotal() + "kr]";
    }
    public static void printAllOrder(){
        for (Order order : allOrders.keySet()) {
            System.out.println("OrderId [" + order.orderId + "] TotalCost [" + allOrders.get(order) + "]");
        }
    }

    public void printSellerTopList(){
        ArrayList<Employee> allEmployees = Employee.getEmployeeList();
        HashMap<Employee, Integer> orderTopList = new HashMap<>();
        for (Employee allEmployee : allEmployees) {
            orderTopList.put(employee, 0);
        }
        //Print stats about order

        for (Order order : allOrders.keySet()) {
            for(Employee emp : orderTopList.keySet()){
                if(order.employee.getId() == emp.getId()){
                    orderTopList.replace(order.employee, (orderTopList.get(emp) += allOrders.get(order)));
                }
            }


        }
    }
}
