package by.itacademy.tatjana.balashevich.ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import java.util.function.Function;

public class YvesRocherPage {
    WebDriver driver;
    private String url = "https://www.y-r.by";
    private String homePageCloseLanguageModalLocator = "//button[@aria-label='Close']";
    //private String homePageLoginLinkLocator = "//a[@href='/auth/login']";
    private String authorizationLinkLocator = "//h2[contains(text(),'Авторизация')]";
    private String loginFormInputEmailLocator = "//input[@id='user-email']";
    private String loginFormInputPwdLocator = "//input[@id='user-password']";
    private String submitLoginFormButtonLocator = "//button[contains(text(),'Авторизация')]";
    public static final String emailErrorLocator = "//val-errors[@controlname='email']/div[1]";
    public static final String passwordErrorLocator = "//val-errors[@controlname='password']/div[1]";
    public static final String errorLocatorForNotExistUser = "//div[contains(text(),'Проверьте корректность введенных данных')]";
    public static final String loginGreetingLocator = "//h2[contains(text(),'Персональные данные')]";
    //Error messages
    public static final String expectedloginErrorText = "Это поле является обязательным";
    public static final String expectedEmailErrorText = "Email должен быть валидным";
    public static final String expectedErrorTextForNotExistUser = "Проверьте корректность введенных данных";
    public static final String expectedErrorTextForShortPwd = "Пароль должен быть больше 6 символов";
    public static final String expectedErrorTextForLongPwd = "Пароль должен быть не более 30 символов";
    public static final String expectedHeaderText = "Персональные данные";


    public YvesRocherPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillInputFieldEmail(Wait wait, String email) {
        WebElement inputEmail = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(loginFormInputEmailLocator));
            }
        });
        inputEmail.sendKeys(email);
    }

    public void fillInputFieldPassword(String password) {
        WebElement inputPassword = driver.findElement(By.xpath(loginFormInputPwdLocator));
        inputPassword.sendKeys(password);
    }

    public void clickSubmitButtonOfLoginForm() {
        WebElement btn = driver.findElement(By.xpath(submitLoginFormButtonLocator));
        btn.click();
    }

    public void closeLanguageModalOfHomePage(Wait wait) {
        WebElement btn = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(homePageCloseLanguageModalLocator));
            }
        });
        btn.click();
    }

    public void clickAuthorizationLink(Wait wait) {
        WebElement authorizationLink = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(authorizationLinkLocator));
            }
        });
        authorizationLink.click();
    }
}
