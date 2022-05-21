package petr.example;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private By username = By.name("username");
    private By password = By.name("password");
    private By buttonLogin = By.xpath("//div[@class='footer']/button");

    public void loginAs(String user, String password) {
        Selenide.open("/admin/login.php?redirect_url=%2Flitecart%2Fadmin%2F");
        setLogin(user);
        setPassword(password);
        $(buttonLogin).click();
    }

    public void setPassword(String value) {
        $(password).clear();
        $(password).setValue(value);
    }

    public void setLogin(String value) {
        $(username).clear();
        $(username).setValue(value);
    }
}
