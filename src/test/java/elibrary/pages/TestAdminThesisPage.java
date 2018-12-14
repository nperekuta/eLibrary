package elibrary.pages;

import elibrary.tools.BaseTest;
import elibrary.templates.Header;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAdminThesisPage extends BaseTest {
    LoginPage loginPage;
    AdminThesisPage adminThesisPage;
    Header header;

    @BeforeMethod
    public void beforeMethod() {
        header = Header.init(browser.getDriver());
        adminThesisPage = AdminThesisPage.init(browser.getDriver());
        loginPage = LoginPage.init(browser.getDriver());
        browser.goTo(LOGIN_URL);
        loginPage.loggingIn(ADMIN_LOGIN, ADMIN_PASSWORD);
    }

    @Test
    public void checkElementsOnAdminThesisPage() {
        browser.goTo(ADMIN_THESIS_URL);
        Assert.assertTrue(browser.isElementPresent(adminThesisPage.actionsEditThesis));
        Assert.assertTrue(browser.isElementPresent(adminThesisPage.editEnabledButton));
        Assert.assertTrue(browser.isElementPresent(adminThesisPage.allThesisesTable));
        Assert.assertTrue(browser.isElementPresent(adminThesisPage.hiddenThesis));
        Assert.assertTrue(browser.isElementPresent(adminThesisPage.publishedThesis));
    }
}