package petr.example;

import com.codeborne.selenide.Configuration;

public class BasedTestClass {
    public BasedTestClass() {
        Configuration.timeout=6000;
        Configuration.baseUrl = "http://localhost/litecart";
    }
}
