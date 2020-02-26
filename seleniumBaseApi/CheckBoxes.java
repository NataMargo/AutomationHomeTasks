package seleniumBaseApi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckBoxes {
    private final String EXE_PATH = "C:\\webdrivers\\chromedriver.exe";

    @DataProvider(name = "getCss")
    public static Object[][] getCss() {
        return new Object[][]{
                {"#checkbox-1"},
                {"#checkbox-2"},
                {"#checkbox-3"}

        };
    }

    @DataProvider(name = "getXPath")
    public static Object[][] getXPath() {
        return new Object[][]{
                {"/html/body/div/div[1]/div/div/input"},
                {"/html/body/div/div[2]/div/div/input"},
                {"/html/body/div/div[3]/div/div/input"}
        };
    }

    @Test(dataProvider = "getCss")
    public void clickByCss(String css) {
        System.setProperty("webdriver.chrome.driver", EXE_PATH);
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://formy-project.herokuapp.com/checkbox");
        Actions action = new Actions(chromeDriver);
        WebElement checkBox = chromeDriver.findElement(By.cssSelector(css));
        action.moveToElement(checkBox);
        checkBox.click();
        if (checkBox.isSelected()) {
            System.out.println("Checkbox is Toggled On");

        } else {
            System.out.println("Checkbox is Toggled Off");
        }
        chromeDriver.close();
    }

    @Test(dataProvider = "getXPath")
    public void clickByXPath(String path) {
        System.setProperty("webdriver.chrome.driver", EXE_PATH);
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://formy-project.herokuapp.com/checkbox");
        Actions action = new Actions(chromeDriver);
        WebElement checkBox = chromeDriver.findElement(By.xpath(path));
        checkBox.click();
        if (checkBox.isSelected()) {
            System.out.println("Checkbox is Toggled On");

        } else {
            System.out.println("Checkbox is Toggled Off");
        }
        chromeDriver.close();
    }

}

