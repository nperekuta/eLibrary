package elibrary.pages;

import elibrary.tools.BaseTest;
import elibrary.templates.Header;
import elibrary.tools.LocalizationConfig;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Properties;

public class TestLoginPage extends BaseTest {

    LoginPage loginPage;
    RegisterPage registerPage;
    ThesisPage thesisPage;
    Header header;

    public static String REQUIRED_FIELD;
    public static String USERNAME_OR_PASSWORD_WARNING;
    public static String NOT_ACTIVATED_ACCOUNT;

    @BeforeClass
    public static void setLocalizationMessage() {
        Properties properties = LocalizationConfig.getPropertiesForLocalization();
        REQUIRED_FIELD = properties.getProperty("REQUIRED_FIELD");
        USERNAME_OR_PASSWORD_WARNING = properties.getProperty("USERNAME_OR_PASSWORD_WARNING");
        NOT_ACTIVATED_ACCOUNT = properties.getProperty("NOT_ACTIVATED_ACCOUNT");
    }

    @BeforeMethod
    public void beforeMethod() {
        loginPage = LoginPage.init(browser.getDriver());
        registerPage = RegisterPage.init(browser.getDriver());
        thesisPage = ThesisPage.init(browser.getDriver());
        header = Header.init(browser.getDriver());
        browser.goTo(LOGIN_URL);
        browser.sleep(5);
    }

    @Test
    public void checkElementsLoginPage(){
        Assert.assertTrue(browser.isElementPresent(loginPage.emailLogin));
        Assert.assertTrue(browser.isElementPresent(loginPage.passwordLogin));
        Assert.assertTrue(browser.isElementPresent(loginPage.rememberMe));
        Assert.assertTrue(browser.isElementPresent(loginPage.forgotPassword));
        Assert.assertTrue(browser.isElementPresent(loginPage.loginButton));
    }

    @Test
    public void testLogin() {
        loginPage.loggingIn(USER_LOGIN, USER_PASSWORD);
        browser.sleep(3);
        Assert.assertTrue(browser.isElementPresent(thesisPage.themeFilter));
    }

    @Test
    public void testLoginWithoutEmail() {
        loginPage.loggingIn("", USER_PASSWORD);
        Assert.assertEquals(loginPage.requiredFieldMessage.getText(), REQUIRED_FIELD);
    }

    @Test
    public void testLoginWithoutPassword() {
        loginPage.loggingIn(USER_LOGIN, "");
        Assert.assertEquals(loginPage.requiredFieldMessage.getText(), REQUIRED_FIELD);
    }

    @Test
    public void testLoginIncorrectEmail() {
        loginPage.loggingIn("unExistUser@elibrary.ua", USER_PASSWORD);
        Assert.assertEquals(loginPage.warningUnExistingEmail.getText(), USERNAME_OR_PASSWORD_WARNING);
    }

    @Test
    public void testLoginIncorrectPassword() {
        loginPage.loggingIn(USER_LOGIN, "11111");
        Assert.assertEquals(loginPage.requiredFieldMessage.getText(), USERNAME_OR_PASSWORD_WARNING);
    }

    @Test
    public void testLoginByNotConfirmedEmail() {
        browser.goTo(REGISTER_URL);
        registerPage.registration("newUser1@elibrary.ua", "newUser1", "newUser1");
        header.loginButton.click();
        loginPage.loggingIn("newUser@elibrary.ua", "newUser1");
        Assert.assertEquals(loginPage.warningUnExistingEmail.getText(), NOT_ACTIVATED_ACCOUNT);
    }
}
