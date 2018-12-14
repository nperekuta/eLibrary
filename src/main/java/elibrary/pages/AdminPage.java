package elibrary.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

    @FindBy(id = "allUsers")
    public WebElement allUsersTable;

    @FindBy(id = "enableButton")
    public WebElement enableUser;

    @FindBy(id = "disableButton")
    public WebElement disableUser;

    @FindBy(id = "editUser")
    public WebElement actionsEditUser;

    @FindBy(id = "enabledUserCheckbox")
    public WebElement editEnabledButton;

    @FindBy(css = "option[value=ADMIN]")
    public WebElement editRoleAdmin;

    @FindBy(css = "option[value=USER]")
    public WebElement editRoleUser;

    @FindBy(id = "deleteUser")
    public WebElement actionsDeleteUser;

    @FindAll(@FindBy(xpath = "/html/body/section/div[1]/div/table/tbody/tr"))
    public List<WebElement> allRows;

    public static AdminPage init(WebDriver driver) {
        return PageFactory.initElements(driver, AdminPage.class);
    }
}
