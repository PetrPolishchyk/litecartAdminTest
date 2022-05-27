package petr.example.customers;

import com.codeborne.selenide.Condition;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import petr.example.Authorization;
import petr.example.LeftSideBar;
import petr.example.LoginPageAdmin;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

//@Test
public class CustomersTest {
    @BeforeGroups(value = "checkCustomers", dependsOnGroups = {"auth"})
    public void authorization() {
        new LoginPageAdmin().loginAs("admin", "admin");
    }

    @Test(groups = {"checkCustomers"}, priority = 1)
    public void checkCustomers() {
        new LeftSideBar().pressCustomers();
        $x("//div[@class='panel-heading']").shouldBe(Condition.text("Customers").because("Customers is not present"));
        System.out.println("Customers is visible correctly");
        $x("//div[@class='btn-group']/button[1]").click();
        $x("//div[@class='alert alert-danger']").shouldBe(Condition.text("You must select customers"));
        $x("//div[@class='alert alert-danger']/i").click();
    }

    @Test(groups = {"checkCustomers"}, priority = 2)
    public void addNewCustomer() {
        new LeftSideBar().pressCustomers();
        $x("//a[@href='http://localhost/litecart/admin/?app=customers&doc=edit_customer&page=1&sort=date_created']").click();
        $x("//label[text()='Email Address']/parent::div//input[@type='email']").clear();
        $x("//label[text()='Email Address']/parent::div//input[@type='email']").setValue("customer@gmail.com");
        $x("//input[@name='company']").setValue("customerCompany");
        String randString = RandomStringUtils.randomNumeric(5);
        String nameCustomer = "Alexander" + randString;
        $x("//input[@name='firstname']").setValue(nameCustomer);
        $x("//input[@name='lastname']").setValue("Smith");
        $x("//input[@name='address1']").setValue("Vinnitsya, Soborna str, 45");
        $x("//input[@name='postcode']").setValue("21054");
        $x("//input[@name='city']").setValue("Vinnitsya");
        $x("//select[@name='country_code']").selectOption("Ukraine");
        $x("//input[@name='phone']").setValue("+380971111111");
        $x("//input[@name='new_password']").setValue("123456");
        $x("//input[@name='code']").setValue("102030");
        $x("//textarea[@name='notes']").setValue("Testing customer by autotest");
        $x("//input[@name='different_shipping_address']").setSelected(true);
        $x("//input[@name='shipping_address[company]']").shouldBe(Condition.visible.because("Chekbox not working"));
        $x("//input[@name='shipping_address[company]']").setValue("Different Company");
        $x("//button[@name='save']").click();
    }

    private void findAddedCustomer(String nameOfCustoner) {
        $x("//a[@href='http://localhost/litecart/admin/?app=customers&doc=customers']/span[@title='Customers']").click();
        $x("//div[@class='panel-filter']//input[@type='search']").setValue(nameOfCustoner).pressEnter();
        boolean existAddedCustomer = $x("//div[@class='panel-body']/form/table/tbody/tr/td[starts-with(text(),'Alexander')]").exists();
        System.out.println(existAddedCustomer);
        if (existAddedCustomer == true) {
            System.out.println("Added customer is present in the list");
        } else System.out.println("Added customer is not present in the list");
    }

    @Test(groups = {"checkCustomers"}, priority = 3)
    public void disableOfCustomer() {
        findAddedCustomer("Alexander");
        $x("//div[@class='panel-body']/form/table/tbody/tr/td[1]").click();
        $x("//button[@name='disable']").click();
        //$x("//div[@class='panel-body']/form/table/tbody/tr").shouldBe(Condition.hidden);
        $x("//div[@class='panel-body']/form/table/tbody/tr/td[1]").click();
        $x("//button[@name='enable']").click();
        $x("//div[@class='panel-body']/form/table/tbody/tr").shouldBe(Condition.visible);
    }

    @Test(groups = {"checkCustomers"}, priority = 4)
    public void deleteAddedCustomer() {
        findAddedCustomer("Alexander");
        $x("//div[@class='panel-body']//i[@class='fa fa-pencil']").click();
        $x("//input[@name='firstname']").getText().contains("Alexander");
        $x("//button[@name='delete']").click();
        $x("//button[@name='delete']").pressEnter();
    }

    @AfterGroups(value = "checkCustomers")
    public void logout() {
        $x("//a[@title='Logout']").click();
    }
}
