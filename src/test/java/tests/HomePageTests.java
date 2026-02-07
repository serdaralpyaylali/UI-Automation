package tests;


import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.AboutPage;
import utilities.Driver;

public class HomePageTests {
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        Driver.getWebDriver().get("https://www.wikipedia.org/");
        homePage = new HomePage(Driver.getWebDriver());
    }

    @Test(groups = {"smoke", "ui"})
    public void TC_UI_001_HomePageLoadsSuccessfully() {
        Assert.assertTrue(homePage.isTitleCorrect("Wikipedia"), "Title is incorrect");
        Assert.assertTrue(homePage.isLanguageButtonVisible(), "Language button is not displayed");
        Assert.assertTrue(homePage.isSearchBarVisible(), "Search bar is not displayed");
    }

    @AfterMethod
    public void teardown(){
        Driver.closeWebDriver();
    }

}
