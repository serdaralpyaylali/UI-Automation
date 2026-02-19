package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ArticlePage;
import pages.HomePage;
import pages.SearchResultsPage;
import utilities.Driver;

public class SearchResultsTest extends BaseTest{
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
    public void TC_UI_002_OpenArticleWithSearch() {
        homePage.selectLanguage("en");
        homePage.searchAndClick("Test Automation");
        Assert.assertTrue(Driver.getWebDriver().getCurrentUrl().contains("/wiki/"),
                "Article page did not open");
        Assert.assertTrue(articlePage.getHeading().toLowerCase().contains("Test automation".toLowerCase()),
                "Heading is incorrect");
    }

    @Test(groups = {"smoke", "ui"})
    public void TC_UI_003_WordDoesNotAppearWithSearch() {
        homePage.selectLanguage("en");
        homePage.searchAndClick("asd123");
        Assert.assertTrue(searchResultsPage.getResultText().contains("page does not exist"),
                "Article page did not appear");
        Assert.assertFalse(
                Driver.getWebDriver().getTitle().toLowerCase().contains("error"),
                "Page crashed"
        );
    }
    @Test(groups = {"smoke", "ui"})
    public void TC_UI_007_EmptySearch() {
        homePage.selectLanguage("en");
        homePage.searchEmpty();
        Assert.assertEquals(searchResultsPage.getSearchresultCount(),0,"There should be no results");
    }





    @AfterMethod
    public void teardown(){
        Driver.closeWebDriver();
    }
}
