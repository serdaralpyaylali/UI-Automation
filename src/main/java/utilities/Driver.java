package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getWebDriver() {

        if (driver == null) {

            String remoteUrl = System.getenv("SELENIUM_REMOTE_URL");

            try {

                if (remoteUrl != null && !remoteUrl.isEmpty()) {

                    ChromeOptions options = new ChromeOptions();
                    driver = new RemoteWebDriver(new URL(remoteUrl), options);

                } else {

                    driver = new ChromeDriver();
                    driver.manage().window().maximize();

                }

            } catch (Exception e) {
                throw new RuntimeException("Driver initialization failed", e);
            }
        }

        return driver;
    }

    public static void closeWebDriver() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
