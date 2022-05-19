package petr.example.customers;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import petr.example.Authorization;
//@Test
public class CustomersTest {
    @BeforeGroups(value = "checkCustomers", dependsOnGroups = {"auth"})
    public void authorization() {
        Authorization auth = new Authorization();
        auth.authorization("admin", "admin");
    }
    @Test(groups = {"checkCustomers"}, priority = 1)
    public void checkCustomers() {

    }
}
