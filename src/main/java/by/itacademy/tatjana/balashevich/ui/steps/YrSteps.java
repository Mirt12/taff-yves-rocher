package by.itacademy.tatjana.balashevich.ui.steps;

import by.itacademy.tatjana.balashevich.ui.page.YvesRocherPage;
import by.itacademy.tatjana.balashevich.ui.utils.LoadHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class YrSteps {

    WebDriver driver;

    public YrSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void fillLoginFormAndSubmit(String email, String password) {
        YvesRocherPage page = new YvesRocherPage(driver);
        Wait<WebDriver> wait = LoadHelper.wait30seconds(driver);
        page.getLoginURL()
                .closeLanguageModalOfHomePage(wait)
                .clickAuthorizationLink(wait)
                .fillInputFieldEmail(wait, email)
                .fillInputFieldPassword(password)
                .clickSubmitButtonOfLoginForm();
    }
}
