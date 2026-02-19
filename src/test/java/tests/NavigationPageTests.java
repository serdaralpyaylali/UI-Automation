package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ArticlePage;
import pages.HomePage;
import pages.SearchResultsPage;
import utilities.Driver;

public class NavigationPageTests extends BaseTest{
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
        homePage.selectLanguage("en");
        homePage.searchAndClick("Test Automation");
        articlePage.clickOnDonate();
        Assert.assertTrue(Driver.getWebDriver().getTitle().contains("donation"),"Title doesn't match");
        Assert.assertTrue(Driver.getWebDriver().getCurrentUrl().contains("/donate.wikimedia.org"),"Donation page url is not correct");
    }
    @Test(groups = {"smoke", "ui"})
    public void TC_UI_011_FooterLinkTest() {
        homePage.selectLanguage("en");
        homePage.searchAndClick("Test Automation");
        articlePage.scrollToFooter();
        articlePage.clickOnAbout();
        Assert.assertTrue(Driver.getWebDriver().getTitle().contains("About"));
        Assert.assertTrue(Driver.getWebDriver().getCurrentUrl().contains("About"));
    }
    @Test(groups = {"smoke", "ui"})
    public void TC_UI_012_BrowserBackTest() {
        homePage.selectLanguage("en");
        homePage.searchAndClick("Test Automation");
        Driver.getWebDriver().navigate().back();
        Assert.assertTrue(Driver.getWebDriver().getCurrentUrl().equals("https://www.wikipedia.org/"), "Wrong URL");
    }

    @AfterMethod
    public void teardown(){
        Driver.closeWebDriver();
    }
}