package pages;

import configurations.Robot;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utils.IntGenerator;

import java.util.List;

public class Card2Form extends Form {

    private final ICheckBox unselectAllCheckBox = getElementFactory().getCheckBox(By.xpath("//label[@for='interest_unselectall']"), "Checkbox to unselect all options");
    private final ILink uploadPhoto = getElementFactory().getLink(By.xpath("//a[@class='avatar-and-interests__upload-button']"), "Uploading photo link");
    private final IButton nextButton = getElementFactory().getButton(By.xpath("//button[@class='button button--stroked button--white button--fluid']"), "Button for the next card");
    private final List<ICheckBox> allBoxes = getElementFactory().findElements(By.xpath("//label[not(contains(@for,'interest_selectall')) and not(contains(@for,'interest_unselectall'))]"), ElementType.CHECKBOX);

    public Card2Form() {
        super(By.xpath("//div[@class='avatar-and-interests__form']"), "2nd card form");
    }


    public void choosingRandomBoxes() {
        unselectAllCheckBox.click();
        int boxChosen = 0;

        while (boxChosen < 3) {
            int i = IntGenerator.getRandomInt(0, allBoxes.size()-1);
            allBoxes.get(i).click();
            allBoxes.remove(i);
            boxChosen++;
        }
    }

    public void uploadPhoto(String path) {
        uploadPhoto.click();
        Robot.uploadFile(path);
        nextButton.state().waitForDisplayed();
    }

    public Card3Form goCard3() {
        nextButton.click();
        return new Card3Form();
    }
}
