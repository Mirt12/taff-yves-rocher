package by.itacademy.tatjana.balashevich.ui;

import by.itacademy.tatjana.balashevich.ui.driver.DriverSingleton;
import by.itacademy.tatjana.balashevich.ui.page.YRSearchPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UISearchTests {

    @Test
    public void searchPerfumeTest(){
        YRSearchPage po = new YRSearchPage();
        po.getUrl().clickModalBtn().fillSearchFieldByProduct().clickSearchBtn();
        Assertions.assertEquals("Поиск продукта", po.getTextOfHeader());
        DriverSingleton.quit();
    }


}
