package elibrary.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdminThesisPage {

    @FindBy(id = "allThesises")
    public WebElement allThesisesTable;

    @FindBy(id = "publishedButton")
    public WebElement publishedThesis;

    @FindBy(id = "hiddenButton")
    public WebElement hiddenThesis;

    @FindBy(id = "editThesis")
    public WebElement actionsEditThesis;

    @FindBy(id = "enabledThesisCheckbox")
    public WebElement editEnabledButton;

    @FindAll(@FindBy(xpath = "/html/body/section/div[1]/div/table/tbody/tr"))
    public List<WebElement> allRows;

    public static AdminThesisPage init(WebDriver driver) {
        return PageFactory.initElements(driver, AdminThesisPage.class);
    }
}
