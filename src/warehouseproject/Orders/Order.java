package warehouseproject.Orders;

import warehouseproject.Employees.Employee;
import warehouseproject.Exceptions.OutOfStockException;
import warehouseproject.Items.Item;

import java.time.LocalDate;
import java.util.*;

public class Order {
    public static HashMap<Order, Integer> allOrders = new HashMap<>();
    private HashMap<Item, Integer> itemList;
    private Employee employee;
    private int orderId;
    private OrderType orderType;
    private static int nOrders;
    private LocalDate date;

    public Order(Employee employee, OrderType orderType) {
        this.employee = employee;
        nOrders++;
        this.orderId = nOrders;
        this.orderType = orderType;
        itemList = new HashMap<>();
        date = LocalDate.now();

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
        HashMap<Employee, Integer> orderTopList = new HashMap<>();

        for(Employee emp : Employee.getEmployeeList()){
            orderTopList.put(emp, 0);
        }
        for(Order order : allOrders.keySet()){
            orderTopList.replace(order.employee, allOrders.get(order) + orderTopList.get(order.employee));
        }
        List<Integer> orderSortedTopList = new ArrayList<>(orderTopList.values());
        orderSortedTopList.sort((o1, o2) -> o2-o1);
        for(Integer integer : orderSortedTopList){
            for(Employee emp : orderTopList.keySet()){
                if(integer == orderTopList.get(emp)){
                    System.out.println(emp.getName() + " - " + integer + "kr");
                }
            }
        }
    }

    public LocalDate getDate() {
        return date;
    }
}
