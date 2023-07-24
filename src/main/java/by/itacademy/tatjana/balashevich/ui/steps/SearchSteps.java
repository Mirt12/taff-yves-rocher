package by.itacademy.tatjana.balashevich.ui.steps;

import by.itacademy.tatjana.balashevich.ui.driver.DriverSingleton;
import by.itacademy.tatjana.balashevich.ui.page.YRSearchPage;
import by.itacademy.tatjana.balashevich.ui.utils.LoadHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class SearchSteps {

    WebDriver driver;

    public SearchSteps() {
        this.driver = DriverSingleton.getDriver();
    }

    public void fillSearchFormAndSubmit(String searchWord) {
        YRSearchPage po = new YRSearchPage();
        Wait<WebDriver> wait = LoadHelper.wait30seconds();
        po.getUrl()
                .closeLanguageModalOfHomePage(wait)
                .fillSearchFieldByProduct(searchWord)
                .clickSearchBtn();
    }
}
