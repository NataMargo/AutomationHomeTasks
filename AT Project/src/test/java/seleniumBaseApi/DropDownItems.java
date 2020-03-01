package seleniumBaseApi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownItems {
    private static final String EXE_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static WebDriver chromeDriver = new ChromeDriver();

    @BeforeClass
    public static void openWindow() {
        System.setProperty("webdriver.chrome.driver", EXE_PATH);
        chromeDriver.get("https://formy-project.herokuapp.com/dropdown");
    }

    private String[] expectedUrl = {
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

    @Test
    public void clickDropDownButton() {

        WebElement dropDownMenu = chromeDriver.findElement(By.xpath("//*[@id='dropdownMenuButton']"));
              dropDownMenu.click();
        List<WebElement> dropDownItem = chromeDriver.findElements(By.xpath("//div/div/a"));
                int i = 0;
        do {
            dropDownItem.get(i).click();
            String actualResult = chromeDriver.getCurrentUrl();
            Assert.assertEquals(actualResult, expectedUrl[(i)], "Link is not correct. Actual result is: " + actualResult + " Expected: " + expectedUrl[i]);

            if (!actualResult.equals("https://formy-project.herokuapp.com/dropdown")) {
                chromeDriver.navigate().back();
                chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            }
            dropDownMenu.click();
            System.out.println("Actual result is: " + actualResult + " Expected: " + expectedUrl[i]);
            i++;

            i++;
        }
        while (i < dropDownItem.size());
        chromeDriver.quit();
    }
}


