package by.itacademy.tatjana.balashevich.ui.page;

import by.itacademy.tatjana.balashevich.ui.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import java.util.function.Function;

public class YRCartPage {
    private WebDriver driver;
    private String baseUrl = "https://www.y-r.by";
    private String inputSearchLocator = "//input[@placeholder='Поиск']";
    private String btnCloseLanguageModalLocator = "//ngx-smart-modal//button[@type='button']";
    private String searchBtnLocator = "//button[@aria-label='search-btn']";
    private String addToCartBtnLocator = "//button[@class='basket-btn eye-button unselectable']";


    public static final String linkGoToCartLocator = "//a[@class='basket-btn unselectable eye-button']";
    public static final String productLocatorInCart = "//a[@href='/parfyumeriya/parfyumernaya-voda-istinnyij-eliksir-pyorpl']";
    public static final String expectedProductText = "Парфюмерная вода \"Истинный эликсир пёрпл\"";

    public YRCartPage() {
        this.driver = DriverSingleton.getDriver();
    }


    public YRCartPage getUrl() {
        driver.get(baseUrl);
        return this;
    }


    public YRCartPage closeLanguageModalOfHomePage(Wait wait) {
        WebElement btn = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(btnCloseLanguageModalLocator));
            }
        });
        btn.click();
        return this;
    }

    public YRCartPage fillSearchFieldByProduct(String searchWord) {
        WebElement searchInputField = driver.findElement(By.xpath(inputSearchLocator));
        searchInputField.sendKeys(searchWord);
        return this;
    }


    public YRCartPage clickSearchBtn() {
        WebElement searchBtn = driver.findElement(By.xpath(searchBtnLocator));
        searchBtn.click();
        return this;
    }

    public YRCartPage clickAddToCartBtn(){
        WebElement btn = driver.findElement(By.xpath(addToCartBtnLocator));
        btn.click();
        return this;
    }

    public YRCartPage clickLinkGoToCart(){
        WebElement link = driver.findElement(By.xpath(linkGoToCartLocator));
        link.click();
        return this;
    }
}
