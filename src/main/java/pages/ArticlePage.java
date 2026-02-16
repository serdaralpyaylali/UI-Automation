package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ArticlePage {
    private final WebDriver webDriver;
    private final WebDriverWait wait;

    public ArticlePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        PageFactory.initElements(webDriver, this);
    }

    //Annotations
    @FindBy(id="firstHeading")
    private WebElement heading;

    @FindBy(css = "#mw-content-text p")
    private List<WebElement> paragraphs;

    public String getHeading() {
        return heading.getText();
    }
    public WebElement getFirstNonEmptyParagraph() {
        for (WebElement p : paragraphs) {
            if (!p.getText().trim().isEmpty()) {
                return p;
            }
        }
        throw new RuntimeException("No non-empty paragraph found");
    }
    public boolean isFirstParagraphVisible() {
        WebElement paragraph = getFirstNonEmptyParagraph();
        return paragraph.isDisplayed() && !paragraph.getText().trim().isEmpty();
    }
}
