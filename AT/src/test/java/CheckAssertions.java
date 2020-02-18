import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class CheckAssertions {
    private final String exePath = "D:\\QA\\drivers\\chromedriver.exe";


    @Test
    public void testCaseVerifyHomePage() {
       System.setProperty("webdriver.chrome.driver", exePath);
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://google.com");
        assertEquals("Google", driver.getTitle(), "Title not matching");
    }
    @Test
    public void testCaseVerifyHomePageNegative() {
        System.setProperty("webdriver.chrome.driver", exePath);
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://google.com");
        assertEquals("Goooogle", driver.getTitle(), "Title not matching");
    }
    @Test
    public void testTrue() {
        String s="Hello";
        String s1="Goodbye";
        Assert.assertTrue(s=="Hello", "Not Hello");
        //Assert.assertTrue(s1=="Hello", "Not Hello");
    }
    @Test //(enabled = false)
    public void testFalse() {
        int a=10, b=10;
        Assert.assertFalse(a==b, "A aquals B");
    }

    @Test
    public void testBoolean()
    {
        boolean n= true;
        assertEquals(n, true, "Not true");
    }
    @Test
    public void testNull() {
        String s= "Something";
        assertNull("Not null", s);
    }

}

