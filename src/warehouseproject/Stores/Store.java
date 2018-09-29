package warehouseproject.Stores;

import java.util.HashMap;
import warehouseproject.Utility.Adress;
import warehouseproject.Items.Item;
import warehouseproject.Exceptions.OutOfStockException;


public class Store {

    private String storeName;
    private Adress adress;
    private int storeNumber;

    public HashMap<Integer, Integer> storage;

    public Store(String storeName, String streetName, String zipCode, String city, String phoneNumber) {
        this.storeName = storeName;
        this.adress = adress;
        storage = new HashMap<Integer, Integer>();
        this.adress = new Adress(streetName, zipCode, city, phoneNumber);
    }

    public void getStorage() {
        Item tempItem = null;
        for (Integer itemID : storage.keySet()) {
            tempItem = Item.getItemByID(itemID);
            System.out.println("Item " + "[" + itemID + "] " + tempItem.getName() + ", Amount: " + storage.get(itemID));

        }
    }

    public void centralItemToStorage(int itemID, int amount) {
        Item tempItem = Item.getItemByID(itemID);
        try {
            if (CentralStorage.checkItemStock(itemID, amount)) {
                storage.put(itemID, amount);
                CentralStorage.removeItem(itemID, amount);
                System.out.println("Item: " + "[" + tempItem.getID() + "] " + tempItem.getName() + " moved from Central storage to warehouse storage");
                System.out.println("Amount: " + amount);
            }
        } catch (OutOfStockException e) {
            System.out.println(e);
        }

    }

    public void removeItem(int id, int amount) {
        for (Integer itemID : storage.keySet()) {
            if (itemID == id) {
                storage.replace(id, storage.get(id) - amount);
            }

        }
    }

}
