package petr.example;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.testng.annotations.DataProvider;

public class Dataprovider {
    @Contract(value = " -> new", pure = true)
    @DataProvider(name = "users")
    public static Object[] @NotNull [] users() {
        return new Object[][]{
                new Object[]{"admin", "admin"},
                new Object[]{"peter", "passWord"},
        };
    }
}
