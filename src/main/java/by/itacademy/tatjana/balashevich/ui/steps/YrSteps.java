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
        YvesRocherPage yvesRocherPage = new YvesRocherPage(driver);
        Wait<WebDriver> wait = LoadHelper.wait30seconds(driver);
        yvesRocherPage.fillInputFieldEmail(wait, email);
        yvesRocherPage.fillInputFieldPassword(password);
        yvesRocherPage.clickSubmitButtonOfLoginForm();
    }

    public void openLoginForm(){
        YvesRocherPage yvesRocherPage = new YvesRocherPage(driver);
        Wait<WebDriver> wait = LoadHelper.wait30seconds(driver);
        yvesRocherPage.closeLanguageModalOfHomePage(wait);
        yvesRocherPage.clickAuthorizationLink(wait);
    }
}
