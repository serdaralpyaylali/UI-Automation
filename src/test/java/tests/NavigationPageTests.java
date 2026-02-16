package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ArticlePage;
import pages.HomePage;
import pages.SearchResultsPage;
import utilities.Driver;

public class NavigationPageTests {
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
    public void TC_UI_006_HeaderLinkTest() {

    }
    @Test(groups = {"smoke", "ui"})
    public void TC_UI_011_FooterLinkTest() {

    }

    @AfterMethod
    public void teardown(){
        Driver.closeWebDriver();
    }
}