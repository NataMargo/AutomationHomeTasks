package page_object_model_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckBoxesPage extends PageObject {

    @FindBy(id = "checkbox-1")
    static WebElement checkbox_one;

    @FindBy(id = "checkbox-2")
    static WebElement checkbox_two;

    @FindBy(id = "checkbox-3")
    static WebElement checkbox_three;

    CheckBoxesPage(WebDriver driver) {
        super(driver);
    }

    void setCheckbox1() {
        checkbox_one.click();

    }

    void setCheckbox2() {
        checkbox_two.click();
    }

    void setCheckbox3() {
        checkbox_three.click();
    }
}
