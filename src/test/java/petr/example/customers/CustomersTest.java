package petr.example.customers;

import org.testng.annotations.Test;
import petr.example.Authorization;
@Test
public class CustomersTest {
    @Test
    public void authorization() {
        Authorization auth = new Authorization();
        auth.usersCanAuthorise("admin", "admin");
    }
    @Test
    public void checkCustomers() {

    }
}
