package by.itacademy.tatjana.balashevich.ui.page;

import by.itacademy.tatjana.balashevich.ui.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YRSearchPage {
    private WebDriver driver;
    private String url = "https://www.y-r.by";
    private String inputSearchLocator = "//input[@placeholder='Поиск']";
    private String btnCloseLanguageModalLocator = "//ngx-smart-modal//button[@type='button']";
    private String searchBtnLocator = "//button[@aria-label='search-btn']";
    private String headerLocator = "//h1";
    private String invalidSearchLocator = "//app-product-list//p";


    public YRSearchPage() {
        this.driver = DriverSingleton.getDriver();
    }

    public YRSearchPage getUrl() {
        driver.get(url);
        return this;
    }

    public YRSearchPage clickModalBtn() {
        WebElement modalBtn = driver.findElement(By.xpath(btnCloseLanguageModalLocator));
        modalBtn.click();
        return this;
    }

    public YRSearchPage fillSearchFieldByValidProduct() {
        WebElement searchInputField = driver.findElement(By.xpath(inputSearchLocator));
        searchInputField.sendKeys("Крем");
        return this;
    }

    public YRSearchPage fillSearchFieldByInvalidProduct() {
        WebElement searchInputField = driver.findElement(By.xpath(inputSearchLocator));
        searchInputField.sendKeys("антарес");
        return this;
    }

    public YRSearchPage clickSearchBtn() {
        WebElement searchBtn = driver.findElement(By.xpath(searchBtnLocator));
        searchBtn.click();
        return this;
    }

    public String getTextOfHeader() {
        WebElement header = driver.findElement(By.xpath(headerLocator));
        String actualText = header.getText();
        return actualText;
    }


    public String getTextOfInvalidSearch() {
        WebElement textElement = driver.findElement(By.xpath(invalidSearchLocator));
        String actualText = textElement.getText();
        return actualText;
    }
}
