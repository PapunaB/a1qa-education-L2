import configurations.Configuration;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        Browser browser = AqualityServices.getBrowser();
        browser.goTo(Configuration.getUrl());
        browser.waitForPageToLoad();
    }

    @AfterMethod
    public void browserQuit() {
        if ( AqualityServices.isBrowserStarted() ) {
            AqualityServices.getBrowser().quit();
        }
    }
}
