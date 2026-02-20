package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ArticlePage;
import pages.HomePage;
import pages.SearchResultsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class ArticlePageTests extends BaseTest {

    private HomePage homePage;
    private ArticlePage articlePage;
    private SearchResultsPage searchResultsPage;

    @BeforeMethod
    public void setUp() {
        Driver.getWebDriver().get(ConfigReader.get("base_url"));
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
    public void TC_UI_010_ChangeArticleLanguage() {
        homePage.selectLanguage("en");
        homePage.searchAndClick("Test Automation");
        articlePage.clickOnLanguage();
        articlePage.selectTurkishLanguage();
        Assert.assertTrue(Driver.getWebDriver().getCurrentUrl().contains("tr.wikipedia.org"));
        Assert.assertTrue(Driver.getWebDriver().getTitle().contains("Test otomasyon"));
    }

    @Test(groups = {"smoke", "ui"})
    public void TC_UI_012_EmptySearch() {

    }

    @AfterMethod
    public void teardown(){
        Driver.closeWebDriver();
    }
}
