package by.itacademy.tatjana.balashevich.ui.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSingleton {
    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-cache", "--incognito", "--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public DriverSingleton() {
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
