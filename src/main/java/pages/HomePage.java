package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver webDriver;
    private final WebDriverWait wait;

    public HomePage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        PageFactory.initElements(webDriver, this);
    }
    //Annotations
    @FindBy(xpath = "(//span[contains(text(),'Wikipedia')])[2]")
    private WebElement logo;

    @FindBy(css = ".lang-list-button-text[data-jsl10n=\"portal.language-button-text\"]")
    private WebElement languageButton;



    // Methods
    public boolean isTitleCorrect (String expectedTitle) {
        return webDriver.getTitle().equals(expectedTitle);
    }

//    public void login (String username, String password){
//        wait.until(ExpectedConditions.visibilityOf(usernameField));
//        usernameField.sendKeys(username);
//        passwordField.sendKeys(password);
//        loginButton.click();
//    }





}
