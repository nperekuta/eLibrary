package elibrary.pages;

import elibrary.tools.BaseTest;
import elibrary.templates.Header;
import elibrary.tools.LocalizationConfig;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Properties;

public class TestRegisterPage extends BaseTest {

    RegisterPage registerPage;
    Header header;
    AdminPage adminPage;

    public static String REQUIRED_FIELD;
    public static String WARNING_EXISTING_EMAIL;
    public static String INCORRECT_EMAIL_FORMAT;
    public static String INSECURE_PASSWORD;
    public static String WEAK_PASSWORD;
    public static String CONFIRM_PASSWORD_ERROR;

    @BeforeClass
    public static void setLocalizationMessage() {
        Properties properties = LocalizationConfig.getPropertiesForLocalization();
        REQUIRED_FIELD = properties.getProperty("REQUIRED_FIELD");
        WARNING_EXISTING_EMAIL = properties.getProperty("WARNING_EXISTING_EMAIL");
        INCORRECT_EMAIL_FORMAT = properties.getProperty("INCORRECT_EMAIL_FORMAT");
        INSECURE_PASSWORD = properties.getProperty("INSECURE_PASSWORD");
        WEAK_PASSWORD = properties.getProperty("WEAK_PASSWORD");
        CONFIRM_PASSWORD_ERROR = properties.getProperty("CONFIRM_PASSWORD_ERROR");
    }

    @BeforeMethod
    public void beforeMethod() {
        registerPage = RegisterPage.init(browser.getDriver());
        adminPage = AdminPage.init(browser.getDriver());
        header = Header.init(browser.getDriver());
        browser.goTo(REGISTER_URL);
    }

    @Test
    public void checkElementsRegisterPage() {
        Assert.assertTrue(browser.isElementPresent(registerPage.emailRegister));
        Assert.assertTrue(browser.isElementPresent(registerPage.firstName));
        Assert.assertTrue(browser.isElementPresent(registerPage.lastName));
        Assert.assertTrue(browser.isElementPresent(registerPage.passwordRegister));
        Assert.assertTrue(browser.isElementPresent(registerPage.confirmPasswordRegister));
        Assert.assertTrue(browser.isElementPresent(registerPage.registerButton));
        Assert.assertTrue(browser.isElementPresent(registerPage.loginButton));
    }

    @Test
    public void testRegister() {
        registerPage.registration("newUser2@elibrary.ua", "newUser2", "newUser2");
        Assert.assertTrue(browser.isElementPresent(registerPage.successfullRegistration));
    }

    @Test
    public void testRegisterButtonLogin() {
        registerPage.loginButton.click();
        Assert.assertEquals(browser.getCurrentUrl(), LOGIN_URL);
    }

    @Test
    public void testRegisterExistingEmail() {
        Assert.assertFalse(browser.isElementPresent(registerPage.warningExistingEmail));
        registerPage.registration(ADMIN_LOGIN, "admin", "admin");
        Assert.assertEquals(registerPage.warningExistingEmail.getText(),WARNING_EXISTING_EMAIL);
    }

    @Test
    public void testRegisterByLogin() {
        Assert.assertFalse(browser.isElementPresent(registerPage.warning));
        registerPage.registration("admin", "admin", "admin");
        Assert.assertEquals(registerPage.warning.getText(),INCORRECT_EMAIL_FORMAT);
    }

    @Test
    public void testRegisterInsecurePassword() {
        Assert.assertFalse(browser.isElementPresent(registerPage.warning));
        registerPage.registration("newUser3@elibrary.ua", "777", "777");
        Assert.assertEquals(registerPage.warning.getText(),INSECURE_PASSWORD);
    }

    @Test
    public void testRegisterWithoutEmail() {
        Assert.assertFalse(browser.isElementPresent(registerPage.warning));
        registerPage.registration("", "newUser4", "newUser4");
        Assert.assertEquals(registerPage.warning.getText(),REQUIRED_FIELD);
    }

    @Test
    public void testRegisterWithoutConfirmPassword() {
        Assert.assertFalse(browser.isElementPresent(registerPage.warning));
        registerPage.registration("newUser5@elibrary.ua", "newUser5", "");
        Assert.assertEquals(registerPage.warning.getText(),REQUIRED_FIELD);
    }

    @Test
    public void testRegisterWithoutPassword() {
        Assert.assertFalse(browser.isElementPresent(registerPage.warning));
        registerPage.registration("newUser6@elibrary.ua", "", "newUser6");
        Assert.assertEquals(registerPage.warning.getText(),CONFIRM_PASSWORD_ERROR);
    }

    @Test
    public void testRegisterIncorrectConfirmation() {
        Assert.assertFalse(browser.isElementPresent(registerPage.warning));
        registerPage.registration("newUser7@elibrary.ua", "newUser7", "newUser77");
        Assert.assertEquals(registerPage.warning.getText(),CONFIRM_PASSWORD_ERROR);
    }
}
