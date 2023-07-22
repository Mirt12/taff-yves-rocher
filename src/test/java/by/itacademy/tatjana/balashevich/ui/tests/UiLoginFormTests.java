package by.itacademy.tatjana.balashevich.ui.tests;

import by.itacademy.tatjana.balashevich.ui.basetests.BaseLoginTest;
import by.itacademy.tatjana.balashevich.ui.page.YRHomePage;
import by.itacademy.tatjana.balashevich.ui.steps.YrSteps;
import by.itacademy.tatjana.balashevich.ui.utils.LoadHelper;
import by.itacademy.tatjana.balashevich.ui.utils.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;

public class UiLoginFormTests extends BaseLoginTest {

    @Test
    public void userCanOpenLoginForm() throws UnsupportedEncodingException, InterruptedException {
        YrSteps yrSteps = new YrSteps();
        yrSteps.openLoginForm();
        String actualText = LoadHelper.getTextByLocator(YRHomePage.authorizationHeaderLocator);
        Assertions.assertEquals(YRHomePage.expectedAuthorizationHeaderText, actualText);
    }

    @Test
    public void toFillLoginFormByCorrectDataTest() throws UnsupportedEncodingException, InterruptedException {
        YrSteps yrSteps = new YrSteps();
        yrSteps.fillLoginFormAndSubmit("tbalashevich@bk.ru", "PostinG@2579!");
        String actualText = LoadHelper.getTextByLocator(YRHomePage.loginGreetingLocator);
        Assertions.assertEquals(YRHomePage.expectedHeaderText, actualText);
    }

    @Test
    public void toFillLoginFormByEmptyEmailTest() throws InterruptedException {
        YrSteps yrSteps = new YrSteps();
        yrSteps.fillLoginFormAndSubmit("", "PostinG@2579!");
        String actualText = LoadHelper.getTextByLocator(YRHomePage.emailErrorLocator);
        Assertions.assertEquals(YRHomePage.expectedLoginErrorText, actualText);
    }

    @Test
    public void toFillLoginFormByEmptyPasswordTest() throws InterruptedException {
        YrSteps yrSteps = new YrSteps();
        yrSteps.fillLoginFormAndSubmit("tbalashevich@bk.ru", "");
        String actualText = LoadHelper.getTextByLocator(YRHomePage.passwordErrorLocator);
        Assertions.assertEquals(YRHomePage.expectedLoginErrorText, actualText);
    }

    @Test
    public void invalidEmailErrorTest() throws InterruptedException {
        YrSteps yrSteps = new YrSteps();
        yrSteps.fillLoginFormAndSubmit("@@@", "PostinG@2579!");
        String actualText = LoadHelper.getTextByLocator(YRHomePage.emailErrorLocator);
        Assertions.assertEquals(YRHomePage.expectedEmailErrorText, actualText);
    }

    @Test
    public void loginErrorForNotCreatedUserTest() throws InterruptedException {
        YrSteps yrSteps = new YrSteps();
        yrSteps.fillLoginFormAndSubmit(Util.generateEmail(), Util.generatePWD());
        String actualText = LoadHelper.getTextByLocator(YRHomePage.errorLocatorForNotExistUser);
        Assertions.assertEquals(YRHomePage.expectedErrorTextForNotExistUser, actualText);
    }

    @Test
    public void shortPasswordErrorTest() throws InterruptedException {
        YrSteps yrSteps = new YrSteps();
        yrSteps.fillLoginFormAndSubmit(Util.generateEmail(), "88888");
        String actualText = LoadHelper.getTextByLocator(YRHomePage.passwordErrorLocator);
        Assertions.assertEquals(YRHomePage.expectedErrorTextForShortPwd, actualText);
    }

    @Test
    public void longPasswordErrorTest() throws InterruptedException {
        YrSteps yrSteps = new YrSteps();
        yrSteps.fillLoginFormAndSubmit(Util.generateEmail(), "8888888888888888888888888888888");
        String actualText = LoadHelper.getTextByLocator(YRHomePage.passwordErrorLocator);
        Assertions.assertEquals(YRHomePage.expectedErrorTextForLongPwd, actualText);
    }
}
