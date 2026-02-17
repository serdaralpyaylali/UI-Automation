package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultsPage {
    private final WebDriver webDriver;
    private final WebDriverWait wait;

    public SearchResultsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        PageFactory.initElements(webDriver, this);
    }

    //Annotations
    @FindBy(css = "a.new")
    private WebElement result;

    @FindBy(css = ".mw-search-results-container li")
    private List<WebElement> searchresult;

    public String getResultText() {
        return result.getAttribute("title");
    }

    public int getSearchresultCount() {
        return searchresult.size();
    }
}

