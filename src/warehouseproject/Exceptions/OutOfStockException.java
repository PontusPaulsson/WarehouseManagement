package warehouseproject.Exceptions;

import warehouseproject.Items.Item;
import warehouseproject.Stores.Store;

public class OutOfStockException extends Exception{   


    public OutOfStockException(Item item) {
        super("Item " + item.getName()+" ["+ item.getID()+ "]" +" is out of stock");
        
        
    }
    public OutOfStockException(Item item, Store store) {
        super("Item " + item.getName()+" ["+ item.getID()+ "]" +" is out of stock in store [" + store.getStoreName() + "]");


    }
    
    

}
