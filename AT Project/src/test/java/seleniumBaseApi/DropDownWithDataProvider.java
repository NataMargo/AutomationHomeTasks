package seleniumBaseApi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownWithDataProvider {
    private static final String EXE_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static WebDriver chromeDriver = new ChromeDriver();

    @BeforeClass
    public static void openWindow() {
        System.setProperty("webdriver.chrome.driver", EXE_PATH);
        chromeDriver.get("https://formy-project.herokuapp.com/dropdown");
    }

    @AfterClass
    public static void closeWindow() {
        chromeDriver.quit();
    }

    @DataProvider
    public static Object[][] getDropDownItem() {

        return new Object[][]{
                {"https://formy-project.herokuapp.com/autocomplete", "//div/div/a[1]"},
                {"https://formy-project.herokuapp.com/buttons", "//div/div/a[2]"},
                {"https://formy-project.herokuapp.com/checkbox", "//div/div/a[3]"},
                {"https://formy-project.herokuapp.com/datepicker", "//div/div/a[4]"},
                {"https://formy-project.herokuapp.com/dragdrop", "//div/div/a[5]"},
                // {"https://formy-project.herokuapp.com/dropdown", "//div/div/a[6]"},
                {"https://formy-project.herokuapp.com/enabled", "//div/div/a[7]"},
                {"https://formy-project.herokuapp.com/fileupload", "//div/div/a[8]"},
                {"https://formy-project.herokuapp.com/filedownload", "//div/div/a[9]"},
                {"https://formy-project.herokuapp.com/keypress", "//div/div/a[10]"},
                {"https://formy-project.herokuapp.com/modal", "//div/div/a[11]"},
                {"https://formy-project.herokuapp.com/scroll", "//div/div/a[12]"},
                {"https://formy-project.herokuapp.com/radiobutton", "//div/div/a[13]"},
                {"https://formy-project.herokuapp.com/switch-window", "//div/div/a[14]"},
                {"https://formy-project.herokuapp.com/form", "//div/div/a[15]"}
        };
    }

    @Test(dataProvider = "getDropDownItem")
    public void clickDropDownButton(String expectedUrl, String dropDownItemXpath) {
        WebElement dropDownMenu = chromeDriver.findElement(By.xpath("//*[@id='dropdownMenuButton']"));
        dropDownMenu.click();
        WebElement dropDownItem = chromeDriver.findElement(By.xpath(dropDownItemXpath));
        dropDownItem.click();
        String actualResult = chromeDriver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedUrl, "Link is not correct. Actual result is: " + actualResult + " Expected: " + expectedUrl);
        chromeDriver.navigate().back();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
}


