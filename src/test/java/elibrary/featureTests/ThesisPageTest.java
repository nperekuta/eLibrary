package elibrary.featureTests;

import elibrary.pages.AdminPage;
import elibrary.pages.Header;
import elibrary.pages.LoginPage;
import elibrary.pages.ThesisPage;
import elibrary.tools.Base;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ThesisPageTest extends Base {

    AdminPage adminPage;
    LoginPage loginPage;
    ThesisPage thesisPage;
    Header header;
    int thesisCount = 5;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = LoginPage.init(browser.getDriver());
        adminPage = AdminPage.init(browser.getDriver());
        thesisPage = ThesisPage.init(browser.getDriver());
        header = Header.init(browser.getDriver());
    }

    @Test
    public void checkElementsThesisPage() {
        browser.goTo(THESIS_URL);
        Assert.assertTrue(browser.isElementPresent(thesisPage.authorFilter));
        Assert.assertTrue(browser.isElementPresent(thesisPage.dateFilter));
        Assert.assertTrue(browser.isElementPresent(thesisPage.nameFilter));
        Assert.assertTrue(browser.isElementPresent(thesisPage.themeFilter));
    }

    @Test
    public void testCountAllThesis() {
        Assert.assertEquals(adminPage.allRows.size(), thesisCount);
    }
}

