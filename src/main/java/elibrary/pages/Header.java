package elibrary.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {

    public static final String HOME_BUTTON_ID = "homeButton";
    public static final String LOGIN_BUTTON_ID = "loginButton";
    public static final String LOGOUT_BUTTON_ID = "logoutButton";


    @FindBy(id = HOME_BUTTON_ID)
    public WebElement homeButton;

    @FindBy(id = LOGIN_BUTTON_ID)
    public WebElement loginButton;

    @FindBy(id = LOGOUT_BUTTON_ID)
    public WebElement logoutButton;

    public void login() {
        loginButton.click();
    }

    public void logout() {
        logoutButton.click();
    }

    public static Header init(WebDriver driver) {
        return PageFactory.initElements(driver, Header.class);
    }

}
