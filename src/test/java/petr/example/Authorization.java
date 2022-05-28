package petr.example;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.screenshot;

@Feature("Авторизация")
public class Authorization extends BasedTestClass {
    //TODO на следующий раз Allure report

    @Test(description = "Авторизация пользователя", dataProvider = "users", dataProviderClass = DataProvider.class, groups = {"auth"})
    @Story("Проверяем может ли пользователь авторизоваться")
    @Issue("AAA-25")
    @TmsLink("TMS-25")
    public void usersCanAuthorise(String user, String password) {
        //login with users from Dataprovider
        new LoginPageAdmin().loginAs(user, password);
        //check for visible of TopBarButtons
        TopMenuBar topMenuBar = new TopMenuBar();
        topMenuBar.logoutShouldBeVisible();
        System.out.println("Login as <" + user + "> is success");
        topMenuBar.clickLogout();
    }

    @Test(description = "Блокирование пользователя",groups = {"auth"}, priority = 2)
    public void usersMustDisable() {
        //first try to type wrong pass
        LoginPageAdmin authForDisable = new LoginPageAdmin();
        authForDisable.loginAs("toblock", "noadmin");
        $(authForDisable.allertText).shouldBe(Condition.visible.because("Alert is not visible"));
        $(authForDisable.allertTextValue).shouldNot(Condition.text("You have 2 login attempts left until your account is temporarily blocked"));
        authForDisable.outAlertTextAfterAuth();
        //second try to type wrong pass
        authForDisable.loginAs("toblock", "noadmin");
        $(authForDisable.allertText).shouldBe(Condition.visible.because("Alert is not visible"));
        $(authForDisable.allertTextValue).shouldNot(Condition.text("You have 1 login attempts left until your account is temporarily blocked"));
        authForDisable.outAlertTextAfterAuth();
        //thirth try to type wrong pass
        authForDisable.loginAs("toblock", "noadmin");
        $(authForDisable.allertText).shouldBe(Condition.visible.because("Alert is not visible"));
        $(authForDisable.allertTextValue).shouldNot(Condition.text("This account has been temporarily blocked for 15 minutes"));
        authForDisable.outAlertTextAfterAuth();
        //try to login by disabled user
        authForDisable.loginAs("toblock", "toblock");
        $(authForDisable.allertText).shouldBe(Condition.visible.because("Alert is not visible"));
        $(authForDisable.allertTextValue).getText().contains("The account is blocked");
        authForDisable.outAlertTextAfterAuth();
    }

    @Test(groups = {"auth"}, priority = 1)
    public void userHasWrongUsername() {
        LoginPageAdmin authFotWrongUsername = new LoginPageAdmin();
        authFotWrongUsername.loginAs("porter", "passWord");
        $(authFotWrongUsername.allertText).shouldBe(Condition.visible.because("Alert is not visible"));
        $(authFotWrongUsername.allertTextValue).shouldNot(Condition.text("The user could not be found in our database")
                .because("The text of don't finding user is not present"));
        authFotWrongUsername.outAlertTextAfterAuth();
    }
}
