package petr.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

public class BasedTestClass {
    public BasedTestClass() {
        Configuration.timeout = 6000;
        Configuration.baseUrl = "http://localhost/litecart";
        SelenideLogger.addListener("AllureSelenide",
                        new AllureSelenide()
                                .includeSelenideSteps(false)
                                .screenshots(true)
        );

    }
}
