package GrowTasks;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class GrowBbcTasks {
    private static final String EXE_PATH = "C:\\webdrivers\\chromedriver.exe";
    private static WebDriver driver = new ChromeDriver();

    @BeforeClass
    public static void openWindow() {
        System.setProperty("webdriver.chrome.driver", EXE_PATH);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.bbc.com/");
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void closeWindow() {
        driver.quit();
    }

    @DataProvider()
    public static Object[][] getPathArticles() {
        return new Object[][]{
                {"//div[contains(@data-entityid,'top-stories#3')]", "South Carolina primary: Joe Biden wins decisively - BBC News"},
                {"//div[contains(@data-entityid,'top-stories#2')]", "Coronavirus: 'Nothing ruled out' in government's virus battle tactics - BBC News"},
                {"//div[contains(@data-entityid,'top-stories#4')]", "US election: Is this the best way to pick Trump's challenger? - BBC News"},
                {"//div[contains(@data-entityid,'top-stories#5')]", "Afghan conflict: President Ashraf Ghani rejects Taliban prisoner release - BBC News"},
                {"//div[contains(@data-entityid,'top-stories#6')]", "Greece blocks 10,000 migrants at Turkey border - BBC News"}
        };
    }


    @Test
    public void clickHeadlineButton() {
        WebElement newsButton = driver.findElement(By.xpath("//li[@class='orb-nav-newsdotcom']/a"));
        newsButton.click();
        WebElement headlineButton = driver.findElement(By.xpath("//div/a/h3[contains(@class, 'title gel-paragon-bold')]"));
        String elementText = headlineButton.getText();
        String expectedResult = "S Korea sect leader faces coronavirus murder probe";
        Assert.assertEquals(elementText, expectedResult, "The " + elementText + " button is not " + expectedResult);
    }

    @Test(dataProvider = "getPathArticles")
    public void checkSecondaryArticleButton(String path, String expectedTitle) {
        WebElement newsButton = driver.findElement(By.xpath("//li[@class='orb-nav-newsdotcom']/a"));
        newsButton.click();
        WebElement secondArticle = driver.findElement(By.xpath(path));
        secondArticle.click();
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), expectedTitle, "the article is not present on the page");
    }

    @Test
    public void searchArticle() {
        WebElement newsButton = driver.findElement(By.xpath("//li[@class='orb-nav-newsdotcom']/a"));
        newsButton.click();
        WebElement link = driver.findElement(By.xpath("//*[@id=\"u875453823771859\"]//div/ul/li[2]/a"));
        String elementText = link.getText();

        WebElement searchField = driver.findElement(By.xpath("//input[@id='orb-search-q']"));
        searchField.click();
        searchField.sendKeys(elementText);

        WebElement searchButton = driver.findElement(By.xpath("//div/button[@id='orb-search-button']"));
        searchButton.click();
        WebElement titleArticle = driver.findElement(By.xpath("//li[@data-result-number='1']//h1/a"));
        titleArticle.getText();

        Assert.assertEquals("Asia Business Report: Asia Business Report (2020) - News Channel: Asia Business Report", titleArticle.getText(), "the article is not about" + elementText);

    }
}