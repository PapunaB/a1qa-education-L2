package pages;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class Card3Form extends Form {
    public Card3Form() {
        super(By.xpath("//div[@class='personal-details__form']"), "3rd card form");
    }
}
