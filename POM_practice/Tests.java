package POM_practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static POM_practice.CheckBoxesPage.*;
import static POM_practice.DropDownPage.dropDownItem;
import static POM_practice.DropDownPage.expectedUrl;

public class Tests extends BeforeTesting {

    @Test
    public void checkBoxes() {
        driver.get("https://formy-project.herokuapp.com/checkbox");
        CheckBoxesPage checkBoxesPage = new CheckBoxesPage(driver);
        checkBoxesPage.setCheckbox1();
        checkBoxesPage.setCheckbox2();
        checkBoxesPage.setCheckbox3();
        Assert.assertTrue(checkbox1.isSelected(), "Checkbox is toggled off");
        Assert.assertTrue(checkbox2.isSelected(), "Checkbox is toggled off");
        Assert.assertTrue(checkbox3.isSelected(), "Checkbox is toggled off");
    }

    @Test
    public void checkButtons() {
        driver.get("https://formy-project.herokuapp.com/buttons");
        CheckButtonPage checkButtonPage = new CheckButtonPage(driver);
        CheckButtonPage.primaryButton.click();
        CheckButtonPage.button1.click();
        CheckButtonPage.button2.click();
        CheckButtonPage.dangerButton.click();
        CheckButtonPage.infoButton.click();
        CheckButtonPage.leftButton.click();
        CheckButtonPage.linkButton.click();
        CheckButtonPage.middleButton.click();
        CheckButtonPage.rightButton.click();
        CheckButtonPage.successButton.click();
        CheckButtonPage.warningButton.click();
    }

    @Test
    public void checkDropDown() {
        driver.get("https://formy-project.herokuapp.com/buttons");
        CheckButtonPage checkButtonPage = new CheckButtonPage(driver);
        checkButtonPage.dropDownItem1Click();
        checkButtonPage.dropDownItem1Click();
    }

    @Test
    public void checkDropDownMenu() {
        driver.get("https://formy-project.herokuapp.com/dropdown");
        DropDownPage dropDownPage = new DropDownPage(driver);
        dropDownPage.dropDownMenuClick();
        int i = 0;
        do {
            dropDownItem.get(i).click();
            String actualUrl = driver.getCurrentUrl();
            Assert.assertEquals(actualUrl, expectedUrl[(i)], "Link is not correct. Actual result is: " + actualUrl + " Expected: " + expectedUrl[i]);
            if (!actualUrl.equals("https://formy-project.herokuapp.com/dropdown")) {
                driver.navigate().back();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }
            dropDownPage.dropDownMenuClick();
            i++;
        }
        while (i < dropDownItem.size());

    }
}
