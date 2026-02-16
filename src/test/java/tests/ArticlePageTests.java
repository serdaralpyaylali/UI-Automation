package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ArticlePage;
import pages.HomePage;
import pages.SearchResultsPage;
import utilities.Driver;

public class ArticlePageTests {
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
    public void TC_UI_005_CheckArticleContent() {
        homePage.selectLanguage("en");
        homePage.searchAndClick("Test Automation");
        Assert.assertTrue(
                articlePage.isFirstParagraphVisible(),
                "Article content is not rendered properly");
    }
    @Test(groups = {"smoke", "ui"})
    public void TC_UI_010_EmptySearch() {

    }

    @Test(groups = {"smoke", "ui"})
    public void TC_UI_012_EmptySearch() {

    }

    @AfterMethod
    public void teardown(){
        Driver.closeWebDriver();
    }
}
