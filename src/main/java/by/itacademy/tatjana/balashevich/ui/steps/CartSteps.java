package by.itacademy.tatjana.balashevich.ui.steps;

import by.itacademy.tatjana.balashevich.ui.driver.DriverSingleton;
import by.itacademy.tatjana.balashevich.ui.page.YRCartPage;
import by.itacademy.tatjana.balashevich.ui.utils.LoadHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class CartSteps {
    WebDriver driver;

    public CartSteps() {
        this.driver = DriverSingleton.getDriver();
    }

    public CartSteps fillSearchFormAndSubmit(String searchWord) {
        YRCartPage po = new YRCartPage();
        Wait<WebDriver> wait = LoadHelper.wait30seconds();
        po.getUrl()
                .closeLanguageModalOfHomePage(wait)
                .fillSearchFieldByProduct(searchWord)
                .clickSearchBtn();
        return this;
    }

    public CartSteps addProductToCart() {
        YRCartPage po = new YRCartPage();
        Wait<WebDriver> wait = LoadHelper.wait30seconds();
        po.clickAddToCartBtn(wait).clickLinkGoToCart(wait);
        return this;
    }
}
