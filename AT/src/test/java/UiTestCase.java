import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Collections;

public class UiTestCase {
     private final String exePath="D:\\QA\\drivers\\chromedriver.exe";
    @Test
    public void verifyString() {
        System.setProperty("webdriver.chrome.driver", exePath);
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.youtube.com/");

    }

}


//String exePath = "C:\\Users\\abc\\Desktop\\Server\\chromedriver.exe";
// System.setProperty("webdriver.chrome.driver", exePath);
//from selenium import webdriver
//driver = webdriver.Chrome(executable_path='C:\Users\User\Downloads\chromedriver_win32_2.0\chromedriver.exe')