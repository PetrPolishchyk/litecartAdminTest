package petr.example;

import org.testng.annotations.DataProvider;

public class Dataprovider {
    @DataProvider(name = "users")
    public static Object[][] users() {
        return new Object[][]{
                new Object[]{"admin", "admin"},
                new Object[]{"peter", "passWord"},
        };
    }
}
