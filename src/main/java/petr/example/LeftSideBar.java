package petr.example;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LeftSideBar {
    private By customers = By.xpath("//a[@href='http://localhost/litecart/admin/?app=customers&doc=customers']/span[@title='Customers']");
    private By appearance = By.xpath("//a[@href='http://localhost/litecart/admin/?app=appearance&doc=template']/span[@title='Appearance']");
    private By catalog = By.xpath("//a[@href='http://localhost/litecart/admin/?app=catalog&doc=catalog']/span[@title='Catalog']");
    private By countries = By.xpath("//a[@href='http://localhost/litecart/admin/?app=countries&doc=countries']/span[@title='Countries']");
    private By currencies = By.xpath("//a[@href='http://localhost/litecart/admin/?app=currencies&doc=currencies']/span[@title='Currencies']");
    private By geoZones = By.xpath("//a[@href='http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones']/span[@title='Geo Zones']");
    private By languages = By.xpath("//a[@href='http://localhost/litecart/admin/?app=languages&doc=languages']/span[@title='Languages']");
    private By modules = By.xpath("//a[@href='http://localhost/litecart/admin/?app=modules&doc=customer']/span[@title='Modules']");
    //private By catalog = By.xpath("//a[@href='http://localhost/litecart/admin/?app=catalog&doc=catalog']/span[@title='Catalog']");
    //private By catalog = By.xpath("//a[@href='http://localhost/litecart/admin/?app=catalog&doc=catalog']/span[@title='Catalog']");
    //private By catalog = By.xpath("//a[@href='http://localhost/litecart/admin/?app=catalog&doc=catalog']/span[@title='Catalog']");
    //private By catalog = By.xpath("//a[@href='http://localhost/litecart/admin/?app=catalog&doc=catalog']/span[@title='Catalog']");
    //private By catalog = By.xpath("//a[@href='http://localhost/litecart/admin/?app=catalog&doc=catalog']/span[@title='Catalog']");
    //private By catalog = By.xpath("//a[@href='http://localhost/litecart/admin/?app=catalog&doc=catalog']/span[@title='Catalog']");
    //private By catalog = By.xpath("//a[@href='http://localhost/litecart/admin/?app=catalog&doc=catalog']/span[@title='Catalog']");
    //private By catalog = By.xpath("//a[@href='http://localhost/litecart/admin/?app=catalog&doc=catalog']/span[@title='Catalog']");

    public void pressCustomers() {
        $(customers).click();
    }

    public void pressAppearance() {
        $(appearance).click();
    }

    public void pressCatalog() {
        $(catalog).click();
    }

    public void pressCountries() {
        $(countries).click();
    }

    public void pressCurrencies() {
        $(currencies).click();
    }

    public void pressGeoZones() {
        $(geoZones).click();
    }

    public void pressLanguages() {
        $(languages).click();
    }

    public void pressModules() {
        $(modules).click();
    }
}
