package by.itacademy.tatjana.balashevich.ui.page;

import by.itacademy.tatjana.balashevich.ui.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import java.util.function.Function;

public class YRSearchPage {
    private WebDriver driver;
    private String url = "https://www.y-r.by";
    private String inputSearchLocator = "//input[@placeholder='Поиск']";
    private String btnCloseLanguageModalLocator = "//ngx-smart-modal//button[@type='button']";
    private String searchBtnLocator = "//button[@aria-label='search-btn']";
    public static final String headerLocator = "//h1";
    public static final String afterSearchTextLocator = "//div [@_ngcontent-serverapp-c86='']/p[@class='number-of-products ng-star-inserted']";
    public static final String expectedHeaderText = "Поиск продукта";
    public static final String expectedTextForInvalidSearch = "Поиск «антарес» не дал результатов. Попробуйте снова.";


    public YRSearchPage() {
        this.driver = DriverSingleton.getDriver();
    }

    public YRSearchPage getUrl() {
        driver.get(url);
        return this;
    }


    public YRSearchPage closeLanguageModalOfHomePage(Wait wait) {
        WebElement btn = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(btnCloseLanguageModalLocator));
            }
        });
        btn.click();
        return this;
    }

    public YRSearchPage fillSearchFieldByProduct(String searchWord) {
        WebElement searchInputField = driver.findElement(By.xpath(inputSearchLocator));
        searchInputField.sendKeys(searchWord);
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


    public String getTextAfterSearch() {
        WebElement textElement = driver.findElement(By.xpath(afterSearchTextLocator));
        String actualText = textElement.getText();
        return actualText;
    }
}
