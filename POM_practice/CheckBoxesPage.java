package POM_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckBoxesPage extends PageObject {

    @FindBy(id = "checkbox-1")
    static WebElement checkbox1;

    @FindBy(id = "checkbox-2")
    static WebElement checkbox2;

    @FindBy(id = "checkbox-3")
    static WebElement checkbox3;

    CheckBoxesPage(WebDriver driver) {
        super(driver);
    }

    void setCheckbox1() {
        checkbox1.click();

    }

    void setCheckbox2() {
        checkbox2.click();

    }

    void setCheckbox3() {
        checkbox3.click();
    }
}
