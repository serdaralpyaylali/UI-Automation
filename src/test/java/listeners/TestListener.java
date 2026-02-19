package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.Driver;
import utilities.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        ScreenshotUtil.takeScreenshot(
                Driver.getWebDriver(),
                result.getName()
        );
    }
}
