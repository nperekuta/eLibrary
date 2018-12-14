package elibrary.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "email")
    public WebElement emailLogin;

    @FindBy(id = "password")
    public WebElement passwordLogin;

    @FindBy(xpath = "/html/body/app-root/div/app-form-wrapper/div/div/app-login-form/form/fieldset/div[3]/label")
    public WebElement rememberMe;

    @FindBy(css = "btn.btn-link.pull-right.text-right")
    public WebElement forgotPassword;

    @FindBy(css = "btn.btn-lg.btn-primary.btn-block")
    public WebElement loginButton;

    @FindBy(css = "btn.btn-lg.btn-primary.btn-left")
    public WebElement requiredFieldMessage;

    @FindBy(css = "email-error")
    public WebElement warningUnExistingEmail;

    public void loggingIn(String email, String password) {
        emailLogin.sendKeys(email);
        passwordLogin.sendKeys(password);
        loginButton.click();
    }

    public static LoginPage init(WebDriver driver) {
        return PageFactory.initElements(driver, LoginPage.class);
    }
}
