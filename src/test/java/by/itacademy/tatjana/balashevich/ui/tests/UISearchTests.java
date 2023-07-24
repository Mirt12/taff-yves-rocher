package by.itacademy.tatjana.balashevich.ui.tests;

import by.itacademy.tatjana.balashevich.ui.basetests.BaseSearchTest;
import by.itacademy.tatjana.balashevich.ui.page.YRHomePage;
import by.itacademy.tatjana.balashevich.ui.page.YRSearchPage;
import by.itacademy.tatjana.balashevich.ui.steps.SearchSteps;
import by.itacademy.tatjana.balashevich.ui.steps.YrLoginSteps;
import by.itacademy.tatjana.balashevich.ui.utils.LoadHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;

public class UISearchTests extends BaseSearchTest {

    @Test
    public void searchCremeTest() throws UnsupportedEncodingException, InterruptedException {
        SearchSteps ss = new SearchSteps();
        ss.fillSearchFormAndSubmit("Крем");
        String actualText = LoadHelper.getTextByLocator(YRSearchPage.headerLocator);
        Assertions.assertEquals(YRSearchPage.expectedHeaderText, actualText);
    }

    @Test
    public void searchAntaresTest() {
        SearchSteps ss = new SearchSteps();
        ss.fillSearchFormAndSubmit("антарес");
        String actualText = LoadHelper.getTextByLocator(YRSearchPage.afterSearchTextLocator);
        Assertions.assertEquals(YRSearchPage.expectedTextForInvalidSearch, actualText);
    }
}