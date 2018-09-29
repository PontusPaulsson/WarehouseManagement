package warehouseproject.Stores;

import warehouseproject.Items.Item;
import warehouseproject.Exceptions.OutOfStockException;
import java.util.HashMap;

public class CentralStorage {

    public static HashMap<Integer, Integer> centralStorageMap = new HashMap<Integer, Integer>();

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
        Item bultsax = new Item("Bultsax", 1, 299);
        Item toapapper = new Item("Toapapper", 2, 29);
        Item hammare = new Item("Hammare", 3, 99);
        Item brasseStol = new Item("Brasse stol", 4, 199);
        Item parasol = new Item("Parasol", 5, 1599);

        centralStorageMap.put(bultsax.getID(), 10);
        centralStorageMap.put(toapapper.getID(), 10);
        centralStorageMap.put(hammare.getID(), 10);
        centralStorageMap.put(brasseStol.getID(), 10);
        centralStorageMap.put(parasol.getID(), 10);

    }

}
