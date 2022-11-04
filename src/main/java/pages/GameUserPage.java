package pages;

import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class GameUserPage extends Form {

    private final IButton sendToBottom = getElementFactory().getButton(By.xpath("//button[@class='button button--solid button--blue help-form__send-to-bottom-button']"), "Send to button");
    private final ITextBox helpForm = getElementFactory().getTextBox(By.xpath("//div[@class='help-form']"), "Help form");
    private final IButton acceptCookiesButton = getElementFactory().getButton(By.xpath("//button[@class='button button--solid button--transparent']"), "Accept cookies button");
    private final ITextBox cookiesBox = getElementFactory().getTextBox(By.xpath("//div[@class='cookies']"), "Cookies box");
    private final ITextBox timer = getElementFactory().getTextBox(By.xpath("//div[@class='timer timer--white timer--center']"), "Timer");

    public GameUserPage() {
        super(By.xpath("//div[@class='login-form__container']"), "Main form");
    }

    public Card1Form getCardForm1() {
        return new Card1Form();
    }

    public void clickHelp() {
        sendToBottom.click();
    }

    public void clickAccept() {
        acceptCookiesButton.click();
    }

    public boolean helpForm() {
        return helpForm.state().waitForDisplayed();
    }

    public boolean cookiesForm() {
        return cookiesBox.state().waitForDisplayed();
    }

    public String getTime() {
        return timer.getText();
    }
}
