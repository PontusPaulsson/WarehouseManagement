package warehouseproject.Orders;

import org.junit.Test;
import warehouseproject.Employees.Clerk;
import warehouseproject.Items.Item;
import warehouseproject.Stores.CentralStorage;
import warehouseproject.Stores.StoreMemory;

import static org.junit.Assert.*;

public class OrderTest {
    Order testOrder;
    Clerk testEmpoyee;
    StoreMemory testStore;
    Item testItem;

    public OrderTest(){
        testItem = new Item("TestItem", 1, 1);
        testStore = new StoreMemory("TestStore", "TestStreet", "100", "TestCity", "100");
        testEmpoyee = new Clerk("Test", 0, testStore);
        testOrder = new Order(testEmpoyee, OrderType.SELL);
    }
    @Test
    public void testAddItemToOrder() throws Exception {
        CentralStorage.addItem(1, 10);
        testStore.centralItemToStorage(1, 10);
        assertEquals(true, testOrder.addItemToOrder(1, 10));
    }
    @Test
    public void testExecuteOrder() throws Exception{
        assertEquals(true, testOrder.executeOrder());
    }
}