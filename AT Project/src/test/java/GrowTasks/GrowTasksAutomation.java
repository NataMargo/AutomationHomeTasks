package GrowTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GrowTasksAutomation {
    private final String EXE_PATH = "C:\\webdrivers\\chromedriver.exe";


    @Test
    public void clickCreateButton() {
        System.setProperty("webdriver.chrome.driver", EXE_PATH);
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com/");
        Actions action = new Actions(driver);
        WebElement createButton = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div/div/div[2]/div/div[2]/div/div/div/div[2]/a"));
        action.moveToElement(createButton);
        createButton.click();
        driver.close();
    }

    @Test
    public void checkText() {
        System.setProperty("webdriver.chrome.driver", EXE_PATH);
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.epam.com/");
        driver.manage().window().maximize();
        WebElement button = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/button/span"));
        String elementText = button.getText();
        String expectedResult = "ACCEPT";
        System.out.println("actual result: " + elementText);
        Assert.assertEquals(elementText, expectedResult, "The " + elementText + " button is not an ACCEPT button");
        driver.quit();
    }


}


