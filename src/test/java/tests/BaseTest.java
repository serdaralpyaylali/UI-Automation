package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utilities.Driver;

@Listeners(listeners.TestListener.class)
public class BaseTest {

    @BeforeMethod
    public void setUp() {
        Driver.getWebDriver();
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeWebDriver();
    }
}
