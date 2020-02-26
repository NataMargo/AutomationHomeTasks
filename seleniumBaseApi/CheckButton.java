package seleniumBaseApi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CheckButton {
    private final String EXE_PATH = "C:\\webdrivers\\chromedriver.exe";

    @DataProvider(name = "getXpathButton")
    public static Object[][] getXpathButton() {
        return new Object[][]{
                {"/html/body/div/form/div[1]/div/div/button[1]"},
                {"/html/body/div/form/div[1]/div/div/button[2]"},
                {"/html/body/div/form/div[1]/div/div/button[3]"},
                {"/html/body/div/form/div[1]/div/div/button[4]"},
                {"/html/body/div/form/div[1]/div/div/button[5]"},
                {"/html/body/div/form/div[1]/div/div/button[6]"},
                {"/html/body/div/form/div[2]/div/div/div/button[1]"},
                {"/html/body/div/form/div[2]/div/div/div/button[2]"},
                {"/html/body/div/form/div[2]/div/div/div/button[3]"},
                {"/html/body/div/form/div[3]/div/div/div/button[1]"},
                {"/html/body/div/form/div[3]/div/div/div/button[2]"}

        };
    }

    @DataProvider(name = "getCss")
    public static Object[][] getCssButton() {
        return new Object[][]{
                {"body > div > form > div:nth-child(3) > div > div > div > div > div > a:nth-child(1)"},
                {"body > div > form > div:nth-child(3) > div > div > div > div > div > a:nth-child(2)"}

        };
    }


    @Test(dataProvider = "getXpathButton")
    public void clickPrimaryButton(String xPath) {
        System.setProperty("webdriver.chrome.driver", EXE_PATH);
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://formy-project.herokuapp.com/buttons");
        Actions action = new Actions(chromeDriver);
        WebElement primaryButton = chromeDriver.findElement(By.xpath(xPath));
        action.moveToElement(primaryButton);
        primaryButton.click();
        chromeDriver.close();
    }

    @Test(dataProvider = "getCss")
    public void clickDropDown(String css) {
        System.setProperty("webdriver.chrome.driver", EXE_PATH);
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chromeDriver.get("https://formy-project.herokuapp.com/buttons");
        Actions action = new Actions(chromeDriver);
        WebElement dropDownMenu = chromeDriver.findElement(By.cssSelector("#btnGroupDrop1"));
        action.moveToElement(dropDownMenu);
        dropDownMenu.click();
        WebElement dropDownItem = chromeDriver.findElement(By.cssSelector(css));
        action.moveToElement(dropDownItem);
        dropDownItem.click();
        chromeDriver.close();
    }


}

