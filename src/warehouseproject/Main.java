package warehouseproject;

import warehouseproject.Stores.CentralStorage;
import warehouseproject.Stores.Store;

public class Main {

    public static void main(String[] args) {
        Store bromma = new Store("Bromma", "Repslagarvägen 11", "12032", "Bromma", "08-120120120");

        
        CentralStorage.deBugger();

        System.out.println(CentralStorage.centralStorageMap.toString());

        bromma.centralItemToStorage(1, 10);

        System.out.println(CentralStorage.centralStorageMap.toString());

        bromma.getStorage();


    }

}
