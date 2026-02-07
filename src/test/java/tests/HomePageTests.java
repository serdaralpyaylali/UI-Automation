package tests;


import org.testng.Assert;
import org.testng.annotations.*;
import pages.ArticlePage;
import pages.HomePage;
import pages.AboutPage;
import utilities.Driver;

public class HomePageTests {
    private HomePage homePage;
    private ArticlePage articlePage;

    @BeforeMethod
    public void setUp() {
        Driver.getWebDriver().get("https://www.wikipedia.org/");
        homePage = new HomePage(Driver.getWebDriver());
        articlePage = new ArticlePage(Driver.getWebDriver());
    }

    @Test(groups = {"smoke", "ui"})
    public void TC_UI_001_HomePageLoadsSuccessfully() {
        Assert.assertTrue(homePage.isTitleCorrect("Wikipedia"), "Title is incorrect");
        Assert.assertTrue(homePage.isLanguageButtonVisible(), "Language button is not displayed");
        Assert.assertTrue(homePage.isSearchBarVisible(), "Search bar is not displayed");
    }

    @Test(groups = {"smoke", "ui"})
    public void TC_UI_002_OpenArticleWithSearch() {
        homePage.selectLanguage("en");
        homePage.searchAndClick("Test Automation");
        Assert.assertTrue(Driver.getWebDriver().getCurrentUrl().contains("/wiki/"),
                "Article page did not open");
        Assert.assertTrue(articlePage.getHeading().toLowerCase().contains("Test automation".toLowerCase()),
                "Heading is incorrect");
    }
    @AfterMethod
    public void teardown(){
        Driver.closeWebDriver();
    }

}
