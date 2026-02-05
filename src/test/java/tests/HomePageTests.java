package tests;


import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.AboutPage;
import utilities.Driver;

public class HomePageTests {
    private HomePage homePage;
    private AboutPage aboutPage;

    @BeforeTest
    public void setUp() {
        Driver.getWebDriver().get("https://en.wikipedia.org/");
        homePage = new HomePage(Driver.getWebDriver());
        aboutPage = new AboutPage(Driver.getWebDriver());
    }

    @Test
    public void checkTitle() {
        boolean checkTitle = homePage.isTitleCorrect("Wikipedia");
        Assert.assertTrue(checkTitle, "Title is incorrect");
    }

//    @Test
//    public void loginSuccesfully(){
//        homePage.login("tomsmith", "SuperSecretPassword!");
//        Assert.assertTrue(aboutPage.isLoginSuccesful(),"Login is unsuccesful");
//    }

    @AfterTest
    public void teardown(){
        Driver.closeWebDriver();
    }

}
