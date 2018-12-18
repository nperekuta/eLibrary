package elibrary.tools;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {

    public BrowserWrapper browser;

    public static final String HOME_URL = "http://elibrary.dominusse.com/";
    public static final String LOGIN_URL = HOME_URL.concat("auth/login");
    public static final String REGISTER_URL = HOME_URL.concat("registration");
    public static final String ADMIN_URL = HOME_URL.concat("admin");
    public static final String ADMIN_THESIS_URL = HOME_URL.concat("admin/thesis");
    public static final String THESIS_URL = HOME_URL.concat("thesis");

    public static final String ADMIN_LOGIN = "admin@elibrary.ua";
    public static final String ADMIN_PASSWORD = "admin";
    public static final String USER_LOGIN = "user@elibrary.ua";
    public static final String USER_PASSWORD = "user";

    @BeforeMethod
    public void before() {
        browser = new BrowserWrapper(BrowserInitialization.initialize());
        browser.browserMaximize();
    }

    @AfterMethod
    public void after() {
        browser.getDriver().quit();
    }
}
