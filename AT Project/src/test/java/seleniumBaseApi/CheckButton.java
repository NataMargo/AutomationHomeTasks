package seleniumBaseApi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CheckButton {
    private static final String EXE_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static WebDriver chromeDriver = new ChromeDriver();

    @BeforeClass
    public static void openWindow() {
        System.setProperty("webdriver.chrome.driver", EXE_PATH);
        chromeDriver.get("https://formy-project.herokuapp.com/buttons");
    }

    @AfterClass
    public static void closeWindow() {
        chromeDriver.quit();
    }

    @DataProvider
    public static Object[][] getXpathButton() {
        return new Object[][]{
                {"//div[@class='col-sm-8']/button[1]"},
                {"//div[@class='col-sm-8']/button[2]"},
                {"//div[@class='col-sm-8']/button[3]"},
                {"//div[@class='col-sm-8']/button[4]"},
                {"//div[@class='col-sm-8']/button[5]"},
                {"//div[@class='col-sm-8']/button[6]"},
                {"//div[@class='btn-group']/button[1]"},
                {"//div[@class='btn-group']/button[2]"},
                {"//div[@class='btn-group']/button[3]"},
                {"//div[contains(@aria-label, 'dropdown')]/button[1]"},
                {"//div[contains(@aria-label, 'dropdown')]/button[2]"}

        };
    }

    @DataProvider
    public static Object[][] getCssButton() {
        return new Object[][]{
                {" div[class='dropdown-menu show'] > a:nth-child(1)"},
                {" div[class='dropdown-menu show'] > a:nth-child(2)"}

        };
    }


    @Test(dataProvider = "getXpathButton")
    public void clickPrimaryButton(String xPath) {
        WebElement primaryButton = chromeDriver.findElement(By.xpath(xPath));
        primaryButton.click();
    }

    @Test(dataProvider = "getCssButton")
    public void clickDropDown(String cssLocator) {
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement dropDownMenu = chromeDriver.findElement(By.cssSelector("#btnGroupDrop1"));
        dropDownMenu.click();
        WebElement dropDownItem = chromeDriver.findElement(By.cssSelector(cssLocator));
        dropDownItem.click();

    }

}

