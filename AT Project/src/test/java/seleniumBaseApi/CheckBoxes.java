package seleniumBaseApi;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class CheckBoxes {
    private static final String EXE_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static WebDriver chromeDriver = new ChromeDriver();

    @BeforeClass
    public static void openWindow() {
        System.setProperty("webdriver.chrome.driver", EXE_PATH);
        chromeDriver.get("https://formy-project.herokuapp.com/checkbox");
    }

    @AfterClass
    public static void closeWindow() {
        chromeDriver.close();
    }

    @DataProvider
    public static Object[][] getCss() {
        return new Object[][]{
                {"#checkbox-1"},
                {"#checkbox-2"},
                {"#checkbox-3"}

        };
    }

    @DataProvider
    public static Object[][] getXPath() {
        return new Object[][]{
                {"//input[@id='checkbox-1']"},
                {"//input[@id='checkbox-2']"},
                {"//input[@id='checkbox-3']"}
        };
    }

    @Test(dataProvider = "getCss")
    public void clickByCssCheckbox(String cssLocator) {
        WebElement checkBox = chromeDriver.findElement(By.cssSelector(cssLocator));
        checkBox.click();
        Assert.assertTrue(checkBox.isSelected(), "Checkbox is toggled off");


    }

    @Test(dataProvider = "getXPath")
    public void clickByXPathCheckbox(String path) {
        WebElement checkBox = chromeDriver.findElement(By.xpath(path));
        checkBox.click();
        Assert.assertTrue(checkBox.isSelected(), "Checkbox is Toggled Off");

    }

}

