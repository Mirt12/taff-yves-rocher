package by.itacademy.tatjana.balashevich.ui;

import by.itacademy.tatjana.balashevich.ui.driver.DriverSingleton;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseUITest {

    @BeforeEach
    public void warmUp() {
    }

    @AfterEach
    public void tearDown() {
        DriverSingleton.quit();
    }
}
