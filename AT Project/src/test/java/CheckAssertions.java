
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

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
        String s = "Hello";
        String s1 = "Goodbye";
        assertEquals(s, "Hello", "Not Hello");
    }

    @Test //(enabled = false)
    public void testFalse() {
        int a = 10, b = 10;
        assertNotEquals(b, a, "A aquals B");
    }

    @Test
    public void testSame() {
        String a = "10", b = "15";
        assertSame(a, b, "Not true");
    }

    @Test
    public void testNull() {
        String s = null;
        assertNull(s, "Not null");

    }

    @Test
    public void testNotNull() {
        String s = "Something";
        assertNotNull(s, "It is null");
    }

}


