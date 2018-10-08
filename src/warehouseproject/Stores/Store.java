package warehouseproject.Stores;

import warehouseproject.Utility.Adress;

import java.util.HashMap;

public class Store {

    private String storeName;
    private Adress adress;
    private int storeNumber;
    private double cash = 1000000;

    public HashMap<Integer, Integer> storage;

    public Store(String storeName, Adress adress, int storeNumber) {
        this.storeName = storeName;
        this.adress = adress;
        this.storeNumber = storeNumber;
        storage = new HashMap<Integer, Integer>();
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public double getCash() {

        return cash;
    }

    public String getStoreName() {
        return storeName;
    }
}
