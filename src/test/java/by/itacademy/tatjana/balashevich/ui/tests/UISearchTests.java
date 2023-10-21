package by.itacademy.tatjana.balashevich.ui.tests;

import by.itacademy.tatjana.balashevich.ui.basetests.BaseTest;
import by.itacademy.tatjana.balashevich.ui.page.YRSearchPage;
import by.itacademy.tatjana.balashevich.ui.steps.SearchSteps;
import by.itacademy.tatjana.balashevich.ui.utils.LoadHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;

public class UISearchTests extends BaseTest {

    @Test
    public void searchCremeTest() throws UnsupportedEncodingException, InterruptedException {
        SearchSteps ss = new SearchSteps();
        ss.fillSearchFormAndSubmit("Крем");
        String actualText = LoadHelper.getTextByLocator(YRSearchPage.headerLocator);
        Assertions.assertEquals(YRSearchPage.expectedHeaderText, actualText);
    }

    @Test
    public void searchAntaresTest() throws UnsupportedEncodingException, InterruptedException {
        SearchSteps ss = new SearchSteps();
        ss.fillSearchFormAndSubmit("антарес");
        Thread.sleep(5000);
        String actualText = LoadHelper.getTextByLocator(YRSearchPage.afterSearchTextLocator);
        Assertions.assertEquals(YRSearchPage.expectedTextForInvalidSearch, actualText);
    }
}
