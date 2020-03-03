package POM_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckButtonPage extends PageObject {
    private static final String A = "//div[@class='col-sm-8']/button";
    private static final String B = "//div[@class='btn-group']/button";
    private static final String C = "//div[contains(@aria-label, 'dropdown')]/button";
    private static final String D = " div[class='dropdown-menu show'] > a:nth-child";

    @FindBy(xpath = A + "[1]")
    static WebElement primaryButton;
    @FindBy(xpath = A + "[2]")
    static WebElement successButton;
    @FindBy(xpath = A + "[3]")
    static WebElement infoButton;
    @FindBy(xpath = A + "[4]")
    static WebElement warningButton;
    @FindBy(xpath = A + "[5]")
    static WebElement dangerButton;
    @FindBy(xpath = A + "[6]")
    static WebElement linkButton;
    @FindBy(xpath = B + "[1]")
    static WebElement leftButton;
    @FindBy(xpath = B + "[2]")
    static WebElement middleButton;
    @FindBy(xpath = B + "[3]")
    static WebElement rightButton;
    @FindBy(xpath = C + "[1]")
    static WebElement button1;
    @FindBy(xpath = C + "[2]")
    static WebElement button2;
    @FindBy(css = "#btnGroupDrop1")
    private static WebElement dropDownMenu;
    @FindBy(css = D + "(1)")
    private static WebElement dropDown1;
    @FindBy(css = D + "(2)")
    private static WebElement dropDown2;

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
