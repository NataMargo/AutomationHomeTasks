package page_object_model_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DropDownPage extends PageObject {

    private static final String BASE_URL = "https://formy-project.herokuapp.com/";
    @FindBy(id = "dropdownMenuButton")
    private static WebElement dropDownMenu;
    @FindBy(xpath ="//div/div/a[6]" )
    public static WebElement dropDownButton;

    public DropDownPage(WebDriver driver) {
        super(driver);
    }


    public void dropDownMenuClick(){
        dropDownMenu.click();
    }
}
