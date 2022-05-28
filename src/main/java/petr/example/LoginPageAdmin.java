package petr.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class LoginPageAdmin {
    private By username = By.name("username");
    private By usernameFake = By.cssSelector("azazazaza");
    private By password = By.name("password");
    private By buttonLogin = By.xpath("//div[@class='footer']/button");
    public By allertText = By.xpath("//div[@class='alert alert-danger']");
    public By allertTextValue = By.xpath("//div[@class='alert alert-danger']/i");

    @Step("Авторизуемся как {0}")
    public void loginAs(String user, String password) {
        Selenide.open("/admin/login.php?redirect_url=%2Flitecart%2Fadmin%2F");
        setLogin(user);
        setPassword(password);
        $(buttonLogin).click();
    }

    @Step("Устанавливаем пароль")
    public void setPassword(String value) {
        $(password).clear();
        $(password).setValue(value);
    }

    @Step("Устанавливаем логин {0}")
    public void setLogin(String value) {
        $(username).clear();
        $(username).setValue(value);
    }

    @Step("Проверяем текст всплывающего сообщения")
    public void outAlertTextAfterAuth() {
        String a = String.valueOf($(allertText).getText());
        System.out.println("Visible text of alert:");
        System.out.println(a);
    }
}
