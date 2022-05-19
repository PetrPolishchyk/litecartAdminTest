package petr.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.$;
//@Test
public class Authorization extends BasedTestClass{
    public void authorization (String user, String password){
        Selenide.open("/admin/login.php?redirect_url=%2Flitecart%2Fadmin%2F");
        $(By.name("username")).clear();
        $(By.name("username")).setValue(user);
        $(By.name("password")).clear();
        $(By.name("password")).setValue(password);
        $(By.xpath("//div[@class='footer']/button")).click();
    }
    @Test(dataProvider = "users", dataProviderClass = Dataprovider.class, groups = {"auth"})
    public void usersCanAuthorise(String user, String password) {
        //login
        authorization(user, password);
        //fill text logout from title into variable
        String x = String.valueOf($(By.xpath("//a[@title='Logout']")).getText());
        //check
        $x("//a[@title='Logout']").shouldBe(Condition.visible.because("Element "+x+" is not visible"));
        System.out.println("Login as <" + user + "> is success");
        $x("//a[@title='Logout']").click();
    }

    public void outAlertTextAfterAuth(){
        String a = String.valueOf($(By.xpath("//div[@class='alert alert-danger']")).getText());
        System.out.println("Visible text of alert:");
        System.out.println(a);
    }

    @Test(groups = {"auth"}, priority = 2)
    public void usersMustToDisable() {
        //first try to type wrong pass
        authorization("toblock", "noadmin");
        $x("//div[@class='alert alert-danger']").shouldBe(Condition.visible.because("Alert is not visible"));
        $x("//div[@class='alert alert-danger']/i").shouldNot(Condition.text("You have 2 login attempts left until your account is temporarily blocked"));
        outAlertTextAfterAuth();
        //second try to type wrong pass
        authorization("toblock", "noadmin");
        $x("//div[@class='alert alert-danger']").shouldBe(Condition.visible.because("Alert is not visible"));
        $x("//div[@class='alert alert-danger']/i").shouldNot(Condition.text("You have 1 login attempts left until your account is temporarily blocked"));
        outAlertTextAfterAuth();
        //thirth try to type wrong pass
        authorization("toblock", "noadmin");
        $x("//div[@class='alert alert-danger']").shouldBe(Condition.visible.because("Alert is not visible"));
        $x("//div[@class='alert alert-danger']/i").shouldNot(Condition.text("This account has been temporarily blocked for 15 minutes"));
        outAlertTextAfterAuth();
        //try to login by disabled user
        authorization("toblock", "toblock");
        $x("//div[@class='alert alert-danger']").shouldBe(Condition.visible.because("Alert is not visible"));
        $x("//div[@class='alert alert-danger']/i").getText().contains("The account is blocked");
        outAlertTextAfterAuth();
    }

    @Test(groups = {"auth"}, priority = 1)
    public void userHasWrongUsername() {
        authorization("porter", "passWord");
        $x("//div[@class='alert alert-danger']").shouldBe(Condition.visible.because("Alert is not visible"));
        $x("//div[@class='alert alert-danger']/i").shouldNot(Condition.text("The user could not be found in our database")
                .because("The text of don't finding user is not present"));
        outAlertTextAfterAuth();
    }
}
