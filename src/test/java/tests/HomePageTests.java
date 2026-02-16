package tests;


import org.testng.Assert;
import org.testng.annotations.*;
import pages.ArticlePage;
import pages.HomePage;
import pages.SearchResultsPage;
import utilities.Driver;

public class HomePageTests {
    private HomePage homePage;
    private ArticlePage articlePage;
    private SearchResultsPage searchResultsPage;

    @BeforeMethod
    public void setUp() {
        Driver.getWebDriver().get("https://www.wikipedia.org/");
        homePage = new HomePage(Driver.getWebDriver());
        articlePage = new ArticlePage(Driver.getWebDriver());
        searchResultsPage = new SearchResultsPage(Driver.getWebDriver());

    }

    @Test(groups = {"smoke", "ui"})
    public void TC_UI_001_HomePageLoadsSuccessfully() {
        Assert.assertTrue(homePage.isTitleCorrect("Wikipedia"), "Title is incorrect");
        Assert.assertTrue(homePage.isLanguageButtonVisible(), "Language button is not displayed");
        Assert.assertTrue(homePage.isSearchBarVisible(), "Search bar is not displayed");
    }

    @Test(groups = {"smoke", "ui"})
    public void TC_UI_004_ChangeLanguageOfWebsite() {
        homePage.selectLanguage("en");
        homePage.searchAndClick("asd123");
        Assert.assertTrue(Driver.getWebDriver().getCurrentUrl().contains("en.wikipedia.org"));
        Assert.assertTrue(articlePage.getHeading().toLowerCase().contains("Search".toLowerCase()),
                "Heading is incorrect");
    }
    @Test(groups = {"smoke", "ui"})
    public void TC_UI_007_EmptySearch() {

    }

    @AfterMethod
    public void teardown(){
        Driver.closeWebDriver();
    }

}
