package petr.example;

import com.codeborne.selenide.*;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.Selenide.$;

@Test
public class LitecartAdmin {
    @Test
    public void testName (){

        Configuration.timeout=6000;
        Selenide.open("http://localhost/litecart/admin/login.php?redirect_url=%2Flitecart%2Fadmin%2F");
        $(By.name("username")).setValue("admin");
        $(By.name("password")).setValue("admin");
        $(By.xpath("//div[@class='footer']/button")).click();
        $(By.xpath("//span[text()='Appearance']")).click();
        $(By.xpath("//i[@class='fa fa-sign-out']")).click();
        System.out.println("Success");

        //$("#submit").shouldBe(Condition.enabled).click();
        String x = String.valueOf($(By.xpath("//div[@class='footer']/button")).getValue());
        System.out.println(x);
        //SelenideElement input = $("#input").should(visible);
    }
}
