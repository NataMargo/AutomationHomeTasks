package POM_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DropDownPage extends PageObject {
    @FindBy(xpath = "//*[@id='dropdownMenuButton']")
    private static WebElement dropDownMenu;
    @FindBy(xpath = "//div/div/a")
    static List<WebElement> dropDownItem;
    static String[] expectedUrl = {
            "https://formy-project.herokuapp.com/autocomplete",
            "https://formy-project.herokuapp.com/buttons",
            "https://formy-project.herokuapp.com/checkbox",
            "https://formy-project.herokuapp.com/datepicker",
            "https://formy-project.herokuapp.com/dragdrop",
            "https://formy-project.herokuapp.com/dropdown",
            "https://formy-project.herokuapp.com/enabled",
            "https://formy-project.herokuapp.com/fileupload",
            "https://formy-project.herokuapp.com/filedownload",
            "https://formy-project.herokuapp.com/keypress",
            "https://formy-project.herokuapp.com/modal",
            "https://formy-project.herokuapp.com/scroll",
            "https://formy-project.herokuapp.com/radiobutton",
            "https://formy-project.herokuapp.com/switch-window",
            "https://formy-project.herokuapp.com/form"
    };


    public DropDownPage(WebDriver driver) {
        super(driver);
    }

    public static String[] getExpectedUrl(int i) {
        return expectedUrl;
    }
    public void dropDownMenuClick(){
        dropDownMenu.click();
    }
}
