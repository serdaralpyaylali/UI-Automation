package pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private final WebDriver webDriver;
    private final WebDriverWait wait;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        PageFactory.initElements(webDriver, this);
    }

    //Annotations
    @FindBy(xpath = "(//span[contains(text(),'Wikipedia')])[2]")
    private WebElement logo;

    @FindBy(css = ".lang-list-button-text[data-jsl10n=\"portal.language-button-text\"]")
    private WebElement languageButton;

    @FindBy(id = "searchInput")
    private WebElement searchBar;

    @FindBy(id = "searchLanguage")
    private WebElement searchLanguage;

    @FindBy(css = ".suggestions-dropdown a")
    private List<WebElement> suggestionList;





    // Methods
    public boolean isTitleCorrect(String expectedTitle) {
        return webDriver.getTitle().equals(expectedTitle);
    }

    public boolean isLanguageButtonVisible() {
        wait.until(ExpectedConditions.visibilityOf(languageButton));
        return languageButton.isDisplayed();
    }

    public boolean isSearchBarVisible() {
        wait.until(ExpectedConditions.visibilityOf(searchBar));
        return searchBar.isDisplayed();
    }

    public void selectLanguage(String language) {
        Select select = new Select(searchLanguage);
        select.selectByValue(language);
    }
    public void searchOnly(String searchText) {
        searchBar.sendKeys(searchText);
    }

    public void searchAndClick(String searchText) {
        searchBar.sendKeys(searchText + Keys.ENTER);
    }
    public void searchEmpty() {
        searchBar.clear();
        searchBar.sendKeys( Keys.ENTER);
    }
    public int getSuggestionCount() {
        wait.until(ExpectedConditions.visibilityOfAllElements(suggestionList));
        return suggestionList.size();
    }
    public void clickFirstSuggestion() {
        wait.until(ExpectedConditions.visibilityOfAllElements(suggestionList));
        suggestionList.get(0).click();
    }
    public boolean checkResultsAreRelated() {
        if (suggestionList.isEmpty()) {
            throw new RuntimeException("Suggestion list is empty");
        }

        for (WebElement p : suggestionList) {
            String href = p.getAttribute("href");

            if (href == null || !href.toLowerCase().contains("soft")) {
                return false;
            }
        }
        return true;
    }
}

