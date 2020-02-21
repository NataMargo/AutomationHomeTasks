import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Collections;

public class UiTestCase {
    private final String EXE_PATH = "D:\\QA\\drivers\\chromedriver.exe";

    @Test
    public void verifyString() {
        System.setProperty("webdriver.chrome.driver", EXE_PATH);
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.youtube.com/");

    }

}

