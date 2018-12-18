package elibrary.featureTests;

import elibrary.pages.AdminPage;
import elibrary.pages.Header;
import elibrary.pages.LoginPage;
import elibrary.tools.Base;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AdminPageTest extends Base {

    AdminPage adminPage;
    LoginPage loginPage;
    Header header;
    int usersCount =5;

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
        Assert.assertEquals(adminPage.allRows.size(), usersCount);
    }
}

