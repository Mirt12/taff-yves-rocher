package by.itacademy.tatjana.balashevich.ui.steps;

import by.itacademy.tatjana.balashevich.ui.driver.DriverSingleton;
import by.itacademy.tatjana.balashevich.ui.page.YRHomePage;
import by.itacademy.tatjana.balashevich.ui.utils.LoadHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class YrLoginSteps {

    WebDriver driver;

    public YrLoginSteps() {
        this.driver = DriverSingleton.getDriver();
    }

    public void openLoginForm() {
        YRHomePage page = new YRHomePage();
        Wait<WebDriver> wait = LoadHelper.wait30seconds();
        page.getBaseURL()
                .closeLanguageModalOfHomePage(wait)
                .openHomePageLoginLink()
                .clickAuthorizationLink(wait);
    }

    public void fillLoginFormAndSubmit(String email, String password) {
        YRHomePage page = new YRHomePage();
        Wait<WebDriver> wait = LoadHelper.wait30seconds();
        page.getLoginURL()
                .closeLanguageModalOfHomePage(wait)
                .clickAuthorizationLink(wait)
                .fillInputFieldEmail(wait, email)
                .fillInputFieldPassword(password)
                .clickSubmitButtonOfLoginForm();
    }
}
