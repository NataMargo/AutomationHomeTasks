
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CheckEmailHappyPath extends Email{
    public static class DataProviderTest {

        @Test(dataProvider = "getEmail")

        public void CheckCorrectEmail(String email) {
            //System.setProperty("webdriver.chrome.driver", exePath);
            // WebDriver driver = new ChromeDriver();
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Boolean actualResult = Email.isEmailCorrect(email);
            Assert.assertTrue(actualResult, "This is an incorrect email!");
        }
        @DataProvider(name = "getEmail")

        public static Object[][] getEmails() {
            return new Object[][]{{"Test@123.com"}, {"A_b1!@ukr.net"},{"Test@TEST.net"}};
        }
    }
}