package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utilities.ConfigReader;
import utilities.Driver;

@Listeners(listeners.TestListener.class)
public class BaseTest {

    @BeforeMethod
    public void setUp() {
        String browser = ConfigReader.get("browser");
        String baseUrl = ConfigReader.get("base.url");
        int timeout = Integer.parseInt(ConfigReader.get("timeout"));


    }

    @AfterMethod
    public void tearDown() {
        Driver.closeWebDriver();
    }
}
