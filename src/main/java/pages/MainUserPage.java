package pages;

import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class MainUserPage extends Form {
    private final ILink card1Link = getElementFactory().getLink(By.xpath("//a[@class='start__link']"),"Link for the next page" );

    public MainUserPage() {
        super(By.xpath("//p[@class='start__paragraph']"), "Welcome page text");
    }

    public void goToGamePage() {
        card1Link.clickAndWait();
    }
}
