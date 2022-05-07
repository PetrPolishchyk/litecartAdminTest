package petr.example;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

@Test
public class LitecartAdmin {
    @Test
    public void testName (){
        Selenide.open("http://localhost/litecart/admin/login.php?redirect_url=%2Flitecart%2Fadmin%2F");
        $(By.name("username")).setValue("admin");
        $(By.name("password")).setValue("admin");
        $(By.xpath("//div[@class='footer']/button")).click();
        $(By.xpath("//span[text()='Appearance']")).click();
        $(By.xpath("//i[@class='fa fa-sign-out']")).click();
        System.out.println("Success");
    }
}
