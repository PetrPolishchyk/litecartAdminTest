package petr.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.$;
@Test
public class Authorization extends BasedTestClass{
    @Test(dataProvider = "users", dataProviderClass = Dataprovider.class)
    public void usersCanAuthorise(String user, String password) {
        //login
        Selenide.open("/admin/login.php?redirect_url=%2Flitecart%2Fadmin%2F");
        $(By.name("username")).setValue(user);
        $(By.name("password")).setValue(password);
        $(By.xpath("//div[@class='footer']/button")).click();
        //fill text logout from title into variable
        String x = String.valueOf($(By.xpath("//a[@title='Logout']")).getText());
        //check
        $x("//a[@title='Logout']").shouldBe(Condition.visible.because("Element "+x+" is not visible"));
        System.out.println("Login us <" + user + "> is success");
    }

    @Test
    public void usersHasWrongPassword() {

    }
}
