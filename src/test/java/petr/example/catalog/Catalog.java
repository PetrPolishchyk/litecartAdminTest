package petr.example.catalog;

import org.testng.annotations.Test;

public class Catalog {
    @Test(groups = {"checkCatalog"}, dependsOnGroups = {"checkCustomers"})
    public void checkCatalog() {
    }
}
