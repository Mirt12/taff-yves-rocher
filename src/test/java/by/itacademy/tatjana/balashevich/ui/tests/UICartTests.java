package by.itacademy.tatjana.balashevich.ui.tests;

import by.itacademy.tatjana.balashevich.ui.basetests.BaseTest;
import by.itacademy.tatjana.balashevich.ui.page.YRCartPage;
import by.itacademy.tatjana.balashevich.ui.steps.CartSteps;
import by.itacademy.tatjana.balashevich.ui.utils.LoadHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;

public class UICartTests extends BaseTest {

    @Test
    public void isProductinTheCartTest() throws UnsupportedEncodingException, InterruptedException {
        CartSteps cs = new CartSteps();
        cs.fillSearchFormAndSubmit("Истинный эликсир пёрпл");
        cs.addProductToCart();
        String actualText = LoadHelper.getTextByLocator(YRCartPage.productLocatorInCart);
        Assertions.assertEquals(YRCartPage.expectedProductText, actualText);
    }
}
