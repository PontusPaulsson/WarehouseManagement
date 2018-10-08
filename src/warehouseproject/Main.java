package warehouseproject;

import warehouseproject.Employees.Clerk;
import warehouseproject.Orders.Order;
import warehouseproject.Orders.OrderType;
import warehouseproject.Stores.*;
import warehouseproject.Utility.Adress;

public class Main {

    public static void main(String[] args) {
        //Create and run centralstoragedebugger
        CentralStorage.deBugger();
        System.out.println("Centralstorage cash: " + CentralStorage.cash + "kr");
        //Create stores
        Store bromma = new Store("Bromma", new Adress("Bromma", "Bromma", "Bromma", "08-120120120"), 1);
        Store märsta = new Store("Märsta", new Adress("Märsta", "Märsta", "Märsta", "Märsta"), 2);
        Store årsta = new Store("Årsta", new Adress("Årsta", "Årsta", "Årsta", "Årsta"), 3);
        //Create clerks
        Clerk clerkPontus = new Clerk("Pontus Paulsson", 30000, märsta);
        Clerk clerkAndreas = new Clerk("Andreas Nedbal", 35000, bromma);
        Clerk clerkCamilla = new Clerk("Camilla Tranberg", 40000, årsta);


        //Print Årstacash
        System.out.println("Årsta kassa: " + årsta.getCash());

        //Move items from CentralStorage to Årsta
        StorageHandling.moveItemFromCentralStorageToStore(1, 100, årsta);
        StorageHandling.moveItemFromCentralStorageToStore(2, 100, årsta);
        StorageHandling.moveItemFromCentralStorageToStore(3, 100, årsta);
        StorageHandling.moveItemFromCentralStorageToStore(4, 100, årsta);

        //Move items from CentralStorage to Märsta
        StorageHandling.moveItemFromCentralStorageToStore(1, 200, märsta);
        StorageHandling.moveItemFromCentralStorageToStore(2, 200, märsta);
        StorageHandling.moveItemFromCentralStorageToStore(3, 200, märsta);
        StorageHandling.moveItemFromCentralStorageToStore(4, 200, märsta);

        //Add sell orders for clerks
        Order camillasOrder = new Order(clerkCamilla, OrderType.SELL, årsta);
        Order pontusOrder = new Order(clerkPontus, OrderType.SELL, märsta);
        Order pontus2Order = new Order(clerkPontus, OrderType.SELL, märsta);
        camillasOrder.addItemToOrder(1, 2);
        pontusOrder.addItemToOrder(2, 10);
        pontus2Order.addItemToOrder(2, 10);


        //Execute Order
        camillasOrder.executeOrder();
        pontusOrder.executeOrder();
        pontus2Order.executeOrder();
        System.out.println(camillasOrder);
        System.out.println(pontusOrder);
        System.out.println(pontus2Order);

        //Print Årstacash
        System.out.println("Årsta kassa: " + årsta.getCash());

        //Print CentralStorage Cash
        System.out.println("Centralstorage cash: " + CentralStorage.cash);

        //Print all orders
        Order.printAllOrder();

        //Print order toplist
        camillasOrder.printSellerTopList();

    }


}
