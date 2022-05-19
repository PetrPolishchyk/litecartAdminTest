package petr.example.customers;

import com.codeborne.selenide.Condition;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import petr.example.Authorization;

import static com.codeborne.selenide.Selenide.$x;

//@Test
public class CustomersTest {
    @BeforeGroups(value = "checkCustomers", dependsOnGroups = {"auth"})
    public void authorization() {
        Authorization auth = new Authorization();
        auth.authorization("admin", "admin");
    }
    @Test(groups = {"checkCustomers"}, priority = 1)
    public void checkCustomers() {
        $x("//a[@href='http://localhost/litecart/admin/?app=customers&doc=customers']").click();
        $x("//div[@class='panel-heading']").shouldBe(Condition.text("Customers").because("Customers is not present"));
        System.out.println("Customers is visible correctly");
        $x("//div[@class='btn-group']/button[1]").click();
        $x("//div[@class='alert alert-danger']").shouldBe(Condition.text("You must select customers"));
        $x("//div[@class='alert alert-danger']/i").click();
    }

    @Test(groups = {"checkCustomers"}, priority = 2)
    public void addNewCustomer() {

    }

    @AfterGroups(value = "checkCustomers")
    public void logout() {
        $x("//a[@title='Logout']").click();
    }
}
