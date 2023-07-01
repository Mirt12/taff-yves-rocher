package by.itacademy.tatjana.balashevich.ui;

import by.itacademy.tatjana.balashevich.ui.methods.Util;
import by.itacademy.tatjana.balashevich.ui.page.YvesRocherPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UiLoginFormTests {
    YvesRocherPage page = new YvesRocherPage();

    @Test
    public void toFillLoginFormByCorrectData() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-cache");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.y-r.by");
        Thread.sleep(10000);
        String homePageCloseLanguageModalLocator = "//button[@aria-label='Close']";
        WebElement submitLanguageBtn = driver.findElement(By.xpath(homePageCloseLanguageModalLocator));
        submitLanguageBtn.click();
        String homePageLoginLinkLocator = "//a[@href='/auth/login']";
        WebElement loginFormLink = driver.findElement(By.xpath(homePageLoginLinkLocator));
        loginFormLink.click();
        String authorizationLinkLocator = "//h2[contains(text(),'Авторизация')]";
        Thread.sleep(10000);
        WebElement authorizationLink = driver.findElement(By.xpath(authorizationLinkLocator));
        authorizationLink.click();
        String loginFormInputEmailLocator = "//input[@id='user-email']";
        String loginFormInputPwdLocator = "//input[@id='user-password']";
        Thread.sleep(10000);
        WebElement emailInputField = driver.findElement(By.xpath(loginFormInputEmailLocator));
        emailInputField.sendKeys("tbalashevich@bk.ru");
        WebElement pwdInputField = driver.findElement(By.xpath(loginFormInputPwdLocator));
        pwdInputField.sendKeys("PostinG@2579!");
        String submitLoginFormButtonLocator = "//button[contains(text(),'Авторизация')]";
        WebElement submitLoginFormButton = driver.findElement(By.xpath(submitLoginFormButtonLocator));
        submitLoginFormButton.click();
        Thread.sleep(10000);
        String expectedHeaderText = "Персональные данные";
        WebElement actualHeaderTextElement = driver.findElement(By.xpath("//h2[contains(text(),'Персональные данные')]"));
        String actualGreetingText = actualHeaderTextElement.getText();
        Assertions.assertEquals(expectedHeaderText, actualGreetingText);
        driver.quit();
    }

    @Test
    public void toFillLoginFormByEmptyEmail() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-cache");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.y-r.by");
        Thread.sleep(10000);
        String homePageCloseLanguageModalLocator = "//button[@aria-label='Close']";
        WebElement submitLanguageBtn = driver.findElement(By.xpath(homePageCloseLanguageModalLocator));
        submitLanguageBtn.click();
        String homePageLoginLinkLocator = "//a[@href='/auth/login']";
        WebElement loginFormLink = driver.findElement(By.xpath(homePageLoginLinkLocator));
        loginFormLink.click();
        String authorizationLinkLocator = "//h2[contains(text(),'Авторизация')]";
        Thread.sleep(10000);
        WebElement authorizationLink = driver.findElement(By.xpath(authorizationLinkLocator));
        authorizationLink.click();
        String loginFormInputEmailLocator = "//input[@id='user-email']";
        String loginFormInputPwdLocator = "//input[@id='user-password']";
        Thread.sleep(10000);
        WebElement emailInputField = driver.findElement(By.xpath(loginFormInputEmailLocator));
        emailInputField.sendKeys("");
        WebElement pwdInputField = driver.findElement(By.xpath(loginFormInputPwdLocator));
        pwdInputField.sendKeys("PostinG@2579!");
        String submitLoginFormButtonLocator = "//button[contains(text(),'Авторизация')]";
        WebElement submitLoginFormButton = driver.findElement(By.xpath(submitLoginFormButtonLocator));
        submitLoginFormButton.click();
        Thread.sleep(10000);
        String emailErrorLocator = "//val-errors[@controlname='email']/div[1]";
        String expectedloginErrorText = "Это поле является обязательным";
        WebElement actualEmailErrorTextElement = driver.findElement(By.xpath(emailErrorLocator));
        String actualEmailErrorText = actualEmailErrorTextElement.getText();
        Assertions.assertEquals(expectedloginErrorText, actualEmailErrorText);
        driver.quit();
    }

    @Test
    public void toFillLoginFormByEmptyPassword() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-cache");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.y-r.by");
        Thread.sleep(10000);
        String homePageCloseLanguageModalLocator = "//button[@aria-label='Close']";
        WebElement submitLanguageBtn = driver.findElement(By.xpath(homePageCloseLanguageModalLocator));
        submitLanguageBtn.click();
        String homePageLoginLinkLocator = "//a[@href='/auth/login']";
        WebElement loginFormLink = driver.findElement(By.xpath(homePageLoginLinkLocator));
        loginFormLink.click();
        String authorizationLinkLocator = "//h2[contains(text(),'Авторизация')]";
        Thread.sleep(10000);
        WebElement authorizationLink = driver.findElement(By.xpath(authorizationLinkLocator));
        authorizationLink.click();
        String loginFormInputEmailLocator = "//input[@id='user-email']";
        String loginFormInputPwdLocator = "//input[@id='user-password']";
        Thread.sleep(10000);
        WebElement emailInputField = driver.findElement(By.xpath(loginFormInputEmailLocator));
        emailInputField.sendKeys("tbalashevich@bk.ru");
        WebElement pwdInputField = driver.findElement(By.xpath(loginFormInputPwdLocator));
        pwdInputField.sendKeys("");
        String submitLoginFormButtonLocator = "//button[contains(text(),'Авторизация')]";
        WebElement submitLoginFormButton = driver.findElement(By.xpath(submitLoginFormButtonLocator));
        submitLoginFormButton.click();
        Thread.sleep(10000);
        String passwordErrorLocator = "//val-errors[@controlname='password']/div[1]";
        String expectedloginErrorText = "Это поле является обязательным";
        WebElement actualPwdErrorTextElement = driver.findElement(By.xpath(passwordErrorLocator));
        String actualPwdErrorText = actualPwdErrorTextElement.getText();
        Assertions.assertEquals(expectedloginErrorText, actualPwdErrorText);
        driver.quit();
    }

    @Test
    public void invalidEmailErrorTest() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-cache");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.y-r.by");
        Thread.sleep(10000);
        String homePageCloseLanguageModalLocator = "//button[@aria-label='Close']";
        WebElement submitLanguageBtn = driver.findElement(By.xpath(homePageCloseLanguageModalLocator));
        submitLanguageBtn.click();
        String homePageLoginLinkLocator = "//a[@href='/auth/login']";
        WebElement loginFormLink = driver.findElement(By.xpath(homePageLoginLinkLocator));
        loginFormLink.click();
        String authorizationLinkLocator = "//h2[contains(text(),'Авторизация')]";
        Thread.sleep(10000);
        WebElement authorizationLink = driver.findElement(By.xpath(authorizationLinkLocator));
        authorizationLink.click();
        String loginFormInputEmailLocator = "//input[@id='user-email']";
        String loginFormInputPwdLocator = "//input[@id='user-password']";
        Thread.sleep(10000);
        WebElement emailInputField = driver.findElement(By.xpath(loginFormInputEmailLocator));
        emailInputField.sendKeys("@@@");
        WebElement pwdInputField = driver.findElement(By.xpath(loginFormInputPwdLocator));
        pwdInputField.sendKeys("PostinG@2579!");
        String submitLoginFormButtonLocator = "//button[contains(text(),'Авторизация')]";
        WebElement submitLoginFormButton = driver.findElement(By.xpath(submitLoginFormButtonLocator));
        submitLoginFormButton.click();
        Thread.sleep(10000);
        String emailErrorLocator = "//val-errors[@controlname='email']/div[1]";
        String expectedEmailErrorText = "Email должен быть валидным";
        WebElement actualEmailErrorTextElement = driver.findElement(By.xpath(emailErrorLocator));
        String actualEmailErrorText = actualEmailErrorTextElement.getText();
        Assertions.assertEquals(expectedEmailErrorText, actualEmailErrorText);
        driver.quit();
    }

    @Test
    public void loginErrorForNotCreatedUser() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-cache");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.y-r.by");
        Thread.sleep(10000);
        String homePageCloseLanguageModalLocator = "//button[@aria-label='Close']";
        WebElement submitLanguageBtn = driver.findElement(By.xpath(homePageCloseLanguageModalLocator));
        submitLanguageBtn.click();
        String homePageLoginLinkLocator = "//a[@href='/auth/login']";
        WebElement loginFormLink = driver.findElement(By.xpath(homePageLoginLinkLocator));
        loginFormLink.click();
        String authorizationLinkLocator = "//h2[contains(text(),'Авторизация')]";
        Thread.sleep(10000);
        WebElement authorizationLink = driver.findElement(By.xpath(authorizationLinkLocator));
        authorizationLink.click();
        String loginFormInputEmailLocator = "//input[@id='user-email']";
        String loginFormInputPwdLocator = "//input[@id='user-password']";
        Thread.sleep(7000);
        WebElement emailInputField = driver.findElement(By.xpath(loginFormInputEmailLocator));
        emailInputField.sendKeys(Util.generateEmail());
        WebElement pwdInputField = driver.findElement(By.xpath(loginFormInputPwdLocator));
        pwdInputField.sendKeys(Util.generatePWD());
        String submitLoginFormButtonLocator = "//button[contains(text(),'Авторизация')]";
        WebElement submitLoginFormButton = driver.findElement(By.xpath(submitLoginFormButtonLocator));
        submitLoginFormButton.click();
        Thread.sleep(7000);
        String errorLocatorForNotExistUser = "//div[contains(text(),'Проверьте корректность введенных данных')]";
        WebElement actualTextElementForNotExistUser = driver.findElement(By.xpath(errorLocatorForNotExistUser));
        String actualErrorText = actualTextElementForNotExistUser.getText();
        String expectedErrorTextForNotExistUser = "Проверьте корректность введенных данных";
        Assertions.assertEquals(expectedErrorTextForNotExistUser, actualErrorText);
        driver.quit();
    }

    @Test
    public void shortPasswordErrorTest() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-cache");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.y-r.by");
        Thread.sleep(10000);
        String homePageCloseLanguageModalLocator = "//button[@aria-label='Close']";
        WebElement submitLanguageBtn = driver.findElement(By.xpath(homePageCloseLanguageModalLocator));
        submitLanguageBtn.click();
        String homePageLoginLinkLocator = "//a[@href='/auth/login']";
        WebElement loginFormLink = driver.findElement(By.xpath(homePageLoginLinkLocator));
        loginFormLink.click();
        String authorizationLinkLocator = "//h2[contains(text(),'Авторизация')]";
        Thread.sleep(10000);
        WebElement authorizationLink = driver.findElement(By.xpath(authorizationLinkLocator));
        authorizationLink.click();
        String loginFormInputEmailLocator = "//input[@id='user-email']";
        String loginFormInputPwdLocator = "//input[@id='user-password']";
        Thread.sleep(6000);
        WebElement emailInputField = driver.findElement(By.xpath(loginFormInputEmailLocator));
        emailInputField.sendKeys(Util.generateEmail());
        WebElement pwdInputField = driver.findElement(By.xpath(loginFormInputPwdLocator));
        pwdInputField.sendKeys("88888");
        String submitLoginFormButtonLocator = "//button[contains(text(),'Авторизация')]";
        WebElement submitLoginFormButton = driver.findElement(By.xpath(submitLoginFormButtonLocator));
        submitLoginFormButton.click();
        Thread.sleep(6000);
        String passwordErrorLocator = "//val-errors[@controlname='password']/div[1]";
        WebElement actualErrorTextElement = driver.findElement(By.xpath(passwordErrorLocator));
        String actualErrorText = actualErrorTextElement.getText();
        String expectedErrorTextForShortPwd = "Пароль должен быть больше 6 символов";
        Assertions.assertEquals(expectedErrorTextForShortPwd, actualErrorText);
        driver.quit();
    }
    @Test
    public void longPasswordErrorTest() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-cache");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.y-r.by");
        Thread.sleep(10000);
        String homePageCloseLanguageModalLocator = "//button[@aria-label='Close']";
        WebElement submitLanguageBtn = driver.findElement(By.xpath(homePageCloseLanguageModalLocator));
        submitLanguageBtn.click();
        String homePageLoginLinkLocator = "//a[@href='/auth/login']";
        WebElement loginFormLink = driver.findElement(By.xpath(homePageLoginLinkLocator));
        loginFormLink.click();
        String authorizationLinkLocator = "//h2[contains(text(),'Авторизация')]";
        Thread.sleep(10000);
        WebElement authorizationLink = driver.findElement(By.xpath(authorizationLinkLocator));
        authorizationLink.click();
        String loginFormInputEmailLocator = "//input[@id='user-email']";
        String loginFormInputPwdLocator = "//input[@id='user-password']";
        Thread.sleep(6000);
        WebElement emailInputField = driver.findElement(By.xpath(loginFormInputEmailLocator));
        emailInputField.sendKeys(Util.generateEmail());
        WebElement pwdInputField = driver.findElement(By.xpath(loginFormInputPwdLocator));
        pwdInputField.sendKeys("8888888888888888888888888888888");
        String submitLoginFormButtonLocator = "//button[contains(text(),'Авторизация')]";
        WebElement submitLoginFormButton = driver.findElement(By.xpath(submitLoginFormButtonLocator));
        submitLoginFormButton.click();
        Thread.sleep(6000);
        String passwordErrorLocator = "//val-errors[@controlname='password']/div[1]";
        WebElement actualErrorTextElement = driver.findElement(By.xpath(passwordErrorLocator));
        String actualErrorText = actualErrorTextElement.getText();
        String expectedErrorTextForShortPwd = "Пароль должен быть не более 30 символов";
        Assertions.assertEquals(expectedErrorTextForShortPwd, actualErrorText);
        driver.quit();
    }
}
