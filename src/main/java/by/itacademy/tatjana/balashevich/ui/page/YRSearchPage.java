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
    private String inputSearchLocator = "//input[@placeholder='�����']";
    private String btnCloseLanguageModalLocator = "//ngx-smart-modal//button[@type='button']";
    private String btnCloseCookiesModal = "//button[@class='button button-submit']";
    private String searchBtnLocator = "//button[@aria-label='search-btn']";
    public static final String headerLocator = "//h1";
    public static final String afterSearchTextLocator = "//div [@_ngcontent-serverapp-c86='']/p[@class='number-of-products ng-star-inserted']";
    public static final String expectedHeaderText = "����� ��������";
    public static final String expectedTextForInvalidSearch = "����� �������� �� ��� �����������. ���������� �����.";


    public YRSearchPage() {
        this.driver = DriverSingleton.getDriver();
    }

    public YRSearchPage getUrl() {
        driver.get(url);
        return this;
    }


    public YRSearchPage closeCookiesModal(Wait wait) {
        WebElement btn = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(btnCloseCookiesModal));
            }
        });
        btn.click();
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
}
