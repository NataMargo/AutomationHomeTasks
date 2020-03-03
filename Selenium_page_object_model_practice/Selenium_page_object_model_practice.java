package Selenium_page_object_model_practice;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class Selenium_page_object_model_practice extends FunctionalTest {
String SignUp="https://www.kimschiller.com/page-object-pattern-tutorial/index.html" ;
String ReceiptPage = "https://www.kimschiller.com/page-object-pattern-tutorial/receipt.html?";
        @Test
        public void signUp(){
            driver.get("http://www.kimschiller.com/page-object-pattern-tutorial/index.html");

            SignUpPage signUpPage = new SignUpPage(driver);
            Assert.assertEquals(SignUp, driver.getCurrentUrl(), "signUp page is not initialized");

            signUpPage.enterName("First", "Last");
            signUpPage.enterAddress("123 Street", "12345");

            ReceiptPage receiptPage = signUpPage.submit();
            Assert.assertEquals(ReceiptPage, driver.getCurrentUrl(), "Receipt page is not initialized");

            assertEquals("Thank you!", receiptPage.confirmationHeader());
        }
    }



