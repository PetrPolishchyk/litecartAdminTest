package petr.example;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class DataProvider {
    @Contract(value = " -> new", pure = true)
    @org.testng.annotations.DataProvider(name = "users")
    public static Object[] @NotNull [] users() {
        return new Object[][]{
                new Object[]{"admin", "admin"},
                new Object[]{"peter", "passWord"},
        };
    }
}
