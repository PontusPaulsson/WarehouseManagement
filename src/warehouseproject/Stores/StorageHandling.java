package warehouseproject.Stores;

import warehouseproject.Exceptions.OutOfStockException;
import warehouseproject.Items.Item;

public abstract class StorageHandling {

    public static void getStorage(Store store) {
        Item tempItem = null;
        for (Integer itemID : store.storage.keySet()) {
            tempItem = Item.getItemByID(itemID);
            System.out.println("Item " + "[" + itemID + "] " + tempItem.getName() + ", Amount: " + store.storage.get(itemID));
        }
    }

    public static void moveItemFromCentralStorageToStore(int itemID, int amount, Store store) {
        Item tempItem = Item.getItemByID(itemID);
        try {
            if (CentralStorage.checkItemStock(itemID, amount)) {
                store.storage.put(itemID, amount);
                CentralStorage.removeItem(itemID, amount);
                buyItemFromCentralStorage(itemID, amount, store);
                System.out.println("Item: " + "[" + tempItem.getID() + "] " + tempItem.getName() + " moved from Central storage to warehouse storage");
                System.out.println("Amount: " + amount);
            }
        } catch (OutOfStockException e) {
            System.out.println(e);
        }
    }

    public static void buyItemFromCentralStorage(int itemId, int amount, Store store){
        Item tempItem = Item.getItemByID(itemId);
        double d = store.getCash();
        store.setCash(d -= tempItem.getPrice() * amount);
        CentralStorage.cash += tempItem.getPrice() * amount;
        //Add logic for handling to little money.
    }

    public static void removeItem(int id, int amount, Store store) {
        for (Integer itemID : store.storage.keySet()) {
            if (itemID == id) {
                store.storage.replace(id, store.storage.get(id) - amount);
            }

        }
    }

    public static void sellItem(int itemId, Store store){
        Item tempItem = Item.getItemByID(itemId);
        double d = store.getCash();
        store.setCash(d += tempItem.getPrice());
    }

    public static boolean checkItemStock(int itemId, int amount, Store store) throws OutOfStockException{
        for (Integer itemID : store.storage.keySet()) {
            if (itemID == itemID) {
                if (store.storage.get(itemId) >= amount) {
                    return true;
                }
            }
        }
        Item tempItem = Item.getItemByID(itemId);
        throw new OutOfStockException(tempItem, store);
    }
}
