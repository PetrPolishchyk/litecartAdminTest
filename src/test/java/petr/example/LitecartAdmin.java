package petr.example;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

@Test
public class LitecartAdmin {
    @Test
    public void testName (){
        Selenide.open("http://localhost/litecart/admin/login.php?redirect_url=%2Flitecart%2Fadmin%2F");
        System.out.println("Success");
    }
}
