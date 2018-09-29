package warehouseproject.Items;

import java.util.ArrayList;

public class Item {

    private String name;
    private int ID;
    private double price;

    private static ArrayList<Item> itemList = new ArrayList<>();

    public Item(String name, int ID, double price) {
        this.name = name;
        this.ID = ID;
        this.price = price;
        itemList.add(this);
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", ID=" + ID + ", price=" + price + '}';
    }
    
    public static Item getItemByID(int id){
        for (Item item : itemList) {
            if(item.getID() == id){
                return item;
            }            
        }
        return null;
    }
}
