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
    private String homePageLoginLinkLocator = "//a[@href='/auth/login']";
    private String authorizationLinkLocator = "//h2[contains(text(),'Авторизация')]";
    private String loginFormInputEmailLocator = "//input[@id='user-email']";
    private String loginFormInputPwdLocator = "//input[@id='user-password']";
    private String submitLoginFormButtonLocator = "//button[contains(text(),'Авторизация')]";
    private String emailErrorLocator = "//val-errors[@controlname='email']/div[1]";
    private String passwordErrorLocator = "//val-errors[@controlname='password']/div[1]";
    private String errorLocatorForNotExistUser = "//div[contains(text(),'Проверьте корректность введенных данных')]";
    //Error messages
    private String expectedloginErrorText = "Это поле является обязательным";
    private String expectedEmailErrorText = "Email должен быть валидным";
    private String expectedErrorTextForNotExistUser = "Проверьте корректность введенных данных";
    private String expectedErrorTextForShortPwd = "Пароль должен быть больше 6 символов";


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

    public void clickButtonOfHomePageCloseLanguageModal() {
        WebElement btn = driver.findElement(By.xpath(homePageCloseLanguageModalLocator));
        btn.click();
    }

    public void clickSubmitButtonOfLoginForm() {
        WebElement btn = driver.findElement(By.xpath(submitLoginFormButtonLocator));
        btn.click();
    }
}
