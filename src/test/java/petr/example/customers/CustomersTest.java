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
        $x("//a[@href='http://localhost/litecart/admin/?app=customers&doc=customers']/span[@title]").click();
        $x("//div[@class='panel-heading']").shouldBe(Condition.text("Customers").because("Customers is not present"));
        System.out.println("Customers is visible correctly");
        $x("//div[@class='btn-group']/button[1]").click();
        $x("//div[@class='alert alert-danger']").shouldBe(Condition.text("You must select customers"));
        $x("//div[@class='alert alert-danger']/i").click();
    }

    public void findAleksanderSmith (){
        $x("//a[@href='http://localhost/litecart/admin/?app=customers&doc=customers']/span[@title]").click();
        $x("//div[@class='panel-filter']//input[@type='search']").setValue("Alexander Smith").pressEnter();
    }

    @Test(groups = {"checkCustomers"}, priority = 2)
    public void checkForNotPresentAddingCustomer() {
        findAleksanderSmith();

    }

    @Test(groups = {"checkCustomers"}, priority = 3)
    public void addNewCustomer() {
        $x("//a[@href='http://localhost/litecart/admin/?app=customers&doc=edit_customer&page=1&sort=date_created']").click();
        $x("//label[text()='Email Address']/parent::div//input[@type='email']").clear();
        $x("//label[text()='Email Address']/parent::div//input[@type='email']").setValue("customer@gmail.com");
        $x("//input[@name='company']").setValue("customerCompany");
        $x("//input[@name='firstname']").setValue("Alexander");
        $x("//input[@name='lastname']").setValue("Smith");
        $x("//input[@name='address1']").setValue("Vinnitsya, Soborna str, 45");
        $x("//input[@name='postcode']").setValue("21054");
        $x("//input[@name='city']").setValue("Vinnitsya");
        $x("//select[@name='country_code']").selectOption("Ukraine");
        $x("//input[@name='phone']").setValue("+380971111111");
        $x("//input[@name='code']").setValue("102030");
        $x("//textarea[@name='notes']").setValue("Testing customer by autotest");
        $x("//input[@name='different_shipping_address']").setSelected(true);
        $x("//input[@name='shipping_address[company]']").shouldBe(Condition.visible.because("Chekbox not working"));
        $x("//input[@name='shipping_address[company]']").setValue("Different Company");
        $x("//button[@name='save']").click();
    }

    @AfterGroups(value = "checkCustomers")
    public void logout() {
        $x("//a[@title='Logout']").click();
    }
}
