package warehouseproject;

import warehouseproject.Employees.Clerk;
import warehouseproject.Orders.Order;
import warehouseproject.Orders.OrderType;
import warehouseproject.Stores.CentralStorage;
import warehouseproject.Stores.Store;

public class Main {

    public static void main(String[] args) {
        //Create and run centralstoragedebugger
        CentralStorage.deBugger();
        System.out.println("Centralstorage cash: " + CentralStorage.cash + "kr");
        //Create stores
        Store bromma = new Store("Bromma", "Repslagarvägen 11", "12032", "Bromma", "08-120120120");
        Store märsta = new Store("Märsta", "Repslagarvägen 11", "12032", "Märsta", "08-120120120");
        Store årsta = new Store("Årsta", "Repslagarvägen 11", "12032", "Årsta", "08-120120120");

        //Create clerks
        Clerk clerkPontus = new Clerk("Pontus Paulsson", 30000, märsta);
        Clerk clerkAndreas = new Clerk("Andreas Nedbal", 35000, bromma);
        Clerk clerkCamilla = new Clerk("Camilla Tranberg", 40000, årsta);

        //Print Årstacash
        System.out.println("Årsta kassa: " + årsta.getCash());

        //Move items from CentralStorage to Årsta
        årsta.centralItemToStorage(1, 10);
        årsta.centralItemToStorage(2, 10);
        årsta.centralItemToStorage(3, 10);
        årsta.centralItemToStorage(4, 10);

        //Move items from CentralStorage to Märsta
        märsta.centralItemToStorage(1, 20);
        märsta.centralItemToStorage(2, 20);
        märsta.centralItemToStorage(3, 20);
        märsta.centralItemToStorage(4, 20);

        //Add sell orders for clerks
        Order camillasOrder = new Order(clerkCamilla, OrderType.SELL);
        Order pontusOrder = new Order(clerkPontus, OrderType.SELL);
        Order pontus2Order = new Order(clerkPontus, OrderType.SELL);
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
