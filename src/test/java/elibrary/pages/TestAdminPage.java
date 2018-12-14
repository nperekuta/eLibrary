package elibrary.pages;

import elibrary.tools.BaseTest;
import elibrary.templates.Header;
import elibrary.tools.LocalizationConfig;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;


public class TestAdminPage extends BaseTest {

    AdminPage adminPage;
    LoginPage loginPage;
    Header header;

    @BeforeClass
    public static void setLocalizationMessage() {
        Properties properties = LocalizationConfig.getPropertiesForLocalization();
    }


    @BeforeMethod
    public void beforeMethod() {
        loginPage = LoginPage.init(browser.getDriver());
        adminPage = AdminPage.init(browser.getDriver());
        header = Header.init(browser.getDriver());
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(ADMIN_LOGIN, ADMIN_PASSWORD);
    }

    @Test
    public void checkElementsAdminPage() {
        Assert.assertTrue(browser.isElementPresent(adminPage.allUsersTable));
        Assert.assertTrue(browser.isElementPresent(adminPage.actionsDeleteUser));
        Assert.assertTrue(browser.isElementPresent(adminPage.actionsEditUser));
        Assert.assertTrue(browser.isElementPresent(adminPage.disableUser));
        Assert.assertTrue(browser.isElementPresent(adminPage.enableUser));
        Assert.assertTrue(browser.isElementPresent(adminPage.editEnabledButton));
        Assert.assertTrue(browser.isElementPresent(adminPage.editRoleAdmin));
        Assert.assertTrue(browser.isElementPresent(adminPage.editRoleUser));
    }

    @Test
    public void testCountAllUsers() {
        Assert.assertEquals(adminPage.allRows.size(), 13);
    }
}

