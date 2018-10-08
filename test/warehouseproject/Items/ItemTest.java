package warehouseproject.Items;

import org.junit.Test;
import warehouseproject.Employees.Employee;

import static org.junit.Assert.*;

public class ItemTest {
    Item item;
    public ItemTest(){
        item = new Item("TestItem", 1, 1);
    }

    @Test
    public void testGetItemName() throws Exception{

        assertEquals("TestItem", item.getName());
    }
    @Test
    public void testGetItemById() throws Exception{
        assertEquals(1, item.getID());
    }
    @Test
    public void testItemPrice(){
        assertEquals(1, item.getPrice(), 0);
    }
}