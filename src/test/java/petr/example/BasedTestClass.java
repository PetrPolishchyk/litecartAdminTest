package petr.example;

import com.codeborne.selenide.Configuration;
//import static petr.example.Authorization.auth;

public class BasedTestClass {
    public BasedTestClass() {
        Configuration.timeout=6000;
        Configuration.baseUrl = "http://localhost/litecart";
    }
}
