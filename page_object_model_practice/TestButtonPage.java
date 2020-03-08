package page_object_model_practice;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class TestButtonPage extends BeforeTesting {
    @BeforeMethod
    public void openWindow() {
        driver.get("https://formy-project.herokuapp.com/buttons");
    }

    @Test
    public void checkButtons() {
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
        CheckButtonPage checkButtonPage = new CheckButtonPage(driver);
        checkButtonPage.dropDownItem1Click();
        checkButtonPage.dropDownItem1Click();
    }

}
