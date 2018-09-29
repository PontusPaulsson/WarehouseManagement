package warehouseproject.Stores;

import java.util.HashMap;
import warehouseproject.Utility.Adress;
import warehouseproject.Items.Item;
import warehouseproject.Exceptions.OutOfStockException;


public class Store {

    private String storeName;
    private Adress adress;
    private int storeNumber;
    private double cash = 10000;

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
                buyItemFromCentralStorage(itemID, amount);
                System.out.println("Item: " + "[" + tempItem.getID() + "] " + tempItem.getName() + " moved from Central storage to warehouse storage");
                System.out.println("Amount: " + amount);
            }
        } catch (OutOfStockException e) {
            System.out.println(e);
        }

    }
    private void buyItemFromCentralStorage(int itemId, int amount){
        Item tempItem = Item.getItemByID(itemId);
        cash -= tempItem.getPrice() * amount;
        CentralStorage.cash += tempItem.getPrice() * amount;
        //Add logic for handling to little money.
    }
    public void removeItem(int id, int amount) {
        for (Integer itemID : storage.keySet()) {
            if (itemID == id) {
                storage.replace(id, storage.get(id) - amount);
            }

        }
    }
    public void sellItem(int itemId){
        Item tempItem = Item.getItemByID(itemId);
        cash += tempItem.getPrice();
    }
    public String getStoreName() {
        return storeName;
    }

    public double getCash() {
        return cash;
    }
    public boolean checkItemStock(int itemId, int amount) throws OutOfStockException{
        for (Integer itemID : storage.keySet()) {
            if (itemID == itemID) {
                if (storage.get(itemId) >= amount) {
                    return true;
                }
            }
        }
        Item tempItem = Item.getItemByID(itemId);
        throw new OutOfStockException(tempItem, this);
    }
}
