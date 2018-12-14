package elibrary.pages;

import elibrary.templates.Header;
import elibrary.tools.BaseTest;
import elibrary.tools.LocalizationConfig;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;


public class TestThesisPage extends BaseTest {

    AdminPage adminPage;
    LoginPage loginPage;
    ThesisPage thesisPage;
    Header header;

    @BeforeClass
    public static void setLocalizationMessage() {
        Properties properties = LocalizationConfig.getPropertiesForLocalization();
    }


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
        Assert.assertEquals(adminPage.allRows.size(), 4);
    }
}

