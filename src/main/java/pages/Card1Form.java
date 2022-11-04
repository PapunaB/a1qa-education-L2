package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class Card1Form extends Form {

    private final ITextBox emailBox = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Your email']"), "Email text box");
    private final ITextBox domainBox = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Domain']"), "Domain text box");
    private final IButton domainDropdownMenuButton = getElementFactory().getButton(By.xpath("//div[@class='dropdown__field']"), "Domain dropdown menu button");
    private final ITextBox passwordBox = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Choose Password']"), "Password text box");
    private final ICheckBox acceptBox = getElementFactory().getCheckBox(By.xpath("//span[@class='checkbox__box']"), "Accept check box");
    private final IButton nextButton = getElementFactory().getButton(By.xpath("//a[@class='button--secondary']"), "Button for the next card");

    public Card1Form() {
        super(By.xpath("//div[@class='login-form__container']"), "first card form");
    }

    public void inputDataToCard1(String email, String domain, String password) {
        passwordBox.clearAndType(password);
        emailBox.clearAndType(email);
        domainBox.clearAndType(domain);
    }

    public void chooseDomain(String domain) {
        domainDropdownMenuButton.click();
        String selectedDomain = String.format("//div[@class='dropdown__list-item' and contains (text(),'%s')]",domain);
        getElementFactory().getButton(By.xpath(selectedDomain), "Domain").click();
    }

    public void acceptConditions() {
        acceptBox.click();
    }

    public Card2Form goCard2() {
        nextButton.click();
        return new Card2Form();
    }
}
