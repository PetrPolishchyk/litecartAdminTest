package petr.example;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TopMenuBar {
    public By buttonLogout = By.xpath("//a[@title='Logout']");
    private By buttonFrontend = By.xpath("//a[@title='Frontend']");
    private By buttonDataBase = By.xpath("//a[@title='Database Manager']");
    private By buttonControlPanel = By.xpath("//a[@title='Control Panel']");
    private By buttonWebmail = By.xpath("//a[@title='Webmail']");
    private By buttonToHideOrShowMenu = By.xpath("//label[@class='nav-toggle']");

    public void clickLogout() {
        $(buttonLogout).click();
    }

    public void clickFrontend() {
        $(buttonFrontend).click();
    }

    public void clickDataBase() {
        $(buttonDataBase).click();
    }

    public void clickControlPanel() {
        $(buttonControlPanel).click();
    }

    public void clickWebmail() {
        $(buttonWebmail).click();
    }
    public void clickButtonToHideOrShowMenu(){
        $(buttonToHideOrShowMenu).click();
    }

    public void logoutShouldBeVisible() {
        String x = String.valueOf($(buttonLogout).getText());
        $(buttonLogout).as("Logout button").shouldBe(Condition.visible.because("Logout button is not visible"));
        $(buttonLogout).shouldHave(Condition.text("Logout"));
        System.out.println("Text of button is <" + x + ">");
    }
}
