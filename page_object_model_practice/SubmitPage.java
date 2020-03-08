package page_object_model_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubmitPage extends PageObject {
    public SubmitPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div/h1")
    private WebElement header;
    public String confirmationHeader(){
        return header.getText();
    }

}
