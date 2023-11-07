package by.itacademy.tatjana.balashevich.ui.page;

import by.itacademy.tatjana.balashevich.ui.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import java.util.function.Function;

public class YRHomePage {
    private WebDriver driver;
    private String baseUrl = "https://www.y-r.by";
    private String loginUrl = "https://www.y-r.by/auth/login";
    private String homePageLoginLinkLocator = "//header//a[@routerlink='/auth/login']";
    private String homePageCloseLanguageModalLocator = "//button[@aria-label='Close']";
    private String btnCloseCookiesModal = "//button[@class='button button-submit']";
    private String authorizationLinkLocator = "//h2[contains(text(),'Авторизация')]";
    private String loginFormInputEmailLocator = "//input[@id='user-email']";
    private String loginFormInputPwdLocator = "//input[@id='user-password']";
    public static final String submitLoginFormButtonLocator = "//button[contains(text(),'Авторизация')]";
    public static final String emailErrorLocator = "//val-errors[@controlname='email']/div[1]";
    public static final String passwordErrorLocator = "//val-errors[@controlname='password']/div[1]";
    public static final String errorLocatorForNotExistUser = "//div[contains(text(),'Проверьте корректность введенных данных')]";
    public static final String loginGreetingLocator = "//h2[contains(text(),'Персональные данные')]";
    public static final String authorizationHeaderLocator = "//h2[contains(text(),'Авторизация')]";
    public static final String authorizeBySocialNetworksTextLocator = "//h3[contains(text(),'Авторизуйтесь через профиль в социальной сети')]";
    public static final String expectedAuthorizationHeaderText = "Авторизация";
    public static final String expectedTextForSocialNetworksAuthorization = "Авторизуйтесь через профиль в социальной сети";
    public static final String expectedLoginErrorText = "Это поле является обязательным";
    public static final String expectedEmailErrorText = "Email должен быть валидным";
    public static final String expectedErrorTextForNotExistUser = "Проверьте корректность введенных данных";
    public static final String expectedErrorTextForShortPwd = "Пароль должен быть больше 6 символов";
    public static final String expectedErrorTextForLongPwd = "Пароль должен быть не более 30 символов";
    public static final String expectedHeaderText = "Персональные данные";
    public static final String expectedSubmitButtonText = "АВТОРИЗАЦИЯ";

    public YRHomePage() {
        this.driver = DriverSingleton.getDriver();
    }

    public YRHomePage getBaseURL() {
        driver.get(baseUrl);
        return this;
    }

    public YRHomePage getLoginURL() {
        driver.get(loginUrl);
        return this;
    }

    public YRHomePage openHomePageLoginLink() {
        WebElement loginLink = driver.findElement(By.xpath(homePageLoginLinkLocator));
        loginLink.click();
        return this;
    }

    public YRHomePage closeLanguageModalOfHomePage(Wait wait) {
        WebElement btn = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(homePageCloseLanguageModalLocator));
            }
        });
        btn.click();
        return this;
    }

    public YRHomePage closeCookiesModal(Wait wait) {
        WebElement btn = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(btnCloseCookiesModal));
            }
        });
        btn.click();
        return this;
    }

    public YRHomePage clickAuthorizationLink(Wait wait) {
        WebElement authorizationLink = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(authorizationLinkLocator));
            }
        });
        authorizationLink.click();
        return this;
    }

    public YRHomePage fillInputFieldEmail(Wait wait, String email) {
        WebElement inputEmail = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(loginFormInputEmailLocator));
            }
        });
        inputEmail.sendKeys(email);
        return this;
    }

    public YRHomePage fillInputFieldPassword(String password) {
        WebElement inputPassword = driver.findElement(By.xpath(loginFormInputPwdLocator));
        inputPassword.sendKeys(password);
        return this;
    }

    public YRHomePage clickSubmitButtonOfLoginForm() {
        WebElement btn = driver.findElement(By.xpath(submitLoginFormButtonLocator));
        btn.click();
        return this;
    }
}
