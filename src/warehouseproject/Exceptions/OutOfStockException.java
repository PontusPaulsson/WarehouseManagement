package warehouseproject.Exceptions;

import warehouseproject.Items.Item;

public class OutOfStockException extends Exception{   


    public OutOfStockException(Item item) {
        super("Item " + item.getName()+" ["+ item.getID()+ "]" +" is out of stock");
        
        
    }
    
    

}
