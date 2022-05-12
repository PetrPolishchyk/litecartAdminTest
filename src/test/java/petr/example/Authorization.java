package petr.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.$;

public class Authorization {
    public static void auth(String login, String password) {
        //login
        Selenide.open("/admin/login.php?redirect_url=%2Flitecart%2Fadmin%2F");
        $(By.name("username")).setValue(login);
        $(By.name("password")).setValue(password);
        $(By.xpath("//div[@class='footer']/button")).click();
        //fill text logout from title into variable
        String x = String.valueOf($(By.xpath("//a[@title='Logout']")).getText());
        //check
        $x("//a[@title='Logout']").shouldBe(Condition.visible.because("Button "+x+" is not visible"));
        System.out.println("Login success");
    }
}
