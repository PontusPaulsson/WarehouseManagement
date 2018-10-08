package warehouseproject.Stores;

import warehouseproject.Items.Item;
import warehouseproject.Exceptions.OutOfStockException;
import java.util.HashMap;

public class CentralStorage {

    public static HashMap<Integer, Integer> centralStorageMap = new HashMap<Integer, Integer>();
    public static int cash = 1000000;

    public static void addItem(int id, int amount) {
        centralStorageMap.put(id, amount);
    }

    public static void removeItem(int id, int amount) {
        boolean isZero = false;
        for (Integer itemID : centralStorageMap.keySet()) {
            if (itemID == id) {
                centralStorageMap.replace(id, centralStorageMap.get(id) - amount);
                if (centralStorageMap.get(id) == 0) {
                    isZero = true;
                }
            }
        }
        if (isZero) {
            Item tempItem = Item.getItemByID(id);
            System.out.println(tempItem.getName() + " reached 0 and has been removed from Central storage.");
            centralStorageMap.remove(id);
        }
    }

    public static boolean checkItemStock(int id, int amount) throws OutOfStockException {
     for (Integer itemID : centralStorageMap.keySet()) {
         if (itemID == id) {
             if (centralStorageMap.get(id) >= amount) {
                 return true;
             }
         }
     }
     Item tempItem = Item.getItemByID(id);
     throw new OutOfStockException(tempItem);
    }

    public static void deBugger() {
        Item i1 = new Item("Bultsax", 1, 299);
        Item i2 = new Item("Toapapper", 2, 29);
        Item i3 = new Item("Hammare", 3, 99);
        Item i4 = new Item("Brasse stol", 4, 199);
        Item i5 = new Item("Parasol", 5, 1599);

        centralStorageMap.put(i1.getID(), 5000);
        centralStorageMap.put(i2.getID(), 5000);
        centralStorageMap.put(i3.getID(), 5000);
        centralStorageMap.put(i4.getID(), 5000);
        centralStorageMap.put(i5.getID(), 5000);



    }

}
