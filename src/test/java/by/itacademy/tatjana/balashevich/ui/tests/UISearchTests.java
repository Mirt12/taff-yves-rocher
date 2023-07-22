package by.itacademy.tatjana.balashevich.ui.tests;

import by.itacademy.tatjana.balashevich.ui.basetests.BaseSearchTest;
import by.itacademy.tatjana.balashevich.ui.driver.DriverSingleton;
import by.itacademy.tatjana.balashevich.ui.page.YRSearchPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UISearchTests extends BaseSearchTest {

    @Test
    public void searchCremeTest() {
        YRSearchPage po = new YRSearchPage();
        po.getUrl().clickModalBtn().fillSearchFieldByValidProduct().clickSearchBtn();
        Assertions.assertEquals("Поиск продукта", po.getTextOfHeader());
        //Assertions.assertEquals("Ваш поиск «Крем» дал 57 результат(ов)", po.getTextOfInvalidSearch());
    }

    @Test
    public void searchAntaresTest() {
        YRSearchPage po = new YRSearchPage();
        po.getUrl().clickModalBtn().fillSearchFieldByInvalidProduct().clickSearchBtn();
        Assertions.assertEquals("Поиск «антарес» не дал результатов. Попробуйте снова.", po.getTextOfInvalidSearch());
    }
}
