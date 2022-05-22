package petr.example;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPageAdmin {
    private By username = By.name("username");
    private By password = By.name("password");
    private By buttonLogin = By.xpath("//div[@class='footer']/button");
    public By allertText = By.xpath("//div[@class='alert alert-danger']");
    public By allertTextValue = By.xpath("//div[@class='alert alert-danger']/i");

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

    public void outAlertTextAfterAuth() {
        String a = String.valueOf($(allertText).getText());
        System.out.println("Visible text of alert:");
        System.out.println(a);
    }
}
