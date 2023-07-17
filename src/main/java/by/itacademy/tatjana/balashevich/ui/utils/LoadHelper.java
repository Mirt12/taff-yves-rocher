package by.itacademy.tatjana.balashevich.ui.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class LoadHelper {

    public static Wait<WebDriver> wait30seconds(WebDriver driver) {
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        return fluentWait;
    }

//    public static WebDriverWait wait30seconds(WebDriver driver){
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
//        return wait;
//    }

    public static String getTextByLocator(WebDriver driver, String locator) {
        Wait<WebDriver> wait = LoadHelper.wait30seconds(driver);
        WebElement actualTextElement = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(locator));
            }
        });
        return actualTextElement.getText();
    }
}
