package page_object_model_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckButtonPage extends PageObject {
    private static final String BaseUrlA = "//div[@class='col-sm-8']/button";
    private static final String BaseUrlB = "//div[@class='btn-group']/button";
    private static final String BaseUrlC = "//div[contains(@aria-label, 'dropdown')]/button";
    private static final String BaseUrlD = " div[class='dropdown-menu show'] > a:nth-child";

    @FindBy(xpath = BaseUrlA + "[1]")
    static WebElement primaryButton;
    @FindBy(xpath = BaseUrlA + "[2]")
    static WebElement successButton;
    @FindBy(xpath = BaseUrlA + "[3]")
    static WebElement infoButton;
    @FindBy(xpath = BaseUrlA + "[4]")
    static WebElement warningButton;
    @FindBy(xpath = BaseUrlA + "[5]")
    static WebElement dangerButton;
    @FindBy(xpath =  BaseUrlA+ "[6]")
    static WebElement linkButton;
    @FindBy(xpath = BaseUrlB + "[1]")
    static WebElement leftButton;
    @FindBy(xpath = BaseUrlB + "[2]")
    static WebElement middleButton;
    @FindBy(xpath = BaseUrlB + "[3]")
    static WebElement rightButton;
    @FindBy(xpath = BaseUrlC + "[1]")
    static WebElement button1;
    @FindBy(xpath = BaseUrlC + "[2]")
    static WebElement button2;
    @FindBy(id = "btnGroupDrop1")
    static WebElement dropDownMenu;
    @FindBy(css = BaseUrlD + "(1)")
    static WebElement dropDown1;
    @FindBy(css = BaseUrlD + "(2)")
    static WebElement dropDown2;

    CheckButtonPage(WebDriver driver) {
        super(driver);
    }

    public void dropDownItem1Click() {
        dropDownMenu.click();
        dropDown1.click();
    }

    public void dropDownItem2Click() {
        dropDownMenu.click();
        dropDown2.click();
    }
}
