package petr.example;

import com.codeborne.selenide.*;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
//import static petr.example.Authorization.auth;

@Test
public class LitecartAdmin {

    public void testName (){
        //configurations
        Configuration.timeout=6000;
        Configuration.baseUrl = "http://localhost/litecart";
        //authorization admin/admin
        Authorization authorization = new Authorization();
        authorization.auth("admin", "admin");
        //check
        $(By.xpath("//span[text()='Appearance']")).click();
        $(By.xpath("//i[@class='fa fa-sign-out']")).click();
        //$x("//i[@class='fa fa-sign-out']").click();
        System.out.println("Success");

        //$("#submit").shouldBe(Condition.enabled).click();
        String x = String.valueOf($(By.xpath("//div[@class='footer']/button")).getValue());
        System.out.println(x);
        //SelenideElement input = $("#input").should(visible);
        //logout
        //$x("//i[@class='fa fa-sign-out']").click();
    }
}
