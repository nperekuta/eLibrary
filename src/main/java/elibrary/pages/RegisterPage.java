package elibrary.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    public static final String SUCCESSFULL_REGISTRATION = "h3.text-success.text-center.menu";
    public static final String WARNING_EMAIL = "span.has-error.text-danger";
    public static final String WARNING = "span.has-error.text-danger-middle";

    @FindBy(id = "email")
    public WebElement emailRegister;

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "password")
    public WebElement passwordRegister;

    @FindBy(id = "passwordConfirm")
    public WebElement confirmPasswordRegister;

    @FindBy(xpath = "/html/body/app-root/div/app-form-wrapper/div/div/app-registration/form/fieldset/button")
    public WebElement registerButton;

    @FindBy(id = "loginRedirect")
    public WebElement loginButton;

    @FindBy(css = SUCCESSFULL_REGISTRATION)
    public WebElement successfullRegistration;

    @FindBy(css = WARNING)
    public WebElement warningExistingEmail;

    @FindBy(css = WARNING_EMAIL)
    public WebElement warning;

    public void registration(String email, String password, String confirmPassword) {
        emailRegister.sendKeys(email);
        passwordRegister.sendKeys(password);
        confirmPasswordRegister.sendKeys(confirmPassword);
        registerButton.click();
    }

    public static RegisterPage init(WebDriver driver) {
        return PageFactory.initElements(driver, RegisterPage.class);
    }
}