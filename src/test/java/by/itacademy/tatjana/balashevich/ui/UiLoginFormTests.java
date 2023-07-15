package by.itacademy.tatjana.balashevich.ui;

import by.itacademy.tatjana.balashevich.ui.page.YvesRocherPage;
import by.itacademy.tatjana.balashevich.ui.steps.YrSteps;
import by.itacademy.tatjana.balashevich.ui.utils.LoadHelper;
import by.itacademy.tatjana.balashevich.ui.utils.Util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.UnsupportedEncodingException;

public class UiLoginFormTests {
    WebDriver driver;
    YrSteps yrSteps;

    @BeforeEach
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

    @AfterEach
    public void testToFinish() {
        driver.quit();
    }

    @Test
    public void toFillLoginFormByCorrectData() throws UnsupportedEncodingException, InterruptedException {
        yrSteps.fillLoginFormAndSubmit("tbalashevich@bk.ru", "PostinG@2579!");
        String actualText = LoadHelper.getTextByLocator(driver, YvesRocherPage.loginGreetingLocator);
        Assertions.assertEquals(YvesRocherPage.expectedHeaderText, actualText);
    }

    @Test
    public void toFillLoginFormByEmptyEmail() throws InterruptedException {
        yrSteps.fillLoginFormAndSubmit("", "PostinG@2579!");
        String actualText = LoadHelper.getTextByLocator(driver, YvesRocherPage.emailErrorLocator);
        Assertions.assertEquals(YvesRocherPage.expectedloginErrorText, actualText);
    }

    @Test
    public void toFillLoginFormByEmptyPassword() throws InterruptedException {
        yrSteps.fillLoginFormAndSubmit("tbalashevich@bk.ru", "");
        String actualText = LoadHelper.getTextByLocator(driver, YvesRocherPage.passwordErrorLocator);
        Assertions.assertEquals(YvesRocherPage.expectedloginErrorText, actualText);
    }

    @Test
    public void invalidEmailErrorTest() throws InterruptedException {
        yrSteps.fillLoginFormAndSubmit("@@@", "PostinG@2579!");
        String actualText = LoadHelper.getTextByLocator(driver, YvesRocherPage.emailErrorLocator);
        Assertions.assertEquals(YvesRocherPage.expectedEmailErrorText, actualText);
    }

    @Test
    public void loginErrorForNotCreatedUser() throws InterruptedException {
        yrSteps.fillLoginFormAndSubmit(Util.generateEmail(), Util.generatePWD());
        String actualText = LoadHelper.getTextByLocator(driver, YvesRocherPage.errorLocatorForNotExistUser);
        Assertions.assertEquals(YvesRocherPage.expectedErrorTextForNotExistUser, actualText);
    }

    @Test
    public void shortPasswordErrorTest() throws InterruptedException {
        yrSteps.fillLoginFormAndSubmit(Util.generateEmail(), "88888");
        String actualText = LoadHelper.getTextByLocator(driver, YvesRocherPage.passwordErrorLocator);
        Assertions.assertEquals(YvesRocherPage.expectedErrorTextForShortPwd, actualText);
    }

    @Test
    public void longPasswordErrorTest() throws InterruptedException {
        yrSteps.fillLoginFormAndSubmit(Util.generateEmail(), "8888888888888888888888888888888");
        String actualText = LoadHelper.getTextByLocator(driver, YvesRocherPage.passwordErrorLocator);
        Assertions.assertEquals(YvesRocherPage.expectedErrorTextForLongPwd, actualText);
    }
}
