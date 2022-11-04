import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import configurations.Configuration;
import configurations.Timer;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.PasswordGenerator;
import java.io.File;

public class CheckTestCases{

    @Test
    public void testCase1() {
        Browser browser = AqualityServices.getBrowser();
        browser.goTo(Configuration.getUrl());
        browser.waitForPageToLoad();

        MainUserPage mainUserPage = new MainUserPage();
        mainUserPage.goToGamePage();
        GameUserPage gameUserPage = new GameUserPage();

        Assert.assertTrue(gameUserPage.state().waitForDisplayed(), "Opening the game page");

        Card1Form card1Form = gameUserPage.getCardForm1();
        Assert.assertTrue(card1Form.state().waitForDisplayed(), "Opening '1' card");
        card1Form.inputDataToCard1(Configuration.getEmail(), Configuration.getDomain(), PasswordGenerator.generatePassword());
        card1Form.chooseDomain(Configuration.getDomainEnd());
        card1Form.acceptConditions();

        Card2Form card2Form = card1Form.goCard2();
        Assert.assertTrue(card2Form.state().waitForDisplayed(), "Opening '2' card");
        card2Form.uploadPhoto(new File(Configuration.getPhoto()).getAbsolutePath());
        card2Form.choosingRandomBoxes();

        Card3Form cardForm3 = card2Form.goCard3();
        Assert.assertTrue(cardForm3.state().waitForDisplayed(), "Opening '3' card");

        AqualityServices.getBrowser().quit();
    }

    @Test
    public void testCase2() {
        Browser browser = AqualityServices.getBrowser();
        browser.goTo(Configuration.getUrl());
        browser.waitForPageToLoad();

        MainUserPage mainUserPage = new MainUserPage();
        Assert.assertTrue(mainUserPage.state().waitForDisplayed(),"Opening welcome page");
        mainUserPage.goToGamePage();

        GameUserPage gameUserPage = new GameUserPage();
        gameUserPage.clickHelp();
        Assert.assertFalse(gameUserPage.helpForm(), "Closing help form");

        AqualityServices.getBrowser().quit();
    }

    @Test
    public void testCase3() {
        Browser browser = AqualityServices.getBrowser();
        browser.goTo(Configuration.getUrl());
        browser.waitForPageToLoad();

        MainUserPage mainUserPage = new MainUserPage();
        Assert.assertTrue(mainUserPage.state().waitForDisplayed(),"Opening welcome page");
        mainUserPage.goToGamePage();

        GameUserPage gameUserPage = new GameUserPage();
        gameUserPage.clickAccept();
        Assert.assertFalse(gameUserPage.cookiesForm(), "Closing cookies form");

        AqualityServices.getBrowser().quit();
    }

    @Test
    public void testCase4() {
        Browser browser = AqualityServices.getBrowser();
        browser.goTo(Configuration.getUrl());
        browser.waitForPageToLoad();

        MainUserPage mainUserPage = new MainUserPage();
        Assert.assertTrue(mainUserPage.state().waitForDisplayed(),"Opening welcome page");
        mainUserPage.goToGamePage();

        GameUserPage gameUserPage = new GameUserPage();
        Assert.assertEquals(Timer.getTimeFormat(gameUserPage.getTime()), Configuration.getTimerFormat(),"Checking timer format");

        AqualityServices.getBrowser().quit();
    }
}
