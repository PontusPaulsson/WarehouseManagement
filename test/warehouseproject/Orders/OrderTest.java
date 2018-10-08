package warehouseproject.Orders;

import org.junit.Test;
import warehouseproject.Employees.Clerk;
import warehouseproject.Items.Item;
import warehouseproject.Stores.CentralStorage;
import warehouseproject.Stores.Store;
import warehouseproject.Stores.StorageHandling;
import warehouseproject.Utility.Adress;

import static org.junit.Assert.*;

public class OrderTest {
    Order testOrder;
    Clerk testEmpoyee;
    Store testStore;
    Item testItem;

    public OrderTest(){
        testItem = new Item("TestItem", 1, 1);
        testStore = new Store("TestStore", new Adress("TestStreet", "TestZipecode", "TestCity", "TestPhone"), 100);
        testEmpoyee = new Clerk("Test", 0, testStore);
        testOrder = new Order(testEmpoyee, OrderType.SELL, testStore);
    }
    @Test
    public void testAddItemToOrder() throws Exception {
        CentralStorage.addItem(1, 10);
        StorageHandling.moveItemFromCentralStorageToStore(1, 10, testStore);
        assertEquals(true, testOrder.addItemToOrder(1, 10));
    }
    @Test
    public void testExecuteOrder() throws Exception{
        assertEquals(true, testOrder.executeOrder());
    }
}