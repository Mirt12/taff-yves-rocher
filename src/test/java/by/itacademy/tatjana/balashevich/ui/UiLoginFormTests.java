package by.itacademy.tatjana.balashevich.ui;

import by.itacademy.tatjana.balashevich.ui.steps.YrSteps;
import by.itacademy.tatjana.balashevich.ui.utils.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.UnsupportedEncodingException;

public class UiLoginFormTests {
    WebDriver driver;
    YrSteps yrSteps;

    @Before
    public void testSetUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-cache");
        driver = new ChromeDriver(options);
        yrSteps = new YrSteps(driver);
        driver.manage().window().maximize();
        driver.get("https://www.y-r.by/auth/login");
        yrSteps.openLoginForm();
    }

    @After
    public void testToFinish() {
        driver.quit();
    }

    @Test
    public void toFillLoginFormByCorrectData() throws UnsupportedEncodingException, InterruptedException {
        yrSteps.fillLoginFormAndSubmit("tbalashevich@bk.ru", "PostinG@2579!");
        //Wait wait = LoadHelper.wait30seconds(driver);
        Thread.sleep(5000);
        String expectedHeaderText = "Персональные данные";
        WebElement actualHeaderTextElement = driver.findElement(By.xpath("//h2[contains(text(),'Персональные данные')]"));
        String actualGreetingText = actualHeaderTextElement.getText();
        Assertions.assertEquals(expectedHeaderText, actualGreetingText);
    }

    @Test
    public void toFillLoginFormByEmptyEmail() throws InterruptedException {
        yrSteps.fillLoginFormAndSubmit("", "PostinG@2579!");
        //Wait wait = LoadHelper.wait30seconds(driver);
        Thread.sleep(5000);
        String emailErrorLocator = "//val-errors[@controlname='email']/div[1]";
        String expectedloginErrorText = "Это поле является обязательным";
        WebElement actualEmailErrorTextElement = driver.findElement(By.xpath(emailErrorLocator));
        String actualEmailErrorText = actualEmailErrorTextElement.getText();
        Assertions.assertEquals(expectedloginErrorText, actualEmailErrorText);
    }

    @Test
    public void toFillLoginFormByEmptyPassword() throws InterruptedException {
        yrSteps.fillLoginFormAndSubmit("tbalashevich@bk.ru", "");
        //Wait wait = LoadHelper.wait30seconds(driver);
        Thread.sleep(10000);
        String passwordErrorLocator = "//val-errors[@controlname='password']/div[1]";
        String expectedloginErrorText = "Это поле является обязательным";
        WebElement actualPwdErrorTextElement = driver.findElement(By.xpath(passwordErrorLocator));
        String actualPwdErrorText = actualPwdErrorTextElement.getText();
        Assertions.assertEquals(expectedloginErrorText, actualPwdErrorText);
    }

    @Test
    public void invalidEmailErrorTest() throws InterruptedException {
        yrSteps.fillLoginFormAndSubmit("@@@", "PostinG@2579!");
        //Wait wait = LoadHelper.wait30seconds(driver);
        Thread.sleep(10000);
        String emailErrorLocator = "//val-errors[@controlname='email']/div[1]";
        String expectedEmailErrorText = "Email должен быть валидным";
        WebElement actualEmailErrorTextElement = driver.findElement(By.xpath(emailErrorLocator));
        String actualEmailErrorText = actualEmailErrorTextElement.getText();
        Assertions.assertEquals(expectedEmailErrorText, actualEmailErrorText);
    }

    @Test
    public void loginErrorForNotCreatedUser() throws InterruptedException {
        yrSteps.fillLoginFormAndSubmit(Util.generateEmail(), Util.generatePWD());
        //Wait wait = LoadHelper.wait30seconds(driver);
        Thread.sleep(7000);
        String errorLocatorForNotExistUser = "//div[contains(text(),'Проверьте корректность введенных данных')]";
        WebElement actualTextElementForNotExistUser = driver.findElement(By.xpath(errorLocatorForNotExistUser));
        String actualErrorText = actualTextElementForNotExistUser.getText();
        String expectedErrorTextForNotExistUser = "Проверьте корректность введенных данных";
        Assertions.assertEquals(expectedErrorTextForNotExistUser, actualErrorText);
    }

    @Test
    public void shortPasswordErrorTest() throws InterruptedException {
        yrSteps.fillLoginFormAndSubmit(Util.generateEmail(), "88888");
        //Wait wait = LoadHelper.wait30seconds(driver);
        Thread.sleep(6000);
        String passwordErrorLocator = "//val-errors[@controlname='password']/div[1]";
        WebElement actualErrorTextElement = driver.findElement(By.xpath(passwordErrorLocator));
        String actualErrorText = actualErrorTextElement.getText();
        String expectedErrorTextForShortPwd = "Пароль должен быть больше 6 символов";
        Assertions.assertEquals(expectedErrorTextForShortPwd, actualErrorText);
    }

    @Test
    public void longPasswordErrorTest() throws InterruptedException {
        yrSteps.fillLoginFormAndSubmit(Util.generateEmail(), "8888888888888888888888888888888");
        //Wait wait = LoadHelper.wait30seconds(driver);
        Thread.sleep(6000);
        String passwordErrorLocator = "//val-errors[@controlname='password']/div[1]";
        WebElement actualErrorTextElement = driver.findElement(By.xpath(passwordErrorLocator));
        String actualErrorText = actualErrorTextElement.getText();
        String expectedErrorTextForShortPwd = "Пароль должен быть не более 30 символов";
        Assertions.assertEquals(expectedErrorTextForShortPwd, actualErrorText);
    }
}
