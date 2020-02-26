package GrowTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GrowBbcTasks {
    private final String EXE_PATH = "C:\\webdrivers\\chromedriver.exe";

    @DataProvider(name = "getPathArticles")
    public static Object[][] getPathArticles() {
        return new Object[][]{
                {"/html/body/div[7]/div/section[3]/div/ul/li[3]"},
                {"/html/body/div[7]/div/section[3]/div/ul/li[4]"},
                {"/html/body/div[7]/div/section[3]/div/ul/li[5]"},
                {"/html/body/div[7]/div/section[3]/div/ul/li[2]"}
        };
    }


    @Test
    public void clickHeadlineButton() {
        System.setProperty("webdriver.chrome.driver", EXE_PATH);
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.bbc.com/");
        Actions action = new Actions(driver);
        WebElement newsButton = driver.findElement(By.xpath("/html/body/header/div/div[1]/nav/div/ul/li[2]/a"));
        action.moveToElement(newsButton);
        newsButton.click();
        WebElement headlineButton = driver.findElement(By.xpath("/html/body/div[7]/div/div[4]/div[2]/div/div/div/div/div[1]/div/div/div[1]/div/a/h3"));
        String elementText = headlineButton.getText();
        String expectedResult = "Europe's coronavirus outbreak spreads from Italy";
        System.out.println("actual result: " + elementText);
        Assert.assertEquals(elementText, expectedResult, "The " + elementText + " button is not an ACCEPT button");
        driver.quit();

    }

    @Test(dataProvider = "getPathArticles")
    public void clickSecondaryArticleButton(String path) {
        System.setProperty("webdriver.chrome.driver", EXE_PATH);
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.bbc.com/");
        Actions action = new Actions(driver);
        driver.manage().window().maximize();
        WebElement newsButton = driver.findElement(By.xpath(path));
        action.moveToElement(newsButton);
        newsButton.click();
        System.out.println(driver.getTitle());
        driver.quit();

    }

    @Test
    public void searchArticle() {
        System.setProperty("webdriver.chrome.driver", EXE_PATH);
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.bbc.com/news");
        Actions action = new Actions(driver);
        WebElement link = driver.findElement(By.xpath("/html/body/div[6]/div/div[4]/div[2]/div/div/div/div/div[1]/div/div/div[1]/ul/li"));
        String elementText = link.getText();
        System.out.println(elementText);
        WebElement searchField = driver.findElement(By.xpath("/html/body/header/div/div[1]/div[3]/form/div/input[1]"));
        action.moveToElement(searchField);
        searchField.click();
        searchField.sendKeys(elementText);
        WebElement searchButton = driver.findElement(By.xpath("/html/body/header/div/div[1]/div[3]/form/div/button"));
        action.moveToElement(searchButton);
        searchButton.click();
        WebElement titleArticle = driver.findElement(By.xpath("/html/body/div[6]/section[2]/ol/li[1]/article/div/h1"));
        titleArticle.getText();
        System.out.println(titleArticle.getText());
        Assert.assertTrue(true, titleArticle.getText());

        driver.quit();
    }
}