package petr.example;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TopMenuBar {
    public By buttonLogout = By.xpath("//a[@title='Logout']");
    private String x = String.valueOf($(buttonLogout).getText());
    public void clickLogout() {
        $(buttonLogout).click();
    }

    public void logoutShouldBeVisible() {
        $(buttonLogout).as("Logout button").shouldBe(Condition.visible.because("Logout button is not visible"));
        $(buttonLogout).shouldHave(Condition.text("Logout"));
        System.out.println("Text of Button is <" + x + ">");
    }
}
