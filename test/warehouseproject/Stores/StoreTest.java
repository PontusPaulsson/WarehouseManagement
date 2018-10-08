package warehouseproject.Stores;

import warehouseproject.Utility.Adress;

public class StoreTest {
    Store store;

    public StoreTest(){
        store = new Store("TestStore", new Adress("TestStreet", "TestZipecode", "TestCity", "TestPhone"), 100);

    }

}