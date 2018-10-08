package warehouseproject.Stores;

import warehouseproject.Exceptions.OutOfStockException;

public interface StoreInterface {
    void centralItemToStorage(int itemID,int amount);
    void buyItemFromCentralStorage(int itemID,int amount);
    void removeItem(int itemID,int amount);
    void sellItem(int itemID);
    String getStoreName();
    double getCash();
    boolean checkItemStock(int amount, int id) throws OutOfStockException;
}
