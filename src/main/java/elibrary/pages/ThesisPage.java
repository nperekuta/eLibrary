package elibrary.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ThesisPage {

    @FindBy(id = "themeFilter")
    public WebElement themeFilter;

    @FindBy(id = "authorFilter")
    public WebElement authorFilter;

    @FindBy(id = "nameFilter")
    public WebElement nameFilter;

    @FindBy(id = "dateFilter")
    public WebElement dateFilter;

    @FindAll(@FindBy(xpath = "/html/body/section/div[1]/div/table/tbody/tr"))
    public List<WebElement> allThesis;

    public void clearAllFilters() {
        themeFilter.clear();
        authorFilter.clear();
        nameFilter.clear();
        dateFilter.click();
    }

    public static ThesisPage init(WebDriver driver) {
        return PageFactory.initElements(driver, ThesisPage.class);
    }
}
