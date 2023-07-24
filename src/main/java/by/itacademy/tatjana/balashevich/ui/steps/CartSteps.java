package by.itacademy.tatjana.balashevich.ui.steps;

import by.itacademy.tatjana.balashevich.ui.driver.DriverSingleton;
import by.itacademy.tatjana.balashevich.ui.page.YRCartPage;
import by.itacademy.tatjana.balashevich.ui.page.YRSearchPage;
import by.itacademy.tatjana.balashevich.ui.utils.LoadHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class CartSteps {
    WebDriver driver;

    public CartSteps() {
        this.driver = DriverSingleton.getDriver();
    }

    public void fillSearchFormAndSubmit(String searchWord) {
        YRCartPage po = new YRCartPage();
        Wait<WebDriver> wait = LoadHelper.wait30seconds();
        po.getUrl()
                .closeLanguageModalOfHomePage(wait)
                .fillSearchFieldByProduct(searchWord)
                .clickSearchBtn();
    }

    public void addProductToCart(){
       YRCartPage po = new YRCartPage();
        Wait<WebDriver> wait = LoadHelper.wait30seconds();
        po.clickAddToCartBtn().clickLinkGoToCart();
    }
}
